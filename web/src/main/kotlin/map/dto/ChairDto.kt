package map.dto

import java.util.*

class ChairDto() {
    var coordinateX: Double = 0.0
    var coordinateY: Double = 0.0
    var id: UUID = UUID.randomUUID()
    var creator: String = ""
    var height: Int = 0
    var legsAmount: Int = 0

    constructor(
        coordinateX: Double, coordinateY: Double, id: UUID, creator: String, height: Int, legsAmount: Int
    ) : this() {
        this.coordinateX = coordinateX
        this.coordinateY = coordinateY
        this.id = id
        this.creator = creator
        this.height = height
        this.legsAmount = legsAmount
    }
}