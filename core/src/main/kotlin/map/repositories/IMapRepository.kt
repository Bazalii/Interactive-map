package map.repositories

import map.models.Chair
import map.models.Table
import map.models.Wall
import java.util.UUID

interface IMapRepository {
    fun saveTable(table: Table)
    fun saveChair(chair: Chair)
    fun saveWall(wall: Wall)
    fun deleteTableById(id: UUID)
    fun deleteChairById(id: UUID)
    fun deleteWallById(id: UUID)
    fun getTableById(id: UUID): Table
    fun getChairById(id: UUID): Chair
    fun getWallById(id: UUID): Wall
    fun getAllTables(): List<Table>
    fun getAllChairs(): List<Chair>
    fun getAllWalls(): List<Wall>
}