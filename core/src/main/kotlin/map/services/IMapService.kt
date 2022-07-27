package map.services

import map.models.Chair
import map.models.Table
import map.models.Wall
import java.util.*

interface IMapService {
    fun saveTable(table: Table)
    fun saveChair(chair: Chair)
    fun saveWall(wall: Wall)
    fun deleteTableById(tableId: UUID)
    fun deleteChairById(chairId: UUID)
    fun deleteWallById(wallId: UUID)
    fun getTableById(tableId: UUID): Table
    fun getChairById(chairId: UUID): Chair
    fun getWallById(wallId: UUID): Wall
    fun getAllTables(): List<Table>
    fun getAllChairs(): List<Chair>
    fun getAllWalls(): List<Wall>
}