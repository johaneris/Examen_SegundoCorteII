package ni.edu.uam.uam_cafe.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import ni.edu.uam.uam_cafe.components.CafeHeader
import ni.edu.uam.uam_cafe.components.CafeScreen
import ni.edu.uam.uam_cafe.components.ProductoCard
import ni.edu.uam.uam_cafe.models.Producto

@Composable
fun CatalogoScreen(
    productos: List<Producto>,
    cantidadPedido: Int,
    onProductoClick: (Producto) -> Unit,
    onVerPedido: () -> Unit,
    onRegistrarProducto: () -> Unit
) {
    CafeScreen {
        CafeHeader(
            title = "Catálogo",
            subtitle = "Bebidas, comidas y postres listos para tu pedido."
        )

        Surface(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(8.dp),
            color = MaterialTheme.colorScheme.surface.copy(alpha = 0.94f)
        ) {
            Row(
                modifier = Modifier.padding(14.dp),
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = "${productos.size} productos",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "$cantidadPedido artículos en pedido",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }

                OutlinedButton(
                    onClick = onRegistrarProducto,
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Text("Registrar")
                }
            }
        }

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .weight(1f),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(productos, key = { it.id }) { producto ->
                ProductoCard(
                    producto = producto,
                    onClick = { onProductoClick(producto) }
                )
            }
        }

        Button(
            onClick = onVerPedido,
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.secondary
            )
        ) {
            Text(
                text = "Ver pedido ($cantidadPedido)",
                modifier = Modifier.padding(vertical = 5.dp)
            )
        }
    }
}
