package map.repositories

import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepository
import map.extensions.toTable
import map.extensions.toTableDbModel
import map.models.Table
import map.models.TableDbModel
import java.util.*
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class TableRepository : PanacheRepository<TableDbModel> {
    fun save(table: Table) {
        persist(table.toTableDbModel())
    }

    fun getById(id: UUID): Table {
        return list("id", id).first().toTable()
    }

    fun deleteById(id: UUID) {
        delete("id", getById(id))
    }

    fun getAll(): List<Table> {
        val tableList: MutableList<Table> = mutableListOf()

        findAll().list().forEach { tableList.add(it.toTable()) }

        return tableList
    }
}