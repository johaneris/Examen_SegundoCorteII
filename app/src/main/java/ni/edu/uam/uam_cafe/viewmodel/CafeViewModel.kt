package ni.edu.uam.uam_cafe.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import ni.edu.uam.uam_cafe.data.ProductoData
import ni.edu.uam.uam_cafe.models.PedidoItem
import ni.edu.uam.uam_cafe.models.Producto

class CafeViewModel : ViewModel() {
    var productos by mutableStateOf(ProductoData.productosIniciales)
        private set

    var pedido by mutableStateOf<List<PedidoItem>>(emptyList())
        private set

    private var siguienteProductoId = ProductoData.productosIniciales.maxOf { it.id } + 1

    val totalPedido: Double
        get() = pedido.sumOf { it.subtotal }

    fun obtenerProducto(productoId: Int): Producto? {
        return productos.find { it.id == productoId }
    }

    fun agregarAlPedido(producto: Producto) {
        val itemExistente = pedido.find { it.producto.id == producto.id }

        pedido = if (itemExistente == null) {
            pedido + PedidoItem(producto = producto, cantidad = 1)
        } else {
            pedido.map { item ->
                if (item.producto.id == producto.id) item.copy(cantidad = item.cantidad + 1) else item
            }
        }
    }

    fun actualizarCantidad(productoId: Int, nuevaCantidad: Int) {
        pedido = if (nuevaCantidad <= 0) {
            pedido.filterNot { it.producto.id == productoId }
        } else {
            pedido.map { item ->
                if (item.producto.id == productoId) item.copy(cantidad = nuevaCantidad) else item
            }
        }
    }

    fun eliminarDelPedido(productoId: Int) {
        pedido = pedido.filterNot { it.producto.id == productoId }
    }

    fun registrarProducto(nombre: String, precio: Double, categoria: String, descripcion: String) {
        val nuevoProducto = Producto(
            id = siguienteProductoId,
            nombre = nombre.trim(),
            precio = precio,
            categoria = categoria.trim(),
            descripcion = descripcion.trim()
        )

        productos = productos + nuevoProducto
        siguienteProductoId++
    }

    fun limpiarPedido() {
        pedido = emptyList()
    }
}