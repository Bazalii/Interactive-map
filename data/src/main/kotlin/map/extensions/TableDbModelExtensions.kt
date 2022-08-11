package map.extensions

import map.models.Table
import map.models.TableDbModel

fun TableDbModel.toTable() = Table(
    coordinateX = coordinateX,
    coordinateY = coordinateY,
    id = id,
    creator = creator,
    length = length,
    width = width,
    color = color,
)