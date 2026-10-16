package es.centro.incidencias;

/**
 * Excepción comprobada (checked) que se lanza cuando se intenta buscar
 * o recuperar una incidencia mediante un identificador que no existe en el sistema.
 *
 * @version 1.0
 */
public class IncidenciaNoEncontradaException extends Exception {

    /**
     * Construye una nueva excepción con un mensaje de error detallado,
     * indicando el identificador específico que no se ha podido encontrar.
     *
     * @param id El identificador de la incidencia que ha causado la excepción.
     */
    public IncidenciaNoEncontradaException(String id) {
        super("No existe ninguna incidencia con el identificador " + id + ".");
    }
}