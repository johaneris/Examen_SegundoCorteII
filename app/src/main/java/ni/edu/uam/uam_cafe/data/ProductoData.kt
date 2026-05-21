package ni.edu.uam.uam_cafe.data

import ni.edu.uam.uam_cafe.models.Producto

object ProductoData {
    val productosIniciales = listOf(
        Producto(
            id = 1,
            nombre = "Café Americano",
            precio = 45.0,
            categoria = "Bebidas calientes",
            descripcion = "Café negro recién preparado, ideal para iniciar la mañana."
        ),
        Producto(
            id = 2,
            nombre = "Capuchino",
            precio = 65.0,
            categoria = "Bebidas calientes",
            descripcion = "Café espresso con leche vaporizada y espuma cremosa."
        ),
        Producto(
            id = 3,
            nombre = "Frappe de Vainilla",
            precio = 85.0,
            categoria = "Bebidas frías",
            descripcion = "Bebida fría con vainilla, hielo y crema batida."
        ),
        Producto(
            id = 4,
            nombre = "Sandwich de Pollo",
            precio = 95.0,
            categoria = "Comidas",
            descripcion = "Pan tostado con pollo, vegetales frescos y aderezo de la casa."
        ),
        Producto(
            id = 5,
            nombre = "Brownie",
            precio = 55.0,
            categoria = "Postres",
            descripcion = "Postre de chocolate suave, perfecto para acompañar el café."
        )
    )
}