/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupo10.pscm.logica.ejb;

import grupo10.pscm.logica.interfaces.IServicioPacientes;
import grupo10.pscm.models.Paciente;
import grupo10.pscm.persistencia.*;
import java.util.List;

import javax.ejb.Stateful;
import javax.ejb.EJB;

/**
 *
 * @author estudiante
 */
@Stateful
public class ServicioPacientes implements IServicioPacientes
{

    @EJB
    private ServicioPersistenciaMock persistencia;
    
    
    public ServicioPacientes()
    {
    }
    
    //----------------------------
    //Metodos
    //----------------------------
    
    @Override
    public void agregarPaciente(Paciente paciente) throws Exception {
        persistencia.create(paciente);
    }

    @Override
    public void eliminarPaciente(Long id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Paciente> getPacientes() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
