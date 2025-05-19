# 💱 ConversorAppPro

ConversorAppPro es una aplicación Java por consola que permite convertir montos entre distintas monedas utilizando la [ExchangeRate API](https://www.exchangerate-api.com/).  
Incluye logging, menú interactivo, listado de monedas disponibles y un historial de conversiones en tiempo real.

---

## 🚀 Características

- ✅ Conversión entre múltiples monedas usando API real
- 🌍 Consulta de monedas disponibles
- 🧾 Historial de conversiones (con fecha y detalle)
- 📦 Modularizado por capas: `controller`, `service`, `model`, `util`
- 📝 Logging profesional con SLF4J + Logback
- 🔐 API Key gestionada desde archivo de configuración (`config.properties`)

---

## 🧱 Estructura del proyecto
ConversorAppPro/
├── src/
│ ├── com/puntolot/miapp/
│ │ ├── Main.java
│ │ ├── controller/
│ │ ├── model/
│ │ ├── service/
│ │ └── util/
│ ├── resources/
│ │ ├── config.properties
│ │ └── logback.xml
├── lib/
│ ├── gson-2.13.1.jar
│ ├── slf4j-api-1.7.36.jar
│ ├── logback-classic-1.2.11.jar
│ └── logback-core-1.2.11.jar

---

## 🔧 Requisitos

- Java 17 o superior
- IntelliJ IDEA Community Edition
- Conexión a internet para consumo de API

---

## ⚙️ Configuración inicial

1. Descargar los siguientes `.jar` y colocarlos en `/lib/`:
    - [`gson-2.13.1.jar`](https://repo1.maven.org/maven2/com/google/code/gson/gson/2.13.1/)
    - [`slf4j-api-1.7.36.jar`](https://repo1.maven.org/maven2/org/slf4j/slf4j-api/1.7.36/)
    - [`logback-core-1.2.11.jar`](https://repo1.maven.org/maven2/ch/qos/logback/logback-core/1.2.11/)
    - [`logback-classic-1.2.11.jar`](https://repo1.maven.org/maven2/ch/qos/logback/logback-classic/1.2.11/)

2. Agregar los `.jar` como dependencias en IntelliJ:
    - `File > Project Structure > Modules > Dependencies > + (JARs or directories)`

3. Crear el archivo `config.properties` dentro de `/resources` con el siguiente contenido:

```properties
api.key=TU_API_KEY_AQUI
