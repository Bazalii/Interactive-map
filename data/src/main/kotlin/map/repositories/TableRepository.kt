package map.repositories

import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepository
import map.models.Table
import map.models.TableDbModel
import java.util.*

class TableRepository : PanacheRepository<TableDbModel> {
    fun saveTable(table: Table) {
        persist(TableDbModel.ModelMapper.toTableDbModel(table))
    }

    fun getAllTables(): List<Table> {
        val list = findAll().list()
        val tableList: MutableList<Table> = mutableListOf()
        for (model in list) {
            tableList.add(TableDbModel.ModelMapper.toTable(model))
        }
        return tableList
    }

    fun getTableById(tableId: UUID): Table {
        return TableDbModel.ModelMapper.toTable(list("id", tableId).first())
    }

    fun deleteTableById(tableId: UUID) {
        delete("id", getTableById(tableId))
    }


}