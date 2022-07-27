package map.repositories

import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepository
import map.models.Wall
import map.models.WallDbModel
import java.util.*

class WallRepository : PanacheRepository<WallDbModel> {
    fun saveWall(wall: Wall) {
        persist(WallDbModel.ModelMapper.toWallDbModel(wall))
    }

    fun getWallById(wallId: UUID): Wall {
        return WallDbModel.ModelMapper.toWall(list("id", wallId).first())
    }

    fun deleteWallById(wallId: UUID) {
        delete("id", getWallById(wallId))
    }

    fun getAllWalls(): List<Wall> {
        val list = findAll().list()
        val tableList: MutableList<Wall> = mutableListOf()
        for (model in list) {
            tableList.add(WallDbModel.ModelMapper.toWall(model))
        }
        return tableList
    }
}