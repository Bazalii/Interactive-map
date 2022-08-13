package map.exensions

import map.dto.TableRequest
import map.models.Table

fun TableRequest.toTable() =
    Table(
        coordinateX = coordinateX,
        coordinateY = coordinateY,
        creator = creator,
        length = length,
        width = width,
        color = color,
    )