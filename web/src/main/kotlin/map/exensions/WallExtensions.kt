package map.exensions

import map.dto.WallDto
import map.models.Wall

fun Wall.toWallDto() = WallDto(
    coordinateX = coordinateX,
    coordinateY = coordinateY,
    id = id,
    creator = creator,
    length = length,
    width = width,
)