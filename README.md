# UAM Café Lite

## Descripción general

**UAM Café Lite** es una aplicación móvil desarrollada en **Android Studio** utilizando **Kotlin** y **Jetpack Compose**. El proyecto consiste en un sistema sencillo de pedidos para una cafetería universitaria, donde el usuario puede visualizar productos, agregarlos a un pedido, modificar cantidades, eliminar productos y consultar un resumen final antes de confirmar.

La aplicación fue desarrollada con el objetivo de aplicar los conocimientos adquiridos sobre diseño de interfaces de usuario, navegación entre pantallas, manejo de estado, organización del proyecto y buenas prácticas de desarrollo.

## Objetivo del proyecto

Desarrollar una aplicación funcional que permita gestionar de forma básica los pedidos de una cafetería universitaria, aplicando navegación entre pantallas, componentes visuales reutilizables, formularios interactivos y manejo dinámico del estado de la aplicación.

## Funcionalidades implementadas

La aplicación permite realizar las siguientes acciones:

- Visualizar un catálogo de productos disponibles.
- Consultar el detalle de cada producto.
- Agregar productos al pedido actual.
- Editar la cantidad de productos seleccionados.
- Eliminar productos del pedido.
- Registrar nuevos productos desde un formulario.
- Visualizar el resumen final del pedido.
- Calcular automáticamente el total a pagar.
- Navegar entre las diferentes pantallas de la aplicación.

## Pantallas principales

La aplicación está compuesta por las siguientes pantallas:

- **Pantalla de inicio:** presenta el nombre de la aplicación y permite acceder al catálogo.
- **Catálogo de productos:** muestra los productos disponibles en tarjetas visuales.
- **Detalle del producto:** permite ver información específica del producto seleccionado.
- **Pedido actual:** muestra los productos agregados, sus cantidades y el total.
- **Registro de producto:** permite agregar nuevos productos mediante un formulario.
- **Resumen del pedido:** presenta el total final y la confirmación del pedido.

## Manejo de estado

El manejo de estado se implementó para controlar la información dinámica de la aplicación, como la lista de productos, el pedido actual, las cantidades seleccionadas y el total a pagar. Cada vez que el usuario agrega, edita o elimina un producto, la interfaz se actualiza automáticamente para reflejar los cambios realizados.

## Tecnologías utilizadas

- **Android Studio**
- **Kotlin**
- **Jetpack Compose**
- **Material Design 3**
- **Navigation Compose**
- **ViewModel**
- **Git y GitHub**

## Organización del proyecto

El proyecto se organizó de forma modular para facilitar la lectura, mantenimiento y colaboración entre los integrantes del equipo. Se utilizaron nombres descriptivos y separación de responsabilidades entre modelos, pantallas, navegación, componentes y lógica de estado.

Estructura general del proyecto:

```text
app/
 └── src/
     └── main/
         └── java/
             └── com.example.uamcafelite/
                 ├── models/
                 ├── data/
                 ├── viewmodel/
                 ├── navigation/
                 ├── screens/
                 └── components/
```

## Operaciones CRUD

El proyecto cumple con las operaciones básicas de un CRUD de la siguiente manera:

| Operación | Implementación en la aplicación |
|---|---|
| Crear | Registrar nuevos productos y agregar productos al pedido |
| Leer | Visualizar catálogo, detalle de productos y pedido actual |
| Actualizar | Modificar la cantidad de productos en el pedido |
| Eliminar | Quitar productos del pedido |

## Video demostrativo

El funcionamiento general de la aplicación, la navegación entre pantallas, el manejo de estado y las funcionalidades principales se muestran en el siguiente enlace:

[Ver video demostrativo del proyecto](https://drive.google.com/drive/folders/1QcID32iPEBIrJWEL2VCFRju_DjupE_MT?usp=sharing)

## Buenas prácticas aplicadas

Durante el desarrollo del proyecto se aplicaron buenas prácticas como:

- Uso de componentes reutilizables.
- Separación de responsabilidades por carpetas.
- Nombres descriptivos para clases, funciones y variables.
- Uso de control de versiones con Git y GitHub.
- Organización del código para facilitar el trabajo colaborativo.
- Implementación de una interfaz clara, ordenada y funcional.

## Estado del proyecto

El proyecto se encuentra finalizado y cumple con los requisitos establecidos para la actividad: interfaz de usuario, navegación, manejo de estado, funcionalidades CRUD básicas, organización del proyecto y evidencia mediante video demostrativo.