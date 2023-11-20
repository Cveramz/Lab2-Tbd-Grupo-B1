# TBD - LABORATORIO 2

 Repositorio correspondiente al segundo laboratorio del Taller de Base de Datos, USACH, 1/2023.

## CONTEXTO 

 La aparición de voluntarios espontáneos ante los desastres naturales en Chile es de gran importancia, sin embargo, la coordinación de estos presenta problemas para las distintas instituciones que buscan prestar su ayuda a las zonas y ciudadanos afectados. Con este fin, se propone la creación de un sistema de gestión del voluntariado espontáneo en respuesta las catástrofes en el territorio chileno. Este permitirá a los voluntarios registrarse, crear un perfil, especificar habilidades y condiciones de salud y registrar su participación en las emergencias. Asimismo, se les permitirá ver y aceptar tareas, corroborar que cumplen con los requisitos de dichas tareas y actualizar el estado de las mismas.

## TECNOLOGÍAS Y VERSIÓN

 El presente proyecto utiliza las tecnologías por parte de Backend y Base de Datos: Java (17) con su framework Spring boot Maven (2.7.16) y postgreSQL.
 Por parte de Frontend Vue 3 y Axios.

## EjECUCIÓN BASE DE DATOS
*Mensaje importante: Debe tener instalando Postgis porque la base de datos lo requiere.

Abrir PgAdmin y seleccionar un servidor, dentro de este crear una base de datos para luego abrir la QueryTool (o herramienta de consulta) para ejecutar los scripts:

1. Abrir "CreateLab2TBD.sql", en este caso ya está creada la base de datos por lo que se puede eliminar la primera linea para evitar problemas y luego ejecutar.

2. A modo de prueba se puede poblar la base de datos con el archivo "PoblateLab2TBD.sql" y ejecutar.

## EJECUCIÓN BACKEND

Se debe abrir la carpeta voluntariadoBackend con Intellij Idea y seleccionar el archivo que está en la ruta \src\main\java\com\chileayuda\voluntariadobackend llamado VoluntariadoBackendApplication para dar a correr.

## EJECUCIÓN FRONTEND

Se debe abrir la carpeta frontend desde el terminal y ejecutar los comandos
- npm install
- npm run dev