package map.exensions

import map.dto.WallRequest
import map.models.Wall

fun WallRequest.toWall() =
    Wall(
        coordinateX = coordinateX,
        coordinateY = coordinateY,
        creator = creator,
        length = length,
        width = width,
    )