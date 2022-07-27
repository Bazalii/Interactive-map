package map.models

import java.util.*
import javax.persistence.Entity
import javax.persistence.Id

@Entity
class WallDbModel(
    val length: Int = 0,
    val width: Int = 0,
    val creator: String = "",
    val coordinateX: Double = 0.0,
    val coordinateY: Double = 0.0,
    @Id val id: UUID = UUID.randomUUID()
) {

    object ModelMapper {
        fun toWall(wallDbModel: WallDbModel) =
            Wall(
                wallDbModel.length,
                wallDbModel.width,
                wallDbModel.creator,
                wallDbModel.coordinateX,
                wallDbModel.coordinateY,
                wallDbModel.id
            )

        fun toWallDbModel(wall: Wall) =
            WallDbModel(
                wall.length,
                wall.width,
                wall.creator,
                wall.coordinateX,
                wall.coordinateY,
                wall.id
            )
    }
}