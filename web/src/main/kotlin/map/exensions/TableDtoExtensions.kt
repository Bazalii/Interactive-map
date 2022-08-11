package map.exensions

import map.dto.TableDto
import map.models.Table

fun TableDto.toTable() = Table(
    coordinateX = coordinateX,
    coordinateY = coordinateY,
    id = id,
    creator = creator,
    length = length,
    width = width,
    color = color,
)