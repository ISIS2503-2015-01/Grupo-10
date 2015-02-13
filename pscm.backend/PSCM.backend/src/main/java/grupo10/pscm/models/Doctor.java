/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupo10.pscm.models;

import java.util.ArrayList;
import javax.persistence.Id;

/**
 *
 * @author estudiante
 */
public class Doctor 
{
    private static final long serialVersionUID = 1L;
    
   
    @Id   
    private Long id;
    
    private String apellido;
    
    private int numeroPacientes;  
  
    private String  nombre;      
      
    private String contrasena;
    
    private String telefonoContacto;
      
    private ArrayList<Paciente> pacientes;

     /**
     * Constructor de la clase con argumentos
     * @param nombre Nombre del usuario
     * @param contraseña Constraseña del usuario
     */
    
    public Doctor(String nombreN,String apellidoN,String contrasenaN,Long identificacionN,String telefonoC)
    {
        nombre=nombreN;
        apellido=apellidoN;
        contrasena=contrasenaN;
        id=identificacionN;
        telefonoContacto=telefonoC;     
        ArrayList<Paciente> pacientes =new ArrayList<Paciente>();
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

    public Long getId() 
    {
        return id;
    }

    public void setIdentificacion(Long ide) {
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
