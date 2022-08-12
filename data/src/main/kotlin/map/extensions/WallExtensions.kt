package map.extensions

import map.models.Wall
import map.models.WallDbModel

fun Wall.toWallDbModel() =
    WallDbModel(
        coordinateX = coordinateX,
        coordinateY = coordinateY,
        id = id,
        creator = creator,
        length = length,
        width = width,
    )