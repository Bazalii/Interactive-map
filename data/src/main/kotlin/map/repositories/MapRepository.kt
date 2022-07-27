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

    override fun deleteTableById(tableId: UUID) {
        return _tableRepository.deleteById(tableId)
    }

    override fun deleteChairById(chairId: UUID) {
        return _chairRepository.deleteById(chairId)
    }

    override fun deleteWallById(wallId: UUID) {
        return _wallRepository.deleteById(wallId)
    }

    override fun getTableById(tableId: UUID): Table {
        return _tableRepository.getById(tableId)
    }

    override fun getChairById(chairId: UUID): Chair {
        return _chairRepository.getById(chairId)
    }

    override fun getWallById(wallId: UUID): Wall {
        return _wallRepository.getById(wallId)
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