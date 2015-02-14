/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupo10.pscm.exceptions;

/**
 *
 * @author estudiante
 */
public class OperacionFallidaException extends Exception
{
    // -----------------------------------------------
    // Constructor
    // -----------------------------------------------

    /**
     * Constructor de la clase.
     * @param mensaje Mensaje de la excepción
     */
    public OperacionFallidaException( String mensaje )
    {
        super( mensaje );
    }
}
