package map

import map.dto.ChairDto
import map.dto.TableDto
import map.dto.WallDto
import java.util.*

class Variables() {
    private lateinit var chairDto: ChairDto
    private lateinit var tableDto: TableDto
    private lateinit var wallDto: WallDto
    private lateinit var id: UUID

    constructor(chair: ChairDto) : this() {
        this.chairDto = chair
    }

    constructor(table: TableDto) : this() {
        this.tableDto = table
    }

    constructor(wall: WallDto) : this() {
        this.wallDto = wall
    }

    constructor(id: UUID) : this() {
        this.id = id
    }

    fun getChair(): ChairDto {
        return chairDto
    }

    fun setChair(chair: ChairDto) {
        this.chairDto = chair
    }

    fun getTable(): TableDto {
        return tableDto
    }

    fun setTable(table: TableDto) {
        this.tableDto = table
    }

    fun getWall(): WallDto {
        return wallDto
    }

    fun setWall(wall: WallDto) {
        this.wallDto = wall
    }

    fun getId(): UUID {
        return id
    }

    fun setId(id: UUID) {
        this.id = id
    }
}