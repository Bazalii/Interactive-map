package map.repositories

import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepository
import map.extensions.toChair
import map.extensions.toChairDbModel
import map.models.*
import java.util.*
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class ChairRepository : PanacheRepository<ChairDbModel> {
    fun save(chair: Chair) {
        persist(chair.toChairDbModel())
    }

    fun getById(id: UUID): Chair {
        return list("id", id).first().toChair()
    }

    fun deleteById(id: UUID) {
        delete("id", getById(id))
    }

    fun getAll(): List<Chair> {
        val resList: MutableList<Chair> = mutableListOf()

        findAll().list().forEach { resList.add(it.toChair()) }

        return resList
    }
}