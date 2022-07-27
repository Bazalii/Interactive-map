package map.models

import java.util.*
import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class WallDbModel(
    val coordinateX: Double = 0.0,
    val coordinateY: Double = 0.0,
    @Id val id: UUID = UUID.randomUUID(),
    val creator: String = "",
    val length: Int = 0,
    val width: Int = 0,

) {

    object ModelMapper {
        fun toWall(wallDbModel: WallDbModel) =
            Wall(
                wallDbModel.coordinateX,
                wallDbModel.coordinateY,
                wallDbModel.id,
                wallDbModel.creator,
                wallDbModel.length,
                wallDbModel.width,
            )

        fun toWallDbModel(wall: Wall) =
            WallDbModel(
                wall.coordinateX,
                wall.coordinateY,
                wall.id,
                wall.creator,
                wall.length,
                wall.width,
            )
    }
}