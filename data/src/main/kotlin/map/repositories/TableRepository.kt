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

    fun getById(tableId: UUID): Table {
        return list("id", tableId).first().toTable()
    }

    fun deleteById(tableId: UUID) {
        delete("id", getById(tableId))
    }

    fun getAll(): List<Table> {
        val tableList: MutableList<Table> = mutableListOf()

        findAll().list().forEach { tableList.add(it.toTable()) }

        return tableList
    }
}