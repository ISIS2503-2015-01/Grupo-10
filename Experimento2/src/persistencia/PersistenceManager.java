/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.lang.reflect.Method;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;



/**
 *
 * @author estudiante
 */
public class PersistenceManager {
	
	private static boolean generateId;
	
	/**
	 * 
	 * @return
	 * @throws URISyntaxException
	 * @throws SQLException
	 */
	public static Connection getConnection() throws URISyntaxException, SQLException {
		
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		/*
		 * Uncomment before heroku deploy, use on final release
		 */
		//URI dbUri = new URI(System.getenv("DATABASE_URL"));

		
		/*
		 *	Local test only, comment before deploy.
		 * 	Delete before final release
		 */
		
		URI dbUri = new URI("postgres://hjqjfdctvaqogl:3hFVMB5Rs5HA_lQZkGT2vmYa6r@ec2-107-22-161-155.compute-1.amazonaws.com:5432/d8k5uaqb9190ta");
		
	    String username = dbUri.getUserInfo().split(":")[0];
	    String password = dbUri.getUserInfo().split(":")[1];
	    
	    /*
	     * For local test only.
	     */
	    String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath() + "?ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory";
	    
	    /*
	     * Uncomment before heroku deploy. Use on final release.
	     */
	    //String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath(); 

	    return DriverManager.getConnection(dbUrl, username, password);
	}
	
	/**
	 * 
	 * @param cls
	 * @return
	 * @throws Exception
	 */
	public JSONArray getAll(Class cls) throws Exception {
		System.out.println("*****");
		String className = cls.getSimpleName();
		Connection connection = getConnection();
		Statement stmt = connection.createStatement();
		
		String query = "SELECT * FROM "+className+"s" ;
		System.out.println(query);
		ResultSet rs = stmt.executeQuery(query);
		System.out.println("/////");
		
		connection.close();
		return convertResultSetIntoJSON(rs);
		
	}
	
	/**
	 * 
	 * @param cls
	 * @return
	 * @throws Exception
	 */
	public JSONArray getById(Class cls, String id) throws Exception {
		
		String className = cls.getSimpleName();
		Connection connection = getConnection();
		Statement stmt = connection.createStatement();
		
		String query = "SELECT * FROM "+className+"s WHERE ID="+"'"+id+"'" ;
		System.out.println(query);
		ResultSet rs = stmt.executeQuery(query);
		connection.close();
		return convertResultSetIntoJSON(rs);
	}
	
	public JSONArray getById(Class cls, String id, String columnName) throws Exception {
		
		String className = cls.getSimpleName();
		Connection connection = getConnection();
		Statement stmt = connection.createStatement();
		
		String query = "SELECT * FROM "+className+"s WHERE "+columnName+"="+"'"+id+"'" ;
		System.out.println(query);
		ResultSet rs = stmt.executeQuery(query);
		connection.close();
		return convertResultSetIntoJSON(rs);
	}
	
	/**
	 * 
	 * @param obj
	 * @throws Exception
	 */
	public void persist(Object obj) throws Exception {
		
		String objectName = getClassName(obj);
		
		ArrayList<String> columnsAndValues = getColumnsAndValues(obj);
		String columnNames = columnsAndValues.get(0);
		String values = columnsAndValues.get(1);
		
		Connection connection = getConnection();
		
		Statement stmt = connection.createStatement();
		
		
		if (!generateId) { 
			
			String create = "CREATE TABLE IF NOT EXISTS " + objectName + "s ("+columnNames.substring(0, columnNames.length()-1) +")";
			System.out.println(create);
			stmt.executeUpdate(create);
			
			String insert = "INSERT INTO " + objectName + "s VALUES ("+values.substring(0, values.length()-1)+")";
			System.out.println(insert);
			stmt.executeUpdate(insert);
		} else {
			
			String create = "CREATE TABLE IF NOT EXISTS " + objectName + "s (ID VARCHAR(255) NOT NULL,"+columnNames.substring(0, columnNames.length()-1) +")";
			System.out.println(create);
			stmt.executeUpdate(create);
			
			JSONArray currentContent = getAll(obj.getClass());
			int currentElements = currentContent.length();
			String insert = "INSERT INTO " + objectName + "s VALUES ('"+currentElements+"',"+values.substring(0, values.length()-1)+")";
			System.out.println(insert);
			stmt.executeUpdate(insert);
		}
		
		connection.close();
		
	}
	
