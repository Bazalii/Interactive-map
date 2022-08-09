package map.services

import map.models.Chair
import map.models.Table
import map.models.Wall
import java.util.*

interface IMapService {
    fun saveTable(table: Table): Table
    fun saveChair(chair: Chair): Chair
    fun saveWall(wall: Wall): Wall
    fun deleteTableById(id: UUID): Table
    fun deleteChairById(id: UUID): Chair
    fun deleteWallById(id: UUID): Wall
    fun getTableById(id: UUID): Table
    fun getChairById(id: UUID): Chair
    fun getWallById(id: UUID): Wall
    fun getAllTables(): List<Table>
    fun getAllChairs(): List<Chair>
    fun getAllWalls(): List<Wall>
}