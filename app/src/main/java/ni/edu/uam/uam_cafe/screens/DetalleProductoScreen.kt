package ni.edu.uam.uam_cafe.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import ni.edu.uam.uam_cafe.components.CafeHeader
import ni.edu.uam.uam_cafe.components.CafeScreen
import ni.edu.uam.uam_cafe.components.CategoryBadge
import ni.edu.uam.uam_cafe.components.CoffeeMark
import ni.edu.uam.uam_cafe.components.PricePill
import ni.edu.uam.uam_cafe.components.formatearPrecio
import ni.edu.uam.uam_cafe.models.Producto

@Composable
fun DetalleProductoScreen(
    producto: Producto?,
    onAgregarPedido: (Producto) -> Unit,
    onVolver: () -> Unit
) {
    CafeScreen {
        OutlinedButton(
            onClick = onVolver,
            shape = RoundedCornerShape(8.dp)
        ) {
            Text("Volver")
        }

        if (producto == null) {
            CafeHeader(
                title = "Producto no encontrado",
                subtitle = "Regresa al catálogo e intenta seleccionar otro producto."
            )
            return@CafeScreen
        }

        CafeHeader(
            title = "Detalle",
            subtitle = "Revisa el producto antes de agregarlo a tu pedido."
        )

        ElevatedCard(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(8.dp),
            colors = CardDefaults.elevatedCardColors(
                containerColor = MaterialTheme.colorScheme.surface
            ),
            elevation = CardDefaults.elevatedCardElevation(defaultElevation = 4.dp)
        ) {
            Column(
                modifier = Modifier.padding(20.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    CoffeeMark(
                        modifier = Modifier.size(78.dp),
                        size = 78.dp,
                        backgroundColor = MaterialTheme.colorScheme.tertiaryContainer,
                        cupColor = MaterialTheme.colorScheme.primary
                    )

                    Column(
                        modifier = Modifier
                            .weight(1f)
                            .padding(start = 16.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        CategoryBadge(text = producto.categoria)
                        Text(
                            text = producto.nombre,
                            style = MaterialTheme.typography.headlineMedium,
                            fontWeight = FontWeight.Black,
                            color = MaterialTheme.colorScheme.primary
                        )
                    }
                }

                Text(
                    text = producto.descripcion,
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Precio",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.SemiBold
                    )
                    PricePill(text = formatearPrecio(producto.precio))
                }
            }
        }

        Button(
            onClick = { onAgregarPedido(producto) },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.primary
            )
        ) {
            Text(
                text = "Agregar al pedido",
                modifier = Modifier.padding(vertical = 5.dp)
            )
        }
    }
}
