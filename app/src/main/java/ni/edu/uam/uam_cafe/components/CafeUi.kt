package ni.edu.uam.uam_cafe.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun CafeScreen(
    modifier: Modifier = Modifier,
    content: @Composable ColumnScope.() -> Unit
) {
    val background = Brush.verticalGradient(
        colors = listOf(
            MaterialTheme.colorScheme.background,
            MaterialTheme.colorScheme.secondaryContainer.copy(alpha = 0.42f),
            MaterialTheme.colorScheme.tertiaryContainer.copy(alpha = 0.24f)
        )
    )

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(background)
            .statusBarsPadding()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        content = content
    )
}

@Composable
fun CafeHeader(
    title: String,
    subtitle: String,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        color = MaterialTheme.colorScheme.primary,
        tonalElevation = 2.dp,
        shadowElevation = 2.dp
    ) {
        Row(
            modifier = Modifier.padding(18.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            CoffeeMark(
                modifier = Modifier.size(58.dp),
                backgroundColor = MaterialTheme.colorScheme.tertiaryContainer,
                cupColor = MaterialTheme.colorScheme.primary
            )

            Spacer(modifier = Modifier.width(14.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onPrimary
                )
                Text(
                    text = subtitle,
                    modifier = Modifier.padding(top = 4.dp),
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.82f)
                )
            }
        }
    }
}

@Composable
fun CoffeeMark(
    modifier: Modifier = Modifier,
    size: Dp = 56.dp,
    backgroundColor: Color = MaterialTheme.colorScheme.primaryContainer,
    cupColor: Color = MaterialTheme.colorScheme.primary
) {
    Box(
        modifier = modifier.size(size),
        contentAlignment = Alignment.Center
    ) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            shape = CircleShape,
            color = backgroundColor
        ) {}

        Canvas(modifier = Modifier.size(size * 0.72f)) {
            val stroke = Stroke(width = this.size.minDimension * 0.06f, cap = StrokeCap.Round)
            val bodyTop = this.size.height * 0.42f
            val bodyHeight = this.size.height * 0.34f

            drawLine(
                color = cupColor,
                start = Offset(this.size.width * 0.32f, this.size.height * 0.16f),
                end = Offset(this.size.width * 0.26f, this.size.height * 0.29f),
                strokeWidth = stroke.width,
                cap = StrokeCap.Round
            )
            drawLine(
                color = cupColor,
                start = Offset(this.size.width * 0.52f, this.size.height * 0.13f),
                end = Offset(this.size.width * 0.46f, this.size.height * 0.29f),
                strokeWidth = stroke.width,
                cap = StrokeCap.Round
            )
            drawLine(
                color = cupColor,
                start = Offset(this.size.width * 0.70f, this.size.height * 0.17f),
                end = Offset(this.size.width * 0.64f, this.size.height * 0.30f),
                strokeWidth = stroke.width,
                cap = StrokeCap.Round
            )
            drawRoundRect(
                color = cupColor,
                topLeft = Offset(this.size.width * 0.16f, bodyTop),
                size = Size(this.size.width * 0.58f, bodyHeight),
                cornerRadius = CornerRadius(12.dp.toPx(), 12.dp.toPx()),
                style = stroke
            )
            drawCircle(
                color = cupColor,
                radius = this.size.width * 0.13f,
                center = Offset(this.size.width * 0.80f, bodyTop + bodyHeight * 0.48f),
                style = stroke
            )
            drawLine(
                color = cupColor,
                start = Offset(this.size.width * 0.16f, this.size.height * 0.86f),
                end = Offset(this.size.width * 0.78f, this.size.height * 0.86f),
                strokeWidth = stroke.width,
                cap = StrokeCap.Round
            )
        }
    }
}

@Composable
fun CategoryBadge(
    text: String,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier,
        shape = RoundedCornerShape(8.dp),
        color = MaterialTheme.colorScheme.secondaryContainer
    ) {
        Text(
            text = text,
            modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp),
            style = MaterialTheme.typography.labelMedium,
            fontWeight = FontWeight.SemiBold,
            color = MaterialTheme.colorScheme.onSecondaryContainer
        )
    }
}

@Composable
fun PricePill(
    text: String,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier,
        shape = RoundedCornerShape(8.dp),
        color = MaterialTheme.colorScheme.tertiaryContainer
    ) {
        Text(
            text = text,
            modifier = Modifier.padding(horizontal = 12.dp, vertical = 7.dp),
            style = MaterialTheme.typography.labelLarge,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onTertiaryContainer
        )
    }
}