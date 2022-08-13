package map.repositories

import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepository
import map.extensions.toChair
import map.extensions.toChairDbModel
import map.models.Chair
import map.models.ChairDbModel
import java.util.*
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class ChairRepository : PanacheRepository<ChairDbModel> {
    fun save(chair: Chair): Chair {
        persist(chair.toChairDbModel())

        return getById(chair.id)
    }

    fun getById(id: UUID): Chair {
        return list("id", id).first().toChair()
    }

    fun deleteById(id: UUID): Chair {
        val chair = getById(id)

        delete("id", id)

        return chair
    }

    fun getAll(): List<Chair> {
        val resList: MutableList<Chair> = mutableListOf()

        findAll().list().forEach { resList.add(it.toChair()) }

        return resList
    }
}