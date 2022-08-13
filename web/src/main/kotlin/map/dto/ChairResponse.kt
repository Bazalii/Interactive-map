package map.dto

import java.util.*

data class ChairResponse (
    var coordinateX: Double,
    var coordinateY: Double,
    var id: UUID,
    var creator: String,
    var height: Int,
    var legsAmount: Int
)