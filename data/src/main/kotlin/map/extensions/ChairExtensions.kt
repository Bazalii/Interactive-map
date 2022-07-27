package map.extensions

import map.models.Chair
import map.models.ChairDbModel

fun Chair.toChairDbModel() =
    ChairDbModel(
        coordinateX = coordinateX,
        coordinateY = coordinateY,
        id = id,
        creator = creator,
        height = height,
        legsAmount = legsAmount,
    )