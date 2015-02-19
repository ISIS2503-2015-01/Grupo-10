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
public class Paciente 
{
     private static final long serialVersionUID = 1L;
    
   
    @Id   
    private Long id;
    
    private String apellido;
    
    private String genero;  
  
    private String  nombre;
       
    private String direccion;
    
    private String telefonoFijo;
    
    private String telefonoCelular;  
     
    private ArrayList<Episodio> episodios;

    
    
    public Paciente(String nombreN,String apellidoN,String telefonoC,Long identificacionN,String telefonoF,String generoN,String direccionN)
    {
        nombre=nombreN;
        apellido=apellidoN;
        telefonoCelular=telefonoC;            
        id=identificacionN;  
        telefonoFijo=telefonoF;
        genero=generoN;
        direccion=direccionN;
        episodios =new ArrayList<Episodio>();
    }

    public Long getId() {
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

    public void setId(Long id) {
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
    
    public void setEpisodios(ArrayList<Episodio>episodios)
    {
        this.episodios=episodios;
    }
    public void createEpisodio(Date fecha, String nivel, String hora, Long id, String patron, ArrayList<String> alimentos,ArrayList<String> bebidas, ArrayList<String> actividades, ArrayList<String> medicamentos)
    {
        Episodio epi = new Episodio(fecha, nivel, hora, id, patron, alimentos, bebidas, actividades, medicamentos);
        
        this.episodios.add(epi);
    }
    
    public ArrayList<Episodio> getEpisodios()
    {
        return this.episodios;
    }
}
