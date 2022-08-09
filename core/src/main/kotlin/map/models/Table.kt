package map.models

import java.util.*

class Table() {
    var coordinateX: Double = 0.0
    var coordinateY: Double = 0.0
    var id: UUID = UUID.randomUUID()
    var creator: String = ""
    var length: Int = 0
    var width: Int = 0
    var color: String = ""

    constructor(
        coordinateX: Double, coordinateY: Double, id: UUID, creator: String, length: Int, width: Int, color: String
    ) : this() {
        this.coordinateX = coordinateX
        this.coordinateY = coordinateY
        this.id = id
        this.creator = creator
        this.length = length
        this.width = width
        this.color = color
    }
}
