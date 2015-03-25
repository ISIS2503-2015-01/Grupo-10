/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupo10.pscm.models;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import org.eclipse.persistence.nosql.annotations.DataFormatType;
import org.eclipse.persistence.nosql.annotations.Field;
import org.eclipse.persistence.nosql.annotations.NoSql;

/**
 *
 * @author estudiante
 */
@Entity
public class Paciente 
{
     private static final long serialVersionUID = 1L;
     
     
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Field(name="_id")
    private int id;
    
    private String apellido;
    
    private String genero;  
  
    private String  nombre;
       
    private String direccion;
    
    private String telefonoFijo;
    
    private String telefonoCelular;  
     
    //private ArrayList<Episodio> episodios;

    public Paciente(String nombreN,String apellidoN,String telefonoC,int identificacionN,String telefonoF,String generoN,String direccionN)
    {
        nombre=nombreN;
        apellido=apellidoN;
        telefonoCelular=telefonoC;            
        id=identificacionN;  
        telefonoFijo=telefonoF;
        genero=generoN;
        direccion=direccionN;
        //episodios =new ArrayList<Episodio>();
    }

    public Paciente()
    {
        
    }
    
    public int getId() {
        return id;
    }

    public String getApellido() {
        return apellido;
    }

    public String getGenero() {
        return genero;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTelefonoFijo() {
        return telefonoFijo;
    }

    public String getTelefonoCelular() {
        return telefonoCelular;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setTelefonoFijo(String telefonoFijo) {
        this.telefonoFijo = telefonoFijo;
    }

    public void setTelefonoCelular(String telefonoCelular) {
        this.telefonoCelular = telefonoCelular;
    }
    
//    public void setEpisodios(ArrayList<Episodio>episodios)
//    {
//        this.episodios=episodios;
//    }
//    public void createEpisodio(Episodio episodio)
//    {
//        
//        
//        this.episodios.add(episodio);
//    }
//    
//    public ArrayList<Episodio> getEpisodios()
//    {
//        return this.episodios;
//    }
}
