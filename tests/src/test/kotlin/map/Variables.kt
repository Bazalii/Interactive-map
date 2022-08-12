package map

import map.dto.ChairDto
import map.dto.TableDto
import map.dto.WallDto
import java.util.*

class Variables() {
    lateinit var chairDto: ChairDto
    lateinit var tableDto: TableDto
    lateinit var wallDto: WallDto
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

    constructor(idDtoInput: UUID) : this() {
        id = idDtoInput
    }
}