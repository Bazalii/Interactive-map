package map.exensions

import map.dto.ChairResponse
import map.models.Chair

fun Chair.toChairResponse() =
    ChairResponse(
        coordinateX = coordinateX,
        coordinateY = coordinateY,
        id = id,
        creator = creator,
        height = height,
        legsAmount = legsAmount,
    )