package ni.edu.uam.uam_cafe

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import ni.edu.uam.uam_cafe.navigation.AppNavigation
import ni.edu.uam.uam_cafe.ui.theme.Uam_CafeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Uam_CafeTheme {
                AppNavigation()
            }
        }
    }
}
