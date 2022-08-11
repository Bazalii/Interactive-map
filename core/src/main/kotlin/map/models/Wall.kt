package map.models

import java.util.*

data class Wall (
    var coordinateX: Double,
    var coordinateY: Double,
    var id: UUID,
    var creator: String,
    var length: Int,
    var width: Int
)