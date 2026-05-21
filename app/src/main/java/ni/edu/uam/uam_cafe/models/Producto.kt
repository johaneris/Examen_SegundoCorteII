package ni.edu.uam.uam_cafe.models

data class Producto(
    val id: Int,
    val nombre: String,
    val precio: Double,
    val categoria: String,
    val descripcion: String
)