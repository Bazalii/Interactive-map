package map.models

import java.util.*
import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class ChairDbModel(
    var coordinateX: Double = 0.0,
    var coordinateY: Double = 0.0,
    val chairLegsAmount: Int = 0,
    var height: Int = 0,
    val creator: String = "",
    @Id var id: UUID = UUID.randomUUID()
) {

    object ModelMapper {
        fun toChair(chairDbModel: ChairDbModel) =
            Chair(
                chairDbModel.coordinateX,
                chairDbModel.coordinateY,
                chairDbModel.chairLegsAmount,
                chairDbModel.height,
                chairDbModel.creator,
                chairDbModel.id
            )

        fun toChairDbModel(chair: Chair) =
            ChairDbModel(
                chair.coordinateX,
                chair.coordinateY,
                chair.chairLegsAmount,
                chair.height,
                chair.creator,
                chair.id
            )
    }
}