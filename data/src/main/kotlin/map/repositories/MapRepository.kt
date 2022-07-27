package map.repositories

import map.models.*
import java.util.*
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class MapRepository(
    private val _chairRepository: ChairRepository,
    private val _wallRepository: WallRepository,
    private val _tableRepository: TableRepository,
) : IMapRepository {
    override fun saveTable(table: Table) {
        _tableRepository.save(table)
    }

    override fun saveChair(chair: Chair) {
        _chairRepository.save(chair)
    }

    override fun saveWall(wall: Wall) {
        _wallRepository.save(wall)
    }

    override fun deleteTableById(id: UUID) {
        return _tableRepository.deleteById(id)
    }

    override fun deleteChairById(id: UUID) {
        return _chairRepository.deleteById(id)
    }

    override fun deleteWallById(id: UUID) {
        return _wallRepository.deleteById(id)
    }

    override fun getTableById(id: UUID): Table {
        return _tableRepository.getById(id)
    }

    override fun getChairById(id: UUID): Chair {
        return _chairRepository.getById(id)
    }

    override fun getWallById(id: UUID): Wall {
        return _wallRepository.getById(id)
    }

    override fun getAllTables(): List<Table> {
        return _tableRepository.getAll()
    }

    override fun getAllChairs(): List<Chair> {
        return _chairRepository.getAll()
    }

    override fun getAllWalls(): List<Wall> {
        return _wallRepository.getAll()
    }
}