package es.centro.incidencias;

import java.util.Locale;

/**
 * Representa una incidencia dentro del sistema.
 * Es una clase inmutable que almacena la información básica de un problema o tarea.
 *
 * @version 1.0
 */
public final class Incidencia {

    private final String id;
    private final String titulo;
    private final String prioridad;
    private final boolean abierta;

    /**
     * Construye una nueva incidencia con los datos especificados.
     *
     * @param id        El identificador único de la incidencia.
     * @param titulo    El título o breve descripción de la incidencia.
     * @param prioridad El nivel de prioridad asignado (ej. "alta", "media", "baja").
     * @param abierta   Indica si la incidencia está actualmente abierta ({@code true}) o resuelta/cerrada ({@code false}).
     */
    public Incidencia(String id, String titulo, String prioridad, boolean abierta) {
        this.id = id;
        this.titulo = titulo;
        this.prioridad = prioridad;
        this.abierta = abierta;
    }

    /**
     * Obtiene el identificador único de la incidencia.
     *
     * @return El identificador de la incidencia.
     */
    public String getId() {
        return id;
    }

    /**
     * Obtiene el título o descripción breve de la incidencia.
     *
     * @return El título de la incidencia.
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Obtiene el nivel de prioridad asignado a la incidencia.
     *
     * @return La prioridad de la incidencia.
     */
    public String getPrioridad() {
        return prioridad;
    }

    /**
     * Indica el estado actual de la incidencia.
     *
     * @return {@code true} si la incidencia está abierta, {@code false} si está cerrada.
     */
    public boolean isAbierta() {
        return abierta;
    }

    /**
     * Comprueba si el texto especificado está contenido dentro del identificador o del título
     * de la incidencia, ignorando diferencias entre mayúsculas y minúsculas.
     *
     * @param texto La cadena de texto que se desea buscar.
     * @return {@code true} si el identificador o el título contienen el texto indicado; {@code false} en caso contrario.
     * @since 1.0
     */
    public boolean coincideCon(String texto) {
        String criterio = texto.toLowerCase(Locale.ROOT);
        return id.toLowerCase(Locale.ROOT).contains(criterio)
                || titulo.toLowerCase(Locale.ROOT).contains(criterio);
    }

}