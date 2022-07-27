package map.models

import java.util.*

data class Wall(
    val length: Int,
    val width: Int,
    val creator: String,
    val coordinateX: Double,
    val coordinateY: Double,
    val id: UUID
)