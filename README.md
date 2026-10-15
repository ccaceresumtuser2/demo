# ms-demo

Microservicio de demostración construido con Spring Boot. Expone un endpoint REST de prueba ("Hola Mundo") con respuestas en un formato estándar y documentación OpenAPI/Swagger.

## Tecnologías

- Java 21
- Spring Boot 4.1.1 (Web MVC, Web Services)
- springdoc-openapi 3.1.0 (Swagger UI)
- Lombok
- Maven (incluye Maven Wrapper)
- Docker / Docker Compose

## Estructura del proyecto

```
src/main/java/com/app/demo
├── DemoApplication.java           # Punto de entrada
├── config/OpenApiConfig.java      # Metadatos de la documentación OpenAPI
├── controller/HolaMundoController.java
├── dto/response/
│   ├── ApiResponse.java           # Envoltorio estándar de respuesta
│   └── SaludoResponse.java
└── exception/GlobalExceptionHandler.java
```

## Requisitos

- JDK 21 (para ejecución local), o
- Docker y Docker Compose

## Ejecución local

```bash
# Linux / macOS
./mvnw spring-boot:run

# Windows
mvnw.cmd spring-boot:run
```

La aplicación queda disponible en `http://localhost:8080`.

Para generar el JAR:

```bash
./mvnw clean package
java -jar target/demo-0.0.1-SNAPSHOT.jar
```

## Ejecución con Docker

```bash
docker compose up --build
```

Esto compila la imagen `ms-demo:latest` (build multi-etapa, se ejecuta con un usuario sin privilegios) y levanta el contenedor `ms-demo` en el puerto `8080`.

## Endpoints

| Método | Ruta           | Descripción                    |
|--------|----------------|--------------------------------|
| GET    | `/api/v1/hola` | Devuelve un mensaje Hola Mundo |

Ejemplo:

```bash
curl http://localhost:8080/api/v1/hola
```

```json
{
  "timestamp": "2026-10-15T10:30:00",
  "data": { "saludo": "Hola Mundo" },
  "message": "Operación exitosa",
  "httpStatus": 200
}
```

## Documentación de la API

- Swagger UI: http://localhost:8080/swagger-ui.html
- OpenAPI (JSON): http://localhost:8080/v3/api-docs

## Manejo de errores

`GlobalExceptionHandler` captura las excepciones no controladas y responde con estado `500` y un cuerpo con `timestamp`, `message` y `status`.

## Pruebas

```bash
./mvnw test
```
