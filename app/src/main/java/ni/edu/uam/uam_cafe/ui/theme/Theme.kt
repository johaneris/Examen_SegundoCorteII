package ni.edu.uam.uam_cafe.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary = CoffeeDarkPrimary,
    onPrimary = CafeText,
    primaryContainer = CoffeeDarkSurfaceVariant,
    onPrimaryContainer = CoffeeDarkPrimary,
    secondary = MatchaSecondaryLight,
    onSecondary = CafeText,
    secondaryContainer = CoffeeDarkSurfaceVariant,
    onSecondaryContainer = MatchaSecondaryLight,
    tertiary = HoneyTertiaryLight,
    background = CoffeeDarkBackground,
    onBackground = Color(0xFFF4E8DD),
    surface = CoffeeDarkSurface,
    onSurface = Color(0xFFF4E8DD),
    surfaceVariant = CoffeeDarkSurfaceVariant,
    onSurfaceVariant = Color(0xFFD5C3B6)
)

private val LightColorScheme = lightColorScheme(
    primary = CoffeePrimary,
    onPrimary = Color.White,
    primaryContainer = CoffeePrimaryLight,
    onPrimaryContainer = CafeText,
    secondary = MatchaSecondary,
    onSecondary = Color.White,
    secondaryContainer = MatchaSecondaryLight,
    onSecondaryContainer = Color(0xFF143B31),
    tertiary = HoneyTertiary,
    onTertiary = Color.White,
    tertiaryContainer = HoneyTertiaryLight,
    onTertiaryContainer = CafeText,
    background = CafeBackground,
    onBackground = CafeText,
    surface = CafeSurface,
    onSurface = CafeText,
    surfaceVariant = CafeSurfaceVariant,
    onSurfaceVariant = CafeMutedText
)

@Composable
fun Uam_CafeTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