	/**
	 * 
	 * @param obj
	 * @param id
	 * @throws Exception
	 */
	public void update(Object obj, String id) throws Exception {
		
		String objectName = getClassName(obj);
		
		String columnValue = getColumnValueString(obj);
		
		Connection connection = getConnection();
		
		Statement stmt = connection.createStatement();
		
		String update = "UPDATE " + objectName + "s SET "+columnValue.substring(0, columnValue.length()-1) + " WHERE ID="+"'"+id+"'";
		System.out.println(update);
		stmt.executeUpdate(update);
		connection.close();
	}
	
	/**
	 * 
	 * @param cls
	 * @param id
	 * @throws Exception
	 */
	public void delete(Class cls, String id) throws Exception{
		
		String objectName = cls.getSimpleName();
		
		Connection connection = getConnection();
		Statement stmt = connection.createStatement();
		
		String delete = "DELETE FROM " + objectName + "s WHERE ID="+"'"+id+"'";
		System.out.println(delete);
		stmt.executeUpdate(delete);
		
		connection.close();
	}
	
	/**
	 * 
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	private ArrayList<String> getColumnsAndValues(Object obj) throws Exception{
		
		Method[] methods = obj.getClass().getMethods();
		String columnNames = "";
		String values = "";
		
		for(Method method : methods){
		    if(isGetter(method)){
		    	System.out.println("Getter: " + method.getName());
		    	Object returnValue = method.invoke(obj);
		    	System.out.println("Return value: " + returnValue);
		    	String value = returnValue.toString();
		    	values += "'"+value+"'"+",";
		    	String attrName = method.getName().substring(3);
		    	columnNames += attrName + " VARCHAR(255) NOT NULL,";
		    }
		}
		ArrayList<String> res = new ArrayList<String>();
		res.add(columnNames);
		res.add(values);
		return res;
	}
	
	/**
	 * 
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	private String getColumnValueString(Object obj) throws Exception{
		
		Method[] methods = obj.getClass().getMethods();
		
		String result = "";
		
		for(Method method : methods){
		    if(isGetter(method)){
		    	Object returnValue = method.invoke(obj);
		    	String value = returnValue.toString();
		    	
		    	String attrName = method.getName().substring(3);
		    	
		    	result += attrName + " = '"+value+"',";
		    }
		}
		
		return result;
	}
	
	/**
	 * 
	 * @param obj
	 * @return
	 */
	private String getClassName(Object obj){
		return obj.getClass().getSimpleName();
	}
	
	/**
	 * 
	 * @param resultSet
	 * @return
	 * @throws Exception
	 */
	public static JSONArray convertResultSetIntoJSON(ResultSet resultSet) throws Exception {
		System.out.println("Convert into JSON 1");
        JSONArray jsonArray = new JSONArray();
        while (resultSet.next()) {
            int total_rows = resultSet.getMetaData().getColumnCount();
            JSONObject obj = new JSONObject();
            for (int i = 0; i < total_rows; i++) {
                String columnName = resultSet.getMetaData().getColumnLabel(i + 1).toLowerCase();
                Object columnValue = resultSet.getObject(i + 1);
                // if value in DB is null, then we set it to default value
                if (columnValue == null){
                    columnValue = "null";
                }
                /*
                Next if block is a hack. In case when in db we have values like price and price1 there's a bug in jdbc - 
                both this names are getting stored as price in ResulSet. Therefore when we store second column value,
                we overwrite original value of price. To avoid that, i simply add 1 to be consistent with DB.
                 */
                if (obj.has(columnName)){
                    columnName += "1";
                }
                obj.put(columnName, columnValue);
            }
            jsonArray.put(obj);
        }
        System.out.println("Convert into JSON 2");
        return jsonArray;
    }
	
	/**
	 * 
	 * @param method
	 * @return
	 */
	private static boolean isGetter(Method method) {
		
	      if(method.getName().equalsIgnoreCase("getid")) {
			  generateId = true;
			  return false;
		  }
		  if (!method.getName().startsWith("get"))   
			  return false;
		  if (method.getName().contains("Class"))
			  return false;
		  if (method.getParameterTypes().length != 0)   
			  return false;  
		  if (void.class.equals(method.getReturnType())) 
				  return false;
		  return true;
	}
}
