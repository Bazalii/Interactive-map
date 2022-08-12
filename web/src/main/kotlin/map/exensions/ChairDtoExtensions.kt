package map.exensions

import map.dto.ChairDto
import map.models.Chair

fun ChairDto.toChair() =
    Chair(
        coordinateX = coordinateX,
        coordinateY = coordinateY,
        id = id,
        creator = creator,
        height = height,
        legsAmount = legsAmount,
    )