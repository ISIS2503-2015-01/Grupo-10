/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupo10.pscm.models;

import java.util.ArrayList;

/**
 *
 * @author estudiante
 */
public class DoctorDTO {
    private String id;
    
    private String apellido;  
  
    private String  nombre;      
      
    private String contrasena;
    
    private String telefonoContacto;
      
    private ArrayList<Paciente> pacientes;

    public DoctorDTO()
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

    public String getId() 
    {
        return id;
    }

    public void setIdentificacion(String ide) {
        this.id = ide;
    }
    
    public String getContrasena() 
    {
        return contrasena;
    }
    
    public int getNumeroPacientes() 
    {
        return pacientes.size();
    }
   
     public void setContrasena(String con) {
        this.contrasena = con;
    }
}
