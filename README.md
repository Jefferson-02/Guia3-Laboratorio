Guía de Laboratorio N° 3 - Relaciones entre Clases y Diseño Orientado a Objetos

Proyecto académico desarrollado para el curso Lenguajes de Programación.

Descripción del Proyecto:
Implementación integral de un sistema de gestión empresarial en Java que demuestra las relaciones entre clases (DOO), el uso de colecciones y los principios de POO.
- Encapsulamiento: Modificadores de acceso privados con métodos getters/setters controlados.
- Herencia y Polimorfismo: Superclase abstracta `Empleado` y subclases `Desarrollador` y `Gerente` con sobreescritura de métodos (`calcularSalarioNeto()`).
- Asociación: Relación débil entre `Empleado` y `Proyecto`.
- Agregación: `Departamento` agrupa una colección dinámica (`List<Empleado>`) que subsiste independientemente.
- Composición: `Contrato` instanciado internamente por `Empleado`, compartiendo su ciclo de vida.
- Reflexividad: Jerarquía interna donde un `Empleado` referencia a otro como supervisor.

Tecnologías y Entorno:
- Lenguaje: Java 21
- IDE: Visual Studio Code 
- Modelado: PlantUML

Ejecución

Compilación y ejecución desde consola:

```bash
javac Main.java
java Main
```

Autor
Jefferson Rojas Carrera (N00542067)
