package map.exensions

import map.dto.WallResponse
import map.models.Wall

fun Wall.toWallResponse() =
    WallResponse(
        coordinateX = coordinateX,
        coordinateY = coordinateY,
        id = id,
        creator = creator,
        length = length,
        width = width,
    )