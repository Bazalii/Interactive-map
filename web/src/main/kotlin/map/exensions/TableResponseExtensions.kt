package map.exensions

import map.dto.TableResponse
import map.models.Table

fun Table.toTableResponse() =
    TableResponse(
        coordinateX = coordinateX,
        coordinateY = coordinateY,
        id = id,
        creator = creator,
        length = length,
        width = width,
        color = color,
    )