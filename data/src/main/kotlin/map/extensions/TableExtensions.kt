package map.extensions

import map.models.Table
import map.models.TableDbModel

fun Table.toTableDbModel() =
    TableDbModel(
        coordinateX = coordinateX,
        coordinateY = coordinateY,
        id = id,
        creator = creator,
        length = length,
        width = width,
        color = color,
    )