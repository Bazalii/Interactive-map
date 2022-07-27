package map.models

import java.util.*
import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class TableDbModel(
    val length: Int = 0,
    val width: Int = 0,
    val creator: String = "",
    val color: String = "",
    val coordinateX: Double = 0.0,
    val coordinateY: Double = 0.0,
    @Id val id: UUID = UUID.randomUUID()

) {
    object ModelMapper {
        fun toTable(tableDbModel: TableDbModel) =
            Table(
                tableDbModel.length,
                tableDbModel.width,
                tableDbModel.creator,
                tableDbModel.color,
                tableDbModel.coordinateX,
                tableDbModel.coordinateY,
                tableDbModel.id
            )

        fun toTableDbModel(table: Table) =
            TableDbModel(
                table.length,
                table.width,
                table.creator,
                table.color,
                table.coordinateX,
                table.coordinateY,
                table.id
            )
    }
}