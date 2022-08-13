package map.exensions

import map.dto.ChairRequest
import map.models.Chair

fun ChairRequest.toChair() =
    Chair(
        coordinateX = coordinateX,
        coordinateY = coordinateY,
        creator = creator,
        height = height,
        legsAmount = legsAmount,
    )