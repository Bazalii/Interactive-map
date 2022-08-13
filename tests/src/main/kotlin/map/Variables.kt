package map

import com.google.gson.annotations.SerializedName
import map.dto.*
import java.util.*

class Variables() {
    @SerializedName("chairRequest")
    lateinit var chair: ChairRequest
    @SerializedName("tableRequest")
    lateinit var table: TableRequest
    @SerializedName("wallRequest")
    lateinit var wall: WallRequest
    @SerializedName("id")
    lateinit var id: UUID

    constructor(chairRequest: ChairRequest) : this() {
        chair = chairRequest
    }

    constructor(tableRequest: TableRequest) : this() {
        table = tableRequest
    }

    constructor(wallRequest: WallRequest) : this() {
        wall = wallRequest
    }

    constructor(idInput: UUID) : this() {
        id = idInput
    }
}