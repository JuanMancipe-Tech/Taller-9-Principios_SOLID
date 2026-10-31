# Taller 9 – Principios SOLID en Java

## Información del proyecto

**Proyecto:** Parqueadero SOLID  
**Asignatura:** Programación  
**Lenguaje:** Java  
**Tema:** Aplicación de los cinco principios SOLID mediante refactorización progresiva.

## Descripción

Este proyecto consiste en la implementación y refactorización de un sistema de gestión de parqueadero desarrollado en Java, aplicando progresivamente los cinco principios SOLID.

El sistema permite gestionar diferentes modalidades de cobro de vehículos, registrar el uso de casilleros, calcular cobros, almacenar información, generar reportes CSV y enviar notificaciones de recibos.

El objetivo principal es mejorar la organización del código, reducir el acoplamiento entre clases y facilitar el mantenimiento y la ampliación del sistema.

## Estructura del proyecto

El repositorio está organizado en seis carpetas. Cada una contiene una versión ejecutable del proyecto y representa una etapa de la refactorización.

| Carpeta | Principio | Descripción |
|---|---|---|
| `00-inicio` | Código inicial | Proyecto original con violaciones intencionales a los cinco principios SOLID. |
| `01-responsabilidad-unica` | SRP | Se separaron las responsabilidades de exportación CSV y envío de notificaciones SMS en clases independientes. |
| `02-abierto-cerrado` | OCP | Se eliminó el `switch` del gestor y se implementó el cálculo de cobros mediante herencia y polimorfismo. Se agregó la modalidad de cobro por día. |
| `03-sustitucion-liskov` | LSP | Se separó la capacidad de acumular puntos mediante la interfaz `AcumuladorPuntos`, evitando que las bicicletas hereden comportamientos que no pueden cumplir. |
| `04-segregacion-interfaces` | ISP | Se dividió la interfaz general en interfaces pequeñas: `RegistrablePorTiempo`, `Asegurable` y `Lavable`. |
| `05-inversion-dependencias` | DIP | Se creó la interfaz `RepositorioCobros` y se implementó la inyección de dependencias mediante el constructor, utilizando un repositorio en memoria. |

## Principios SOLID aplicados

### 1. SRP – Principio de responsabilidad única
Cada clase debe tener una responsabilidad específica.

Se crearon las clases:
- `ExportadorCSV`: se encarga de generar el contenido CSV.
- `NotificadorSMS`: se encarga de enviar las notificaciones.
- `GestorParqueadero`: coordina el proceso de cierre mensual.

### 2. OCP – Principio abierto/cerrado
Las clases deben estar abiertas a la extensión, pero cerradas a la modificación.

Se reemplazó la estructura `switch` por métodos polimórficos. Se crearon diferentes modalidades de cobro:
- `VehiculoMensual`
- `VehiculoPorMinuto`
- `VehiculoPorDia`

Esto permite agregar nuevas modalidades sin modificar el gestor.

### 3. LSP – Principio de sustitución de Liskov
Las clases derivadas deben poder sustituir a sus clases base sin generar comportamientos inesperados.

Se eliminó el método `calcularPuntos()` de la clase general `Vehiculo` y se creó la interfaz `AcumuladorPuntos`, implementada únicamente por los vehículos mensuales.

### 4. ISP – Principio de segregación de interfaces
Las clases no deben estar obligadas a implementar métodos que no necesitan.

Se reemplazó `ServicioParqueadero` por tres interfaces independientes:
- `RegistrablePorTiempo`
- `Asegurable`
- `Lavable`

Cada clase implementa únicamente las capacidades que necesita.

### 5. DIP – Principio de inversión de dependencias
Las clases deben depender de abstracciones y no directamente de implementaciones concretas.

Se creó la interfaz `RepositorioCobros`, implementada por:
- `RepositorioMySQL`
- `RepositorioMemoria`

El `GestorParqueadero` recibe el repositorio mediante su constructor, permitiendo cambiar la implementación sin modificar su lógica.

## Cómo se ejecuta el proyecto

Cada carpeta funciona de manera independiente y contiene los archivos Java necesarios para ejecutar su versión.

**Requisitos:**
- Tener instalado Java JDK.
- Tener configurado Java en las variables de entorno PATH.

**Pasos:**

1. Abrir una terminal.
2. Ingresar a cualquiera de las carpetas del proyecto.
3. Compilar los archivos:

```bash
javac *.java
```

4. Ejecutar el programa:

```bash
java Main
```

Por ejemplo, para ejecutar la versión final:

```bash
cd 05-inversion-dependencias
javac *.java
java Main
```

## Resultado final

El proyecto presenta una evolución progresiva desde un código inicial con problemas de diseño hasta una estructura más organizada, flexible y mantenible mediante la aplicación de los cinco principios SOLID.

La versión final permite utilizar un repositorio en memoria para probar el almacenamiento de cobros sin depender