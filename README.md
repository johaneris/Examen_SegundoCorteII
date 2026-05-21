# UAM Café Lite

## Descripción general

UAM Café Lite es una aplicación móvil desarrollada en Android Studio utilizando Kotlin y Jetpack Compose. El proyecto simula un sistema básico de pedidos para una cafetería universitaria, permitiendo al usuario visualizar productos, consultar detalles, agregar productos a un pedido, modificar cantidades y eliminar elementos antes de confirmar la compra.

La aplicación fue creada como parte de una actividad académica orientada al desarrollo de interfaces de usuario, navegación entre pantallas, manejo de estado y aplicación de buenas prácticas en la organización del proyecto.

## Objetivo del proyecto

Desarrollar una aplicación funcional que permita gestionar pedidos básicos de una cafetería universitaria, aplicando conceptos de diseño de interfaz, navegación, manejo de estado y operaciones CRUD dentro de una aplicación móvil.

## Funcionalidades principales

- Visualización de un catálogo de productos.
- Consulta del detalle de cada producto.
- Agregar productos al pedido actual.
- Editar la cantidad de productos en el pedido.
- Eliminar productos del pedido.
- Registrar nuevos productos en el catálogo.
- Visualizar el resumen final del pedido.
- Actualización dinámica de la información mediante manejo de estado.

## Pantallas de la aplicación

La aplicación cuenta con varias pantallas principales:

- **Pantalla de Inicio:** presenta el nombre de la aplicación y una bienvenida al usuario.
- **Pantalla de Catálogo:** muestra la lista de productos disponibles.
- **Pantalla de Detalle de Producto:** presenta información específica de un producto seleccionado.
- **Pantalla de Pedido Actual:** muestra los productos agregados, cantidades y total a pagar.
- **Pantalla de Registro de Producto:** permite ingresar nuevos productos al catálogo.
- **Pantalla de Resumen del Pedido:** muestra la confirmación y el total final del pedido.

## Operaciones CRUD implementadas

| Operación | Descripción |
|---|---|
| Crear | Registro de nuevos productos y agregado de productos al pedido |
| Leer | Visualización del catálogo, detalles de productos y pedido actual |
| Actualizar | Modificación de cantidades dentro del pedido |
| Eliminar | Eliminación de productos del pedido |

## Manejo de estado

El manejo de estado se utiliza para controlar la información dinámica de la aplicación, como la lista de productos, el pedido actual, las cantidades seleccionadas y el total a pagar.

Cada vez que el usuario agrega, edita o elimina un producto, el estado se actualiza y la interfaz refleja automáticamente los cambios realizados.

## Tecnologías utilizadas

- **Android Studio**
- **Kotlin**
- **Jetpack Compose**
- **Material 3**
- **Navigation Compose**
- **ViewModel**
- **Git y GitHub**

## Organización del proyecto

El proyecto fue organizado separando responsabilidades en diferentes paquetes o módulos:

```text
models/
data/
viewmodel/
navigation/
screens/
components/