package ni.edu.uam.uam_cafe.models

data class PedidoItem(
    val producto: Producto,
    val cantidad: Int
) {
    val subtotal: Double
        get() = producto.precio * cantidad
}