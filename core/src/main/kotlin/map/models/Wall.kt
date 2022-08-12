package map.models

import java.util.*

data class Wall(
    val coordinateX: Double,
    val coordinateY: Double,
    val id: UUID,
    val creator: String,
    val length: Int,
    val width: Int
)