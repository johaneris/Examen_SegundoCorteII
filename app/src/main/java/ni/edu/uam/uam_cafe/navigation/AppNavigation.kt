package ni.edu.uam.uam_cafe.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import ni.edu.uam.uam_cafe.screens.CatalogoScreen
import ni.edu.uam.uam_cafe.screens.DetalleProductoScreen
import ni.edu.uam.uam_cafe.screens.InicioScreen
import ni.edu.uam.uam_cafe.screens.PedidoScreen
import ni.edu.uam.uam_cafe.screens.RegistrarProductoScreen
import ni.edu.uam.uam_cafe.screens.ResumenPedidoScreen
import ni.edu.uam.uam_cafe.viewmodel.CafeViewModel

object Rutas {
    const val INICIO = "inicio"
    const val CATALOGO = "catalogo"
    const val DETALLE = "detalle"
    const val PEDIDO = "pedido"
    const val REGISTRAR = "registrar"
    const val RESUMEN = "resumen"

    fun detalleProducto(productoId: Int) = "$DETALLE/$productoId"
}

@Composable
fun AppNavigation(cafeViewModel: CafeViewModel = viewModel()) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Rutas.INICIO
    ) {
        composable(Rutas.INICIO) {
            InicioScreen(
                onIrCatalogo = { navController.navigate(Rutas.CATALOGO) }
            )
        }

        composable(Rutas.CATALOGO) {
            CatalogoScreen(
                productos = cafeViewModel.productos,
                cantidadPedido = cafeViewModel.pedido.sumOf { it.cantidad },
                onProductoClick = { producto ->
                    navController.navigate(Rutas.detalleProducto(producto.id))
                },
                onVerPedido = { navController.navigate(Rutas.PEDIDO) },
                onRegistrarProducto = { navController.navigate(Rutas.REGISTRAR) }
            )
        }

        composable(
            route = "${Rutas.DETALLE}/{productoId}",
            arguments = listOf(navArgument("productoId") { type = NavType.IntType })
        ) { backStackEntry ->
            val productoId = backStackEntry.arguments?.getInt("productoId") ?: 0

            DetalleProductoScreen(
                producto = cafeViewModel.obtenerProducto(productoId),
                onAgregarPedido = { producto ->
                    cafeViewModel.agregarAlPedido(producto)
                    navController.navigate(Rutas.PEDIDO)
                },
                onVolver = { navController.popBackStack() }
            )
        }

        composable(Rutas.PEDIDO) {
            PedidoScreen(
                pedido = cafeViewModel.pedido,
                total = cafeViewModel.totalPedido,
                onCambiarCantidad = cafeViewModel::actualizarCantidad,
                onEliminar = cafeViewModel::eliminarDelPedido,
                onVolverCatalogo = { navController.navigate(Rutas.CATALOGO) },
                onConfirmar = { navController.navigate(Rutas.RESUMEN) }
            )
        }

        composable(Rutas.REGISTRAR) {
            RegistrarProductoScreen(
                onRegistrar = { nombre, precio, categoria, descripcion ->
                    cafeViewModel.registrarProducto(nombre, precio, categoria, descripcion)
                    navController.popBackStack()
                },
                onCancelar = { navController.popBackStack() }
            )
        }

        composable(Rutas.RESUMEN) {
            ResumenPedidoScreen(
                pedido = cafeViewModel.pedido,
                total = cafeViewModel.totalPedido,
                onNuevoPedido = {
                    cafeViewModel.limpiarPedido()
                    navController.navigate(Rutas.CATALOGO) {
                        popUpTo(Rutas.CATALOGO) { inclusive = true }
                    }
                }
            )
        }
    }
}
