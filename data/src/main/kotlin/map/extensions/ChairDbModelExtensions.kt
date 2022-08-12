package map.extensions

import map.models.Chair
import map.models.ChairDbModel

fun ChairDbModel.toChair() =
    Chair(
        coordinateX = coordinateX,
        coordinateY = coordinateY,
        id = id,
        creator = creator,
        height = height,
        legsAmount = legsAmount,
    )
