package map

import com.google.gson.annotations.SerializedName
import map.dto.ChairDto
import map.dto.TableDto
import map.dto.WallDto
import java.util.*

class Variables() {
    @SerializedName("chairDto")
    lateinit var chairDto: ChairDto
    @SerializedName("tableDto")
    lateinit var tableDto: TableDto
    @SerializedName("wallDto")
    lateinit var wallDto: WallDto
    @SerializedName("id")
    lateinit var id: UUID

    constructor(chairDtoInput: ChairDto) : this() {
        chairDto = chairDtoInput
    }

    constructor(tableDtoInput: TableDto) : this() {
        tableDto = tableDtoInput
    }

    constructor(wallDtoInput: WallDto) : this() {
        wallDto = wallDtoInput
    }

    constructor(idInput: UUID) : this() {
        id = idInput
    }
}