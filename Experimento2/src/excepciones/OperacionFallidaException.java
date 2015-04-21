package excepciones;

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

