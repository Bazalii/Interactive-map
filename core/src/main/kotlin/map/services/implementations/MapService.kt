package map.services.implementations

import map.models.Chair
import map.models.Table
import map.models.Wall
import map.repositories.IMapRepository
import map.services.IMapService
import java.util.*
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class MapService(
    private val repository: IMapRepository,
) : IMapService {


    override fun saveTable(table: Table) {
        repository.saveTable(table)
    }

    override fun saveChair(chair: Chair) {
        repository.saveChair(chair)
    }

    override fun saveWall(wall: Wall) {
        repository.saveWall(wall)
    }

    override fun deleteTableById(tableId: UUID) {
        repository.deleteTableById(tableId)
    }

    override fun deleteChairById(chairId: UUID) {
        repository.deleteChairById(chairId)
    }

    override fun deleteWallById(wallId: UUID) {
        repository.deleteWallById(wallId)
    }

    override fun getTableById(tableId: UUID): Table {
        return repository.getTableById(tableId)
    }

    override fun getChairById(chairId: UUID): Chair {
        return repository.getChairById(chairId)
    }

    override fun getWallById(wallId: UUID): Wall {
        return repository.getWallById(wallId)
    }

    override fun getAllTables(): List<Table> {
        return repository.getAllTables()
    }

    override fun getAllChairs(): List<Chair> {
        return repository.getAllChairs()
    }

    override fun getAllWalls(): List<Wall> {
        return repository.getAllWalls()
    }
}