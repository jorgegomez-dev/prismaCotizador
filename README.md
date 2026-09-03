# Prisma Corte Laser [webApplication]

## Descripción
La aplicación es un desarrollo de **jorgegomez-dev** para Prisma Corte Laser.
Es una herramienta para cotizar, manejar stock, realizar seguimiento de clientes.
Está diseñada para que el personal pueda acceder de forma remota a las herramientas de 
gestion del modelo de negocio.

## Características principales
- Calculadora de Cotizacion de Corte Laser por CO2
- Alta, Baja, Modificacion de Materiales
- Registro de clientes y trabajos
- Sistema de login y registro de usuarios de la empresa
- Seguridad implementada con Spring Security
- Acceso de datos para realizar analiticas.
- Visualizacion de archivos con extension .dxf y analisis basicos para calculos de costos

## Arquitectura del Proyecto
- **Frontend**: [JavaScript, HTML5, CSS, Angular] -> Desarrollo en etapa posterior
- **Backend**: Spring Boot, Java
- **Base de datos**: MySQL
- **Gestion de JPA**: Hibernate
- **Seguridad**: Spring Security con autenticación por sesiones
- **Documentacion**: Swagger

## Instalación y configuración para testing
1. Inicio del servidor en IntelliJ:

2. Actualizar dependencias se ser necesario al iniciar el proyecto

3. La base de datos se crea automatica con gestion de Hibernate bajo norma JPA
    - Ver el archivo `application.properties` con los detalles de conexión a la base de datos.

4. Si el proyecto aun no tiene usuario registrados, registrarse desde el login
5. El primer usuario se creara con:
    - username: admin
    - password: 1234
    - puedes cambiarlos al iniciar sesion, ya que se crea automaticamente con permisos de administrador ROLE_ADMIN
    - el resto de los usuarios que se vayan registrando, se cargaran automaticamnete como ROLE_USER
    - en caso de querer dar un rol de administrador a otro usuario, se puede hacer desde la edicion de un usuario creado o creando directamente un usuario desde el panel de administrador

6. La duracion de las sesiones se puede cambiar desde la clase
    - ValidacionesServiceImpl
    - private final int duracionSesionROLE_ADMIN = 360; // SETEAR EL TIEMPO DE SESION PARA ADMIN QUE QUEREMOS ACA (en segundos)
    - private final int duracionSesionROLE_USER = 60; // SETEAR EL TIEMPO DE SESION PARA USER QUE QUEREMOS ACA (en segundos)
    - private final int cantidadDeSesiones = 2000; // SETEAR LA CANTIDAD DE CONEXIONES SIMULTANEAS QUE QUEREMOS PERMITIR ACA

7. La aplicacion tiene habilitado el manejo de sesiones simultaneas por lo que se puede probar con varios usuarios y sesiones a la vez
8. Toda la documentacion de los endpoints y el manejo de los mismos esta visible para sesion inciada en:
    - http://localhost:8080/doc/swagger-ui/index.html#/
9. Si las acciones se interrumpen inesperadamente, no olvidar cambiar la duracion de las sesiones para que no interfieran en la etapa de testing

### . **Uso de la Aplicación**

```markdown
## Uso de la Aplicación

---En proceso de edicion---

http://localhost:8080/doc/swagger-ui/index.html#/