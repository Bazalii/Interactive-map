package map.models

import java.util.*

data class Chair(
    val coordinateX: Double,
    val coordinateY: Double,
    val id: UUID,
    val creator: String,
    val height: Int,
    val legsAmount: Int
)