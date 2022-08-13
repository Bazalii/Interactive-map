package map.models

import java.util.*

data class Wall(
    val coordinateX: Double,
    val coordinateY: Double,
    var id: UUID = UUID.fromString("00000000-0000-0000-0000-000000000000"),
    val creator: String,
    val length: Int,
    val width: Int
)