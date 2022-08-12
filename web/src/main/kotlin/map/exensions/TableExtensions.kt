package map.exensions

import map.dto.TableDto
import map.models.Table

fun Table.toTableDto() =
    TableDto(
        coordinateX = coordinateX,
        coordinateY = coordinateY,
        id = id,
        creator = creator,
        length = length,
        width = width,
        color = color,
    )