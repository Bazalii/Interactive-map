package map.models

import java.util.*
import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class ChairDbModel(
    var coordinateX: Double = 0.0,
    var coordinateY: Double = 0.0,
    @Id var id: UUID = UUID.randomUUID(),
    val creator: String = "",
    var height: Int = 0,
    val legsAmount: Int = 0,
) {

    object ModelMapper {
        fun toChair(chairDbModel: ChairDbModel) =
            Chair(
                chairDbModel.coordinateX,
                chairDbModel.coordinateY,
                chairDbModel.id,
                chairDbModel.creator,
                chairDbModel.height,
                chairDbModel.legsAmount,
            )

        fun toChairDbModel(chair: Chair) =
            ChairDbModel(
                chair.coordinateX,
                chair.coordinateY,
                chair.id,
                chair.creator,
                chair.height,
                chair.legsAmount,
            )
    }
}