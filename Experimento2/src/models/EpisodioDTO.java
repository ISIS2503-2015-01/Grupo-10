/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.ArrayList;
import java.util.Date;
import javax.persistence.Id;

/**
 *
 * @author estudiante
 */
public class EpisodioDTO 
{
    private int id;
    
    private String documentoPaciente;
    
    private String fechaEpisodio;
    
    private String nivelDolor;  
  
    private String  hora;
       
    private String localizacion;
    
    private String patronSueno;
    
    private ArrayList <String> alimentos;  
    
    private ArrayList <String> medicamentos; 
     
    private ArrayList <String> bebidas;
   
    private ArrayList <String> actividadFisica;    
      
    private String notasMedico;
    
    private String posiblesCausas;

    public String getDocumentoPaciente() {
        return documentoPaciente;
    }

    public void setDocumentoPaciente(String nDocPaciente) {
        this.documentoPaciente = nDocPaciente;
    }
    
    public ArrayList<String> getAlimentos() {
        return alimentos;
    }

    public void setAlimentos(ArrayList<String> alimentos) {
        this.alimentos = alimentos;
    }

    public ArrayList<String> getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(ArrayList<String> medicamentos) {
        this.medicamentos = medicamentos;
    }

    public ArrayList<String> getBebidas() {
        return bebidas;
    }

    public void setBebidas(ArrayList<String> bebidas) {
        this.bebidas = bebidas;
    }

    public ArrayList<String> getActividadFisica() {
        return actividadFisica;
    }

    public void setActividadFisica(ArrayList<String> actividadFisica) {
        this.actividadFisica = actividadFisica;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFechaEpisodio() {
        return fechaEpisodio;
    }

    public void setFechaEpisodio(String fechaEpisodio) {
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
   
    public String getNotasMedico() 
    {
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
