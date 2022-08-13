package map.dto

class WallRequest() {
    var coordinateX: Double = 0.0
    var coordinateY: Double = 0.0
    var creator: String = ""
    var length: Int = 0
    var width: Int = 0

    constructor(
        coordinateX: Double, coordinateY: Double, creator: String, length: Int, width: Int
    ) : this() {
        this.coordinateX = coordinateX
        this.coordinateY = coordinateY
        this.creator = creator
        this.length = length
        this.width = width
    }
}