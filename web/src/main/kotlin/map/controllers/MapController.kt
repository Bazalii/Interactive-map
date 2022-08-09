package map.controllers

import map.models.Chair
import map.models.Table
import map.models.Wall
import map.services.IMapService
import org.eclipse.microprofile.graphql.GraphQLApi
import org.eclipse.microprofile.graphql.Mutation
import org.eclipse.microprofile.graphql.Query
import java.util.UUID

@GraphQLApi
class MapController(private val _mapService: IMapService) {
    @Mutation
    fun saveTable(table: Table) : Table {
        return _mapService.saveTable(table)
    }

    @Mutation
    fun saveChair(chair: Chair): Chair {
        return _mapService.saveChair(chair)
    }

    @Mutation
    fun saveWall(wall: Wall): Wall {
        return _mapService.saveWall(wall)
    }

    @Mutation
    fun deleteTable(id: UUID): Table {
        return _mapService.deleteTableById(id)
    }

    @Mutation
    fun deleteChair(id: UUID): Chair {
        return _mapService.deleteChairById(id)
    }

    @Mutation
    fun deleteWall(id: UUID): Wall {
        return _mapService.deleteWallById(id)
    }

    @Query
    fun getTable(id: UUID): Table {
        return _mapService.getTableById(id)
    }

    @Query
    fun getChair(id: UUID): Chair {
        return _mapService.getChairById(id)
    }

    @Query
    fun getWall(id: UUID): Wall {
        return _mapService.getWallById(id)
    }

    @Query
    fun getTables() : List<Table> {
        return _mapService.getAllTables()
    }

    @Query
    fun getChairs() : List<Chair> {
        return _mapService.getAllChairs()
    }

    @Query
    fun getWalls() : List<Wall> {
        return _mapService.getAllWalls()
    }
}