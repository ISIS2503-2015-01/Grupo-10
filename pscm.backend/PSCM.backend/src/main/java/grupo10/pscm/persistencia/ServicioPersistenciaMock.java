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
            episodios = new ArrayList<Episodio>();
            //TODO Agregar pacientes con episodios
    //TODO Agregar episodios
            Paciente p1 = new Paciente("Pedro", "Perez", "3105559662", "1", "5559356", "M", "Calle Falsa 123");
            //TODO agregar ep
            pacientes.add(p1);
            Paciente p2 = new Paciente("Ana", "Rodrigeuz", "3125467895", "2", "5551234", "F", "Calle Falsa 243");
            pacientes.add(p2);
            Paciente p3 = new Paciente("Wilder", "Cárdenas", "3105585462", "3", "55574856", "M", "Calle Falsa hue");
            pacientes.add(p3);
            

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
            v.setId(""+pacientes.size() + 1); 
            pacientes.add(v);
        }
        else if (obj instanceof Episodio)
        {
            Episodio m = (Episodio) obj;
            m.setId(""+episodios.size() + 1); 
            episodios.add(m);
        } 
        else if (obj instanceof Doctor)
        {
            Doctor m = (Doctor) obj;
            m.setIdentificacion(""+doctores.size() + 1); 
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
                if (paciente.getId().equals(editar.getId()))
                {
                    pacientes.set(i, editar);
                    break;
                }
            }

        }
        else if (obj instanceof Episodio)
        {
            Episodio editar = (Episodio) obj;
            Episodio episodio;
            for (int i = 0; i < episodios.size(); i++)
            {
                episodio = episodios.get(i);
                if (episodio.getId().equals(editar.getId()))
                {
                    episodios.set(i, editar);
                    break;
                }
            }
        } 
        else if (obj instanceof Doctor)
        {

            Doctor editar = (Doctor) obj;
            Doctor doctor;
            for (int i = 0; i < doctores.size(); i++)
            {
                doctor = doctores.get(i);
                if (doctor.getId().equals(editar.getId()))
                {
                    doctores.set(i, editar);
                    break;
                }
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
                if (ven.getId().equals(pacienteABorrar.getId()))
                {
                    pacientes.remove(e);
                    break;
                }
            }

        } 
        else if (obj instanceof Episodio)
        {
            Episodio episodio;
            Episodio eliminar = (Episodio) obj;
            for (int i = 0; i < episodios.size(); i++)
            {
                episodio = episodios.get(i);
                if (eliminar.getId() == episodio.getId())
                {
                    episodios.remove(i);
                    break;
                }
            }

        } 
        else if (obj instanceof Doctor)
        {
            Doctor doctor;
            Doctor eliminar = (Doctor) obj;
            for (int i = 0; i < doctores.size(); i++)
            {
                doctor = doctores.get(i);
                if (eliminar.getId() == doctor.getId())
                {
                    episodios.remove(i);
                    break;
                }
            }
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
                if (ven.getId().equals((id.toString())))
                {
                    return ven;
                }
            }
        } 
        else if (c.equals(Episodio.class))
        {
            for (Object v : findAll(c))
            {
                Episodio mue = (Episodio) v;
                if (mue.getId().equals(id))
                {
                    return mue;
                }
            }
        } 
        else if (c.equals(Doctor.class))
        {
            for (Object v : findAll(c))
            {
                Doctor mue = (Doctor) v;
                if (mue.getId().equals(id))
                {
                    return mue;
                }
            }
        }
        return null;
    }
}
