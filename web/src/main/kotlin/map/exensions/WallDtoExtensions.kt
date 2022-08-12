package map.exensions

import map.dto.WallDto
import map.models.Wall

fun WallDto.toWall() =
    Wall(
        coordinateX = coordinateX,
        coordinateY = coordinateY,
        id = id,
        creator = creator,
        length = length,
        width = width,
    )