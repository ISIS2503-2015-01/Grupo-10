package grupo10.pscm.persistencia;

import grupo10.pscm.*;
import grupo10.pscm.models.Doctor;
import grupo10.pscm.models.Episodio;
import grupo10.pscm.models.Paciente;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import javax.ejb.Stateless;

/**
 * Implementación de los servicios de persistencia
 * @author Juan Sebastián Urrego
 */

public class ServicioPersistenciaMock {

    //-----------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------

    /**
     * 
     */
    private static ArrayList<Paciente> pacientes;

    /**
     * 
     */
    private static ArrayList<Episodio> episodios;

    /**
     *
     */
    private static ArrayList<Doctor> doctores;

    

    //-----------------------------------------------------------
    // Constructor
    //-----------------------------------------------------------

    /**
     * Constructor de la clase. Inicializa los atributos.
     */
    public ServicioPersistenciaMock()
    {
        if (pacientes == null)
        {
            pacientes = new ArrayList();

            
            //TODO Agregar pacientes con episodios

            episodios = new ArrayList<Episodio>();

            //TODO Agregar episodios
            

            //Inicializa el arreglo que contiene los doctores
            doctores = new ArrayList<Doctor>();

            //TODO Agregar doctores
            
        }
    }

    //-----------------------------------------------------------
    // Métodos
    //-----------------------------------------------------------
    
    /**
     * Permite crear un objeto dentro de la persistencia del sistema.
     * @param obj Objeto que representa la instancia de la entidad que se quiere crear.
     */
    public void create(Object obj) throws Exception
    {
        if (obj instanceof Paciente)
        {
            Paciente v = (Paciente) obj;
            //v.setIdentificacion(pacientes.size() + 1); //TODO fix with actual attribute
            pacientes.add(v);
        }
        else if (obj instanceof Episodio)
        {
            Episodio m = (Episodio) obj;
            //m.setReferencia(episodios.size() + 1); //TODO fix with actual attribute
            episodios.add(m);
        } 
        else if (obj instanceof Doctor)
        {
            Doctor m = (Doctor) obj;
//            for (Doctor us : doctores)
//            {
//                if (us.getLogin().equals(m.getLogin()))
//                {
//                    throw new OperacionInvalidaException("El doctor '" + m.getLogin() + "' ya ha sido registrado en el sistema");
//                }
//                if (us.getDocumento() == m.getDocumento() && us.getTipoDocumento().equals(m.getTipoDocumento()))
//                {
//                    throw new OperacionInvalidaException("El doctor con documento '" + m.getDocumento() + "' ya ha sido registrado en el sistema");
//                }
//            }
            doctores.add(m);
        } 
    }

    /**
     * Permite modificar un objeto dentro de la persistencia del sistema.
     * @param obj Objeto que representa la instancia de la entidad que se quiere modificar.
     */
    public void update(Object obj)
    {
        if (obj instanceof Paciente)
        {
            Paciente editar = (Paciente) obj;
            Paciente paciente;
            for (int i = 0; i < pacientes.size(); i++)
            {
                paciente = pacientes.get(i);
//                if (paciente.getIdentificacion() == editar.getIdentificacion())
//                {
//                    pacientes.set(i, editar);
//                    break;
//                }
                //TODO fix with actual attribute
            }

        }
        else if (obj instanceof Episodio)
        {
            Episodio editar = (Episodio) obj;
            Episodio episodio;
            for (int i = 0; i < episodios.size(); i++)
            {
                episodio = episodios.get(i);
//                if (episodio.getReferencia() == editar.getReferencia())
//                {
//                    episodios.set(i, editar);
//                    break;
//                }
                //TODO fix with actual attribute
            }
        } 
        else if (obj instanceof Doctor)
        {

            Doctor editar = (Doctor) obj;
            Doctor doctor;
            for (int i = 0; i < doctores.size(); i++)
            {
                doctor = doctores.get(i);
//                if (doctor.getLogin().equals(editar.getLogin()))
//                {
//                    doctores.set(i, editar);
//                    break;
//                }
                //TODO fix with actual attribute
            }
        }
    }

    /**
     * Permite borrar un objeto dentro de la persistencia del sistema.
     * @param obj Objeto que representa la instancia de la entidad que se quiere borrar.
     */
    public void delete(Object obj) throws Exception
    {
        if (obj instanceof Paciente)
        {
            Paciente pacienteABorrar = (Paciente) obj;

            for (int e = 0; e < pacientes.size(); e++)
            {
                Paciente ven = (Paciente) pacientes.get(e);
//                if (ven.getIdentificacion() == pacienteABorrar.getIdentificacion())
//                {
//                    pacientes.remove(e);
//                    break;
//                }
                //TODO fix with actual attribute
            }

        } 
        else if (obj instanceof Episodio)
        {
            Episodio episodio;
            Episodio eliminar = (Episodio) obj;
            for (int i = 0; i < episodios.size(); i++)
            {
                episodio = episodios.get(i);
//                if (eliminar.getReferencia() == episodio.getReferencia())
//                {
//                    episodios.remove(i);
//                    break;
//                }
                //TODO fix with actual attribute
            }

        } 
        else if (obj instanceof Doctor)
        {
            Doctor doctorABorrar = (Doctor) obj;
            
//            if (doctorABorrar != null && doctorABorrar.getLogin() != null)
//            {
//                for (int e = 0; e < doctores.size(); e++)
//                {
//                    Doctor ven = (Doctor) doctores.get(e);
//                    if (ven.getLogin().equals(doctorABorrar.getLogin()))
//                    {
//                        doctores.remove(e);
//                        System.out.print("borrado");
//                        break;
//                    }
//                }
//            }
            //TODO fix with actual attribute
        }
    }

    /**
     * Retorna la lista de todos los elementos de una clase dada que se encuentran en el sistema.
     * @param c Clase cuyos objetos quieren encontrarse en el sistema.
     * @return list Listado de todos los objetos de una clase dada que se encuentran en el sistema.
     */
    public List findAll(Class c)
    {
        if (c.equals(Episodio.class))
        {
            return episodios;
        } 
        else if (c.equals(Paciente.class))
        {
            return pacientes;
        } 
        else if (c.equals(Doctor.class))
        {
            return doctores;
        } 
        else
        {
            return null;
        }
    }

    /**
     * Retorna la instancia de una entidad dado un identificador y la clase de la entidadi.
     * @param c Clase de la instancia que se quiere buscar.
     * @param id Identificador unico del objeto.
     * @return obj Resultado de la consulta.
     */
    public Object findById(Class c, Object id)
    {
        if (c.equals(Paciente.class))
        {
            for (Object v : findAll(c))
            {
                Paciente ven = (Paciente) v;
//                if (ven.getIdentificacion() == Long.parseLong(id.toString()))
//                {
//                    return ven;
//                }
                //TODO fix with actual attribute
            }
        } 
        else if (c.equals(Episodio.class))
        {
            for (Object v : findAll(c))
            {
                Episodio mue = (Episodio) v;
//                if (Long.parseLong(id.toString())== mue.getReferencia())
//                {
//                    return mue;
//                }
                
                //TODO fix with actual attribute
            }
        } 
        else if (c.equals(Doctor.class))
        {
            for (Object v : findAll(c))
            {
                Doctor mue = (Doctor) v;
//                if (mue.getLogin().equals(id))
//                {
//                    return mue;
//                }
                //TODO fix with actual attribute
            }
        }
        return null;
    }
}
