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
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
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
@NoSql(dataFormat=DataFormatType.MAPPED)
@Entity
@XmlRootElement
public class Episodio 
{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue
    @Field(name="_id")
    private String id;
    
    @NotNull
    @Column(name = "create_at", updatable = false)
    @Temporal(TemporalType.DATE)
    private Calendar createdAt;

    @NotNull
    @Column(name = "updated_at")
    @Temporal(TemporalType.DATE)
    private Calendar updatedAt;
    
    private String idPaciente;

    private Date fechaEpisodio;
    
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
    
    
    public Episodio(Date fechaE,String nivelD,String horaE,String patronN,ArrayList <String> alimentosN,ArrayList <String> bebidasN,ArrayList <String> actividadN,ArrayList <String> medicamentoN)
    {
        fechaEpisodio=fechaE;
        nivelDolor=nivelD;
        hora=horaE;            
        patronSueno=patronN;
        alimentos=alimentosN;
        bebidas=bebidasN;
        actividadFisica=actividadN; 
        medicamentos=medicamentoN;
    }

    public Episodio()
    {
        
    }
    
    @PreUpdate
    private void updateTimestamp() {
        this.updatedAt = Calendar.getInstance();
    }

    @PrePersist
    private void creationTimestamp() {
        this.createdAt = this.updatedAt = Calendar.getInstance();
    }
    
    public String getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(String idPaciente) {
        this.idPaciente = idPaciente;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
