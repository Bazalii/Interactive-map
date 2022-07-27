package map.models

import java.util.*

data class Chair(
    val coordinateX: Double,
    val coordinateY: Double,
    val chairLegsAmount: Int,
    var height: Int,
    val creator: String,
    val id: UUID
)