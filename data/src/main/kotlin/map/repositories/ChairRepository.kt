package map.repositories

import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepository
import map.models.*
import java.util.*

class ChairRepository : PanacheRepository<ChairDbModel> {
    fun saveChair(chair: Chair) {
        persist(ChairDbModel.ModelMapper.toChairDbModel(chair))
    }

    fun getChairById(chairId: UUID): Chair {
        return ChairDbModel.ModelMapper.toChair(list("id", chairId).first())
    }

    fun deleteChairById(chairId: UUID) {
        delete("id", getChairById(chairId))
    }

    fun getAllChairs(): List<Chair> {
        val list = findAll().list()
        val tableList: MutableList<Chair> = mutableListOf()
        for (model in list) {
            tableList.add(ChairDbModel.ModelMapper.toChair(model))
        }
        return tableList
    }
}