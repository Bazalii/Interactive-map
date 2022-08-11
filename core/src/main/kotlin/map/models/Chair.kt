package map.models

import java.util.*

data class Chair (
    var coordinateX: Double,
    var coordinateY: Double,
    var id: UUID,
    var creator: String,
    var height: Int,
    var legsAmount: Int
)