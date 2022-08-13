package map.dto

class ChairRequest() {
    var coordinateX: Double = 0.0
    var coordinateY: Double = 0.0
    var creator: String = ""
    var height: Int = 0
    var legsAmount: Int = 0

    constructor(
        coordinateX: Double, coordinateY: Double, creator: String, height: Int, legsAmount: Int
    ) : this() {
        this.coordinateX = coordinateX
        this.coordinateY = coordinateY
        this.creator = creator
        this.height = height
        this.legsAmount = legsAmount
    }
}