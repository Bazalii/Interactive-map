package map.dto

class TableRequest() {
    var coordinateX: Double = 0.0
    var coordinateY: Double = 0.0
    var creator: String = ""
    var length: Int = 0
    var width: Int = 0
    var color: String = ""

    constructor(
        coordinateX: Double, coordinateY: Double, creator: String, length: Int, width: Int, color: String
    ) : this() {
        this.coordinateX = coordinateX
        this.coordinateY = coordinateY
        this.creator = creator
        this.length = length
        this.width = width
        this.color = color
    }
}