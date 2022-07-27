package map.repositories

import map.models.*
import java.util.*

class MapRepository(
    private val chairRepository: ChairRepository,
    private val wallRepository: WallRepository,
    private val tableRepository: TableRepository,
) : IMapRepository {
    override fun saveTable(table: Table) {
        tableRepository.saveTable(table)
    }

    override fun saveChair(chair: Chair) {
        chairRepository.saveChair(chair)
    }

    override fun saveWall(wall: Wall) {
        wallRepository.saveWall(wall)
    }

    override fun deleteTableById(tableId: UUID) {
        return tableRepository.deleteTableById(tableId)
    }

    override fun deleteChairById(chairId: UUID) {
        return chairRepository.deleteChairById(chairId)
    }

    override fun deleteWallById(wallId: UUID) {
        return wallRepository.deleteWallById(wallId)
    }

    override fun getTableById(tableId: UUID): Table {
        return tableRepository.getTableById(tableId)
    }

    override fun getChairById(chairId: UUID): Chair {
        return chairRepository.getChairById(chairId)
    }

    override fun getWallById(wallId: UUID): Wall {
        return wallRepository.getWallById(wallId)
    }

    override fun getAllTables(): List<Table> {
        return tableRepository.getAllTables()
    }

    override fun getAllChairs(): List<Chair> {
        return chairRepository.getAllChairs()
    }

    override fun getAllWalls(): List<Wall> {
        return wallRepository.getAllWalls()
    }
}