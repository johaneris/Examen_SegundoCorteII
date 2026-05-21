package ni.edu.uam.uam_cafe.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import ni.edu.uam.uam_cafe.models.PedidoItem

@Composable
fun PedidoItemCard(
    item: PedidoItem,
    onCambiarCantidad: (Int) -> Unit,
    onEliminar: () -> Unit,
    modifier: Modifier = Modifier
) {
    ElevatedCard(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.elevatedCardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 3.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.Top
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = item.producto.nombre,
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.SemiBold
                    )
                    Text(
                        text = "${formatearPrecio(item.producto.precio)} c/u",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }

                Text(
                    text = formatearPrecio(item.subtotal),
                    style = MaterialTheme.typography.titleSmall,
                    fontWeight = FontWeight.Bold
                )
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                OutlinedButton(
                    onClick = { onCambiarCantidad(item.cantidad - 1) },
                    modifier = Modifier.sizeIn(minWidth = 44.dp),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Text("-")
                }

                Spacer(modifier = Modifier.width(12.dp))

                Text(
                    text = item.cantidad.toString(),
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.SemiBold
                )

                Spacer(modifier = Modifier.width(12.dp))

                OutlinedButton(
                    onClick = { onCambiarCantidad(item.cantidad + 1) },
                    modifier = Modifier.sizeIn(minWidth = 44.dp),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Text("+")
                }

                Spacer(modifier = Modifier.weight(1f))

                TextButton(onClick = onEliminar) {
                    Text("Eliminar")
                }
            }
        }
    }
}