package map.repositories

import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepository
import map.extensions.toWall
import map.extensions.toWallDbModel
import map.models.Wall
import map.models.WallDbModel
import java.util.*
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class WallRepository : PanacheRepository<WallDbModel> {
    fun save(wall: Wall) {
        persist(wall.toWallDbModel())
    }

    fun getById(wallId: UUID): Wall {
        return list("id", wallId).first().toWall()
    }

    fun deleteById(wallId: UUID) {
        delete("id", getById(wallId))
    }

    fun getAll(): List<Wall> {
        val tableList: MutableList<Wall> = mutableListOf()

        findAll().list().forEach { tableList.add(it.toWall()) }

        return tableList
    }
}