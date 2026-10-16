package es.centro.incidencias;

import java.util.List;

/**
 * Clase encargada de gestionar y almacenar un conjunto de incidencias.
 * Permite realizar operaciones de listado y búsqueda sobre ellas.
 *
 * @version 1.0
 */
public final class GestorIncidencias {

    private final List<Incidencia> incidencias;

    /**
     * Construye un nuevo gestor de incidencias e inicializa el catálogo
     * con una lista de datos predeterminados.
     */
    public GestorIncidencias() {
        incidencias = List.of(
                new Incidencia("INC-001", "No se puede iniciar sesión", "alta", true),
                new Incidencia("INC-002", "Actualizar el navegador", "media", false),
                new Incidencia("INC-003", "Impresora sin conexión", "baja", true),
                new Incidencia("INC-004", "Fallo de red en el aula", "alta", true)
        );
    }

    /**
     * Obtiene la lista completa de todas las incidencias registradas.
     *
     * @return Lista inmutable con todas las incidencias.
     * @since 1.0
     */
    public List<Incidencia> listar() {
        return incidencias;
    }

    /**
     * Filtra y obtiene únicamente las incidencias que se encuentran en estado abierto.
     *
     * @return Lista de incidencias abiertas.
     * @since 1.0
     */
    public List<Incidencia> listarAbiertas() {
        return incidencias.stream()
                .filter(Incidencia::isAbierta)
                .toList();
    }

    /**
     * Busca las incidencias cuyos atributos coincidan con el texto proporcionado.
     *
     * @param texto La cadena de texto a buscar dentro de las incidencias.
     * @return Una lista con las incidencias que coinciden con el texto buscado, o una lista vacía si no hay coincidencias.
     * @since 1.0
     */
    public List<Incidencia> buscar(String texto) {
        return incidencias.stream()
                .filter(incidencia -> incidencia.coincideCon(texto))
                .toList();
    }

    /**
     * Busca una incidencia específica a partir de su identificador único.
     *
     * <p>El identificador debe coincidir exactamente de forma ignorando mayúsculas y minúsculas.</p>
     *
     * @param id El identificador de la incidencia (ej. "INC-001").
     * @return La incidencia encontrada que corresponde al identificador.
     * @throws IncidenciaNoEncontradaException si no existe ninguna incidencia con ese identificador.
     * @since 1.0
     */
    public Incidencia buscarPorId(String id) throws IncidenciaNoEncontradaException {
        return incidencias.stream()
                .filter(incidencia -> incidencia.getId().equalsIgnoreCase(id))
                .findFirst()
                .orElseThrow(() -> new IncidenciaNoEncontradaException(id));
    }

    /**
     * Busca una incidencia por su identificador. Retorna nulo en lugar de lanzar una excepción
     * si no se encuentra.
     *
     * @param id El identificador de la incidencia.
     * @return La incidencia encontrada, o {@code null} si no existe.
     * @deprecated Usar {@link #buscarPorId(String)} para un control explícito de las excepciones.
     * @since 1.0
     */
    @Deprecated(since = "1.0.0", forRemoval = false)
    public Incidencia obtenerIncidencia(String id) {
        try {
            return buscarPorId(id);
        } catch (IncidenciaNoEncontradaException excepcion) {
            return null;
        }
    }
}