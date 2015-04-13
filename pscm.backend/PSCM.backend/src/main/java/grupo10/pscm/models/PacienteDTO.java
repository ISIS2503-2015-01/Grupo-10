/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupo10.pscm.models;

import java.util.ArrayList;
import java.util.Date;
import javax.persistence.Id;

/**
 *
 * @author estudiante
 */
public class PacienteDTO 
{
    private String documento;
    
    private String apellido;
    
    private String genero;  
  
    private String  nombre;
       
    private String direccion;
    
    private String telefonoFijo;
    
    private String telefonoCelular;  
     
    //private ArrayList<Episodio> episodios;


    public String getDocumento() {
        return documento;
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

    public void setDocumento(String nDoc) {
        this.documento = nDoc;
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
