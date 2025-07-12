# Gestor de Usuarios y Permisos – Sistema con TDD, Mocking y JaCoCo

Este proyecto es una implementación de un sistema de gestión de usuarios utilizando **Test-Driven Development (TDD)**, con pruebas unitarias usando **JUnit 5**, simulación de dependencias con **Mockito**, y reporte de cobertura de código con **JaCoCo**.

---

## Funcionalidades implementadas

- Registro de usuarios con nombre y rol.
- Modificación de rol de usuario.
- Eliminación de usuario por nombre.
- Consulta de usuarios existentes.
- Control de permisos según rol (ADMINISTRADOR, SUPERVISOR, USUARIO).

---

## Tecnologías y herramientas utilizadas

- Java 17  
- Maven  
- JUnit 5  
- Mockito  
- JaCoCo  
- IntelliJ IDEA  
- SQLOnline (simulación de base de datos)  
- Git  

---

## Estructura del proyecto

```
GestorOT/
│
├── src/
│   ├── main/
│   │   ├── java/com/portfolio/auth/
│   │   │   ├── model/             # Clases Usuario, Rol
│   │   │   ├── repository/        # Interfaces y clases concretas (mock, memoria, SQL simulado)
│   │   │   └── service/           # UsuarioService con lógica de negocio
│   └── test/
│       └── java/com/portfolio/auth/
│           └── service/           # Pruebas unitarias con JUnit y Mockito
│
├── pom.xml                       # Configuración de Maven y dependencias
└── README.md
```

---

## ¿Cómo ejecutar el proyecto?

### 1. Clona el repositorio

```bash
git clone https://github.com/tu-usuario/GestorOT.git
cd GestorOT
```

### 2. Compila y ejecuta las pruebas

```bash
mvn clean test
```

### 3. Genera el reporte de cobertura con JaCoCo

```bash
mvn jacoco:report
```

Luego abre el archivo HTML generado en tu navegador:

```bash
target/site/jacoco/index.html
```

---

## Pruebas implementadas

- 10+ pruebas unitarias cubriendo todos los escenarios funcionales (creación, modificación, eliminación, búsquedas).
- Validación de condiciones de error (usuario inexistente, duplicados).
- Mocking con Mockito para simular un repositorio SQL.

---

## Notas sobre SQLOnline

Aunque no se conecta a una base de datos real, se simuló la lógica SQL mediante una clase `UsuarioSqlRepository` que imprime comandos SQL a consola. Esto permite visualizar cómo sería la interacción real sin necesidad de un motor de base de datos.

---

## Buenas prácticas aplicadas

- Principios SOLID (Single Responsibility, Dependency Injection, etc.).
- TDD en todos los ciclos de desarrollo.
- Refactorización continua y limpieza de código.
- Uso de mocks para desacoplar servicios de infraestructura.

---

## Licencia

MIT License - Puedes utilizar y modificar este proyecto con fines personales o académicos.

---

## Autor

Desarrollado por **BordonesC** – Proyecto para portafolio curso Automatización.