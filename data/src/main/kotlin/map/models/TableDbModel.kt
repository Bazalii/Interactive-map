package map.models

import java.util.*
import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class TableDbModel(
    val coordinateX: Double = 0.0,
    val coordinateY: Double = 0.0,
    @Id val id: UUID = UUID.randomUUID(),
    val creator: String = "",
    val length: Int = 0,
    val width: Int = 0,
    val color: String = "",
) {
    object ModelMapper {
        fun toTable(tableDbModel: TableDbModel) =
            Table(
                tableDbModel.coordinateX,
                tableDbModel.coordinateY,
                tableDbModel.id,
                tableDbModel.creator,
                tableDbModel.length,
                tableDbModel.width,
                tableDbModel.color,

            )

        fun toTableDbModel(table: Table) =
            TableDbModel(
                table.coordinateX,
                table.coordinateY,
                table.id,
                table.creator,
                table.length,
                table.width,
                table.color,

            )
    }
}