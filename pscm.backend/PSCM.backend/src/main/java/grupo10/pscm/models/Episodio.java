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
public class Episodio 
{
    
     private static final long serialVersionUID = 1L;
    
   
    @Id   
    private Long id;
    
    private Date fechaEpisodio;
    
    private String nivelDolor;  
  
    private String  hora;
       
    private String localizacion;
    
    private String patronSueno;
    
    private String alimentos;  
     
    private String bebidas;

    //-----------------------------------------------------------
    // Se deja como arrayList o como String?
    //-----------------------------------------------------------
    private String actividadFisica;
    
    private String notasVoz;
    
    private String notasMedico;
    
    private String posiblesCausas;
    
    
    public Episodio(Date fechaE,String nivelD,String horaE,Long idN,String patronN,String alimentosN,String bebidasN,String actividadN,String notasV)
    {
        fechaEpisodio=fechaE;
        nivelDolor=nivelD;
        hora=horaE;            
        id=idN;  
        patronSueno=patronN;
        alimentos=alimentosN;
        bebidas=bebidasN;
        notasVoz=notasV; 
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFechaEpisodio() {
        return fechaEpisodio;
    }

    public void setFechaEpisodio(Date fechaEpisodio) {
        this.fechaEpisodio = fechaEpisodio;
    }

    public String getNivelDolor() {
        return nivelDolor;
    }

    public void setNivelDolor(String nivelDolor) {
        this.nivelDolor = nivelDolor;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getLocalizacion() {
        return localizacion;
    }

    public void setLocalizacion(String localizacion) {
        this.localizacion = localizacion;
    }

    public String getPatronSueno() {
        return patronSueno;
    }

    public void setPatronSueno(String patronSueno) {
        this.patronSueno = patronSueno;
    }

    public String getAlimentos() {
        return alimentos;
    }

    public void setAlimentos(String alimentos) {
        this.alimentos = alimentos;
    }

    public String getBebidas() {
        return bebidas;
    }

    public void setBebidas(String bebidas) {
        this.bebidas = bebidas;
    }

    public String getActividadFisica() {
        return actividadFisica;
    }

    public void setActividadFisica(String actividadFisica) {
        this.actividadFisica = actividadFisica;
    }

    public String getNotasVoz() {
        return notasVoz;
    }

    public void setNotasVoz(String notasVoz) {
        this.notasVoz = notasVoz;
    }

    public String getNotasMedico() {
        return notasMedico;
    }

    public void setNotasMedico(String notasMedico) {
        this.notasMedico = notasMedico;
    }

    public String getPosiblesCausas() {
        return posiblesCausas;
    }

    public void setPosiblesCausas(String posiblesCausas) {
        this.posiblesCausas = posiblesCausas;
    }
    
}
