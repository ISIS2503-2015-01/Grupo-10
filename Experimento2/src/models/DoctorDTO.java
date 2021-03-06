/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.ArrayList;

/**
 *
 * @author estudiante
 */
public class DoctorDTO {
    private String documento;
    
    private String apellido;  
  
    private String  nombre;      
      
    private String contrasena;
    
    private String telefonoContacto;
      
    private ArrayList<Paciente> pacientes;

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
    
    public int getNumeroPacientes() 
    {
        return pacientes.size();
    }
   
     public void setContrasena(String con) {
        this.contrasena = con;
    }
}
