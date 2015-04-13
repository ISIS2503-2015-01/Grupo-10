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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Field(name="_id")
    private int id;
    
    @NotNull
    @Column(name = "create_at", updatable = false)
    @Temporal(TemporalType.DATE)
    private Calendar createdAt;

    @NotNull
    @Column(name = "updated_at")
    @Temporal(TemporalType.DATE)
    private Calendar updatedAt;
    
    // Id del paciente
    private String documentoPaciente;

    // Fecha en la que se rpesenta el episoio
    private String fechaEpisodio;
    
    // Nivel del dolor del apciente en el episodio de Migraña
    private String nivelDolor;  
  
    // Hora en que se presenta el episodio
    private String  hora;
       
    // Atributo que indica la localización de la migraña
    private String localizacion;
    
    // Atributo que indica el aptron del sueño del paciente
    private String patronSueno;
    
        
  // Arreglo de Strings que indica los alimetnos  ingeridos por un paciente antes d eun episodiod e migraña
    private ArrayList <String> alimentos;  
    
  // Arreglo de Strings que indica los medicamentos  ingeridos por un paciente antes d eun episodiod e migraña
    private ArrayList <String> medicamentos; 
     
    // Arreglo de Strings que indica las bebidas ingeridas pro un paciente antes d eun episodiod e migraña
    private ArrayList <String> bebidas;
   
    //Arreglo de Strings que tiene la actividad fisica d eun apciente
    private ArrayList <String> actividadFisica;    
    
    //Notas de voz que tiene algun episodio
    private String notasMedico;
    
    // Describe las posibles causas d eun episodio de migraña
    private String posiblesCausas;
    
    //Constructor de episodio que cuenta con atributos de id Paciente, fechaE,nivelID, patron N
    public Episodio(String nDocPaciente, String fechaE,String nivelD,String horaE,String patronN,ArrayList <String> alimentosN,ArrayList <String> bebidasN,ArrayList <String> actividadN,ArrayList <String> medicamentoN)
    {
        documentoPaciente=nDocPaciente;
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
    
    public String getDocumentoPaciente() {
        return documentoPaciente;
    }

    public void setDocumentoPaciente(String nDocuPaciente) {
        this.documentoPaciente = nDocuPaciente;
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
