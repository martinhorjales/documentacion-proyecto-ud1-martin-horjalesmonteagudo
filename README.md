# Gestor de Incidencias

**Gestor de Incidencias** es una aplicación de consola diseñada para la consulta de avisos de soporte de un centro. Su finalidad principal es facilitar la visualización, filtrado y búsqueda de problemas o tareas reportadas.

## Versión de Java

El proyecto utiliza **Java 27** 

## Funcionalidades

La aplicación permite realizar las siguientes operaciones:

*   **Listar:** Muestra todas las incidencias registradas en el sistema.
*   **Filtrar:** Muestra únicamente las incidencias que se encuentran en estado abierto.
*   **Buscar:** Busca coincidencias de un texto específico dentro del identificador o del título de las incidencias, ignorando mayúsculas y minúsculas.
*   **Detalle:** Permite consultar la información completa de una incidencia específica introduciendo su identificador único.
*   **Modos de ejecución:** Soporta un modo de menú interactivo continuo y un modo de ejecución directa mediante argumentos por línea de comandos.

## Compilación y Ejecución

Para compilar el proyecto desde la raíz del directorio, utiliza el siguiente comando:

```bash
javac -d bin src/es/centro/incidencias/*.java
```

Para ejecutar la aplicación, puedes usar cualquiera de los siguientes comandos dependiendo del modo que desees utilizar:

**Modo interactivo (sin argumentos):**
```bash
java -cp bin es.centro.incidencias.App
```

**Modo línea de comandos (ejemplos):**
```bash
java -cp bin es.centro.incidencias.App listar
java -cp bin es.centro.incidencias.App abiertas
java -cp bin es.centro.incidencias.App buscar red
java -cp bin es.centro.incidencias.App detalle INC-001
java -cp bin es.centro.incidencias.App ayuda
```

## Generación y consulta de Javadoc

Para generar la documentación técnica en formato HTML a partir de los comentarios de código, ejecuta:

```bash
javadoc -d docs src/es/centro/incidencias/*.java
```

Una vez generado, puedes consultar la documentación abriendo el archivo `docs/index.html` en tu navegador web.

## Clases Principales y Responsabilidades

| Clase | Responsabilidad |
| :--- | :--- |
| `App` | Clase principal que sirve como punto de entrada de la aplicación. Gestiona el menú interactivo, la lectura de argumentos por consola y la interacción directa con el usuario. |
| `GestorIncidencias` | Clase encargada de gestionar y almacenar el conjunto predeterminado de incidencias. Expone los métodos para listar, filtrar y buscar datos. |
| `Incidencia` | Clase inmutable que representa y almacena la información básica de una tarea o problema, incluyendo su ID, título, prioridad y estado (abierta o cerrada). |
| `IncidenciaNoEncontradaException` | Excepción comprobada que se lanza para notificar que se ha intentado buscar una incidencia con un identificador que no existe. |

## Estructura de archivos

La organización de los directorios y código fuente del proyecto es la siguiente:

```text
proyecto-incidencias/
├── src/
│   └── es/
│       └── centro/
│           └── incidencias/
│               ├── App.java
│               ├── GestorIncidencias.java
│               ├── Incidencia.java
│               └── IncidenciaNoEncontradaException.java
├── bin/
├── docs/
└── README.md
```

## Documentación Javadoc en GitHub Pages

Puedes consultar la documentación técnica oficial del código, publicada automáticamente, a través del siguiente enlace:

[Documentación Javadoc de Gestor de Incidencias](https://martinhorjales.github.io/documentacion-proyecto-ud1-martin-horjalesmonteagudo/)