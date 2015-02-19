/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupo10.pscm.logica.interfaces;

import grupo10.pscm.models.Doctor;
import grupo10.pscm.models.Episodio;
import java.util.List;

/**
 *
 * @author estudiante
 */
public interface IServicioEpisodios
{
 public void agregarEpisodio(Episodio episodio) throws Exception;
    
    public void eliminarEpisodio(Long id) throws Exception;
    
    public List<Episodio> getEpisodios();   
}
