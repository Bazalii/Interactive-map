package map.exensions

import map.dto.ChairDto
import map.models.Chair

fun Chair.toChairDto() =
    ChairDto(
        coordinateX = coordinateX,
        coordinateY = coordinateY,
        id = id,
        creator = creator,
        height = height,
        legsAmount = legsAmount,
    )