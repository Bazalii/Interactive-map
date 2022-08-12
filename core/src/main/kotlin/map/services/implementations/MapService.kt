package map.services.implementations

import map.models.Chair
import map.models.Table
import map.models.Wall
import map.repositories.IMapRepository
import map.services.IMapService
import java.util.*
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class MapService(private val _repository: IMapRepository) : IMapService {
    override fun saveTable(table: Table): Table {
        return _repository.saveTable(table)
    }

    override fun saveChair(chair: Chair): Chair {
        return _repository.saveChair(chair)
    }

    override fun saveWall(wall: Wall): Wall {
        return _repository.saveWall(wall)
    }

    override fun deleteTableById(id: UUID): Table {
        return _repository.deleteTableById(id)
    }

    override fun deleteChairById(id: UUID): Chair {
        return _repository.deleteChairById(id)
    }

    override fun deleteWallById(id: UUID): Wall {
        return _repository.deleteWallById(id)
    }

    override fun getTableById(id: UUID): Table {
        return _repository.getTableById(id)
    }

    override fun getChairById(id: UUID): Chair {
        return _repository.getChairById(id)
    }

    override fun getWallById(id: UUID): Wall {
        return _repository.getWallById(id)
    }

    override fun getAllTables(): List<Table> {
        return _repository.getAllTables()
    }

    override fun getAllChairs(): List<Chair> {
        return _repository.getAllChairs()
    }

    override fun getAllWalls(): List<Wall> {
        return _repository.getAllWalls()
    }
}