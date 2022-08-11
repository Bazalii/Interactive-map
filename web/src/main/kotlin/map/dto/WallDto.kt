package map.dto

import java.util.*

class WallDto() {
    var coordinateX: Double = 0.0
    var coordinateY: Double = 0.0
    var id: UUID = UUID.randomUUID()
     var creator: String = ""
    var length: Int = 0
    var width: Int = 0

    constructor(
        coordinateX: Double, coordinateY: Double, id: UUID, creator: String, length: Int, width: Int
    ) : this() {
        this.coordinateX = coordinateX
        this.coordinateY = coordinateY
        this.id = id
        this.creator = creator
        this.length = length
        this.width = width
    }
}