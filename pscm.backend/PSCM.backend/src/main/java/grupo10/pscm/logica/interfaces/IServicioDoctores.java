/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupo10.pscm.logica.interfaces;

import grupo10.pscm.models.Doctor;
import java.util.List;

/**
 *
 * @author estudiante
 */
public interface IServicioDoctores
{
 public Doctor agregarDoctor(Doctor doctor) throws Exception;
 
 public Doctor getDoctor(String id);
 
    public void eliminarDoctor(String id) throws Exception;
    
    public List<Doctor> getDoctores();   
}
