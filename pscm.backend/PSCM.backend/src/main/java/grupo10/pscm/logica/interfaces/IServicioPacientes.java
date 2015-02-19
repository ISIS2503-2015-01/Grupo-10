/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupo10.pscm.logica.interfaces;

import grupo10.pscm.models.Paciente;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author estudiante
 */
@Local
public interface IServicioPacientes {
    
    public void agregarPaciente(Paciente paciente) throws Exception;
    
    public Paciente getPaciente(String id);
    
    public void eliminarPaciente (String id) throws Exception;
    
    public List<Paciente> getPacientes();
    
}
