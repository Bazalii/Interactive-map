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
    fun save(wall: Wall): Wall {
        persist(wall.toWallDbModel())

        return getById(wall.id)
    }

    fun getById(id: UUID): Wall {
        return list("id", id).first().toWall()
    }

    fun deleteById(id: UUID): Wall {
        val wall = getById(id)

        delete("id", id)

        return wall
    }

    fun getAll(): List<Wall> {
        val tableList: MutableList<Wall> = mutableListOf()

        findAll().list().forEach { tableList.add(it.toWall()) }

        return tableList
    }
}