package map.models

import java.util.*

data class Table(
    val length: Int,
    val width: Int,
    val creator: String,
    val color: String,
    val coordinateX: Double,
    val coordinateY: Double,
    val id: UUID
)