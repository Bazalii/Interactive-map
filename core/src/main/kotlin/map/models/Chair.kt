package map.models

import java.util.*

data class Chair(
    val coordinateX: Double,
    val coordinateY: Double,
    var id: UUID = UUID.fromString("00000000-0000-0000-0000-000000000000"),
    val creator: String,
    val height: Int,
    val legsAmount: Int
)