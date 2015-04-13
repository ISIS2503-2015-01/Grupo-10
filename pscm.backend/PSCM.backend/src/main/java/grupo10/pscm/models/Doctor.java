/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupo10.pscm.models;

import java.util.ArrayList;
import java.util.Calendar;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import org.eclipse.persistence.nosql.annotations.*;

/**
 *
 * @author estudiante
 */
@Entity
public class Doctor 
{
    private static final long serialVersionUID = 1L;
    
    @Id
    private String documento;    
    
    private String apellido;  
  
    private String  nombre;      
   
    @NotNull
    private String contrasena;
    
    private String telefonoContacto;
      
    //private ArrayList<Paciente> pacientes;

     /**
     * Constructor de la clase con argumentos
     * @param nombreN Nombre del usuario
     * @param apellidoN Apellido del usuario
     * @param contrasenaN Constraseña del usuario
     * @param identificacionN Identifiacion del usuario
     * @param telefonoC Telefono del usuario
     */
    
    public Doctor(String nombreN,String apellidoN,String contrasenaN,String nDocumento,String telefonoC)
    {
        nombre=nombreN;
        apellido=apellidoN;
        contrasena=contrasenaN;
        documento=nDocumento;
        telefonoContacto=telefonoC;     
        //pacientes =new ArrayList<Paciente>();
    }
    
    public Doctor()
    {
        
    }
    
   //-----------------------------------------------------------
    // Getters y setters
    //-----------------------------------------------------------
   
    
    public String getNombre() 
    {
        return nombre;
    }

    public void setNombre(String nombreN) 
    {
        this.nombre = nombreN;
    }

    public String getApellido() 
    {
        return apellido;
    }

    public void setApellido(String apellidoN) 
    {
        this.apellido = apellidoN;
    }

    public String getTelefonoC() 
    {
        return telefonoContacto;
    }

    public void setTelefonoContacto(String tel) 
    {
        this.telefonoContacto = tel;
    }

    public String getDocumento() 
    {
        return documento;
    }

    public void setDocumento(String nDocumento) {
        this.documento = nDocumento;
    }
    
    public String getContrasena() 
    {
        return contrasena;
    }
    
//       public int getNumeroPacientes() 
//    {
//        return pacientes.size();
//    }
   
     public void setContrasena(String con) {
        this.contrasena = con;
    }
    
//     public ArrayList<Episodio> getEpisodiosById(String id)
//    {
//        ArrayList<Episodio> resultado = new ArrayList<Episodio>();
//        
//        for (Paciente p : pacientes)
//        {
//            ArrayList<Episodio>episodios = p.getEpisodios();
//            
//            for (Episodio epi : episodios) 
//            {
//                if(epi.getId().compareTo(id) ==0)
//                {
//                    resultado.add(epi);
//                }
//            }
//        }
//        return resultado;
//    }
//        
//    public ArrayList<String> getCatalizadores(Episodio episodio)
//    {
//        ArrayList<String> catalizadores = new ArrayList<String>();
//        
//        ArrayList<String> meds = episodio.getMedicamentos();
//        ArrayList<String> alimentos = episodio.getAlimentos();
//        ArrayList<String> bebidas = episodio.getBebidas();
//        ArrayList<String> actividades = episodio.getActividadFisica();
//        
//        for (String r : meds) {
//            catalizadores.add(r);
//        }
//        for (String r : alimentos) {
//            catalizadores.add(r);
//        }
//        for (String r : bebidas) {
//            catalizadores.add(r);
//        }
//        for (String r : actividades) {
//            catalizadores.add(r);
//        }
//        
//        
//    return catalizadores;
//    }
}
