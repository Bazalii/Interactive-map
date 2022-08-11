package map

import map.models.Chair
import map.models.Table
import map.models.Wall
import java.util.UUID

class Variables() {
    private lateinit var chair: Chair
    private lateinit var table: Table
    private lateinit var wall: Wall
    private lateinit var id: UUID

    constructor(chair: Chair): this() {
        this.chair = chair
    }

    constructor(table: Table): this() {
        this.table = table
    }

    constructor(wall: Wall): this() {
        this.wall = wall
    }

    constructor(id: UUID): this() {
        this.id = id
    }

    fun getChair(): Chair {
        return chair
    }

    fun setChair(chair: Chair) {
        this.chair = chair
    }

    fun getTable(): Table {
        return table
    }

    fun setTable(table: Table) {
        this.table = table
    }

    fun getWall(): Wall {
        return wall
    }

    fun setWall(wall: Wall) {
        this.wall = wall
    }

    fun getId(): UUID {
        return id
    }

    fun setId(id: UUID) {
        this.id = id
    }
}