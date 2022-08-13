package map.controllers

import map.dto.*
import map.exensions.*
import map.services.IMapService
import org.eclipse.microprofile.graphql.GraphQLApi
import org.eclipse.microprofile.graphql.Mutation
import org.eclipse.microprofile.graphql.Query
import java.util.*
import javax.enterprise.context.RequestScoped

@GraphQLApi
@RequestScoped
class MapController(private val _mapService: IMapService) {
    @Mutation
    fun saveTable(tableRequest: TableRequest): TableResponse {
        return _mapService.saveTable(tableRequest.toTable()).toTableResponse()
    }

    @Mutation
    fun saveChair(chairRequest: ChairRequest): ChairResponse {
        return _mapService.saveChair(chairRequest.toChair()).toChairResponse()
    }

    @Mutation
    fun saveWall(wallRequest: WallRequest): WallResponse {
        return _mapService.saveWall(wallRequest.toWall()).toWallResponse()
    }

    @Mutation
    fun deleteTable(id: UUID): TableResponse {
        return _mapService.deleteTableById(id).toTableResponse()
    }

    @Mutation
    fun deleteChair(id: UUID): ChairResponse {
        return _mapService.deleteChairById(id).toChairResponse()
    }

    @Mutation
    fun deleteWall(id: UUID): WallResponse {
        return _mapService.deleteWallById(id).toWallResponse()
    }

    @Query
    fun getTable(id: UUID): TableResponse {
        return _mapService.getTableById(id).toTableResponse()
    }

    @Query
    fun getChair(id: UUID): ChairResponse {
        return _mapService.getChairById(id).toChairResponse()
    }

    @Query
    fun getWall(id: UUID): WallResponse {
        return _mapService.getWallById(id).toWallResponse()
    }

    @Query
    fun getTables(): List<TableResponse> {
        val tables = _mapService.getAllTables()
        val tablesDto = mutableListOf<TableResponse>()

        for (table in tables){
            tablesDto.add(table.toTableResponse())
        }

        return tablesDto
    }

    @Query
    fun getChairs(): List<ChairResponse> {
        val chairs = _mapService.getAllChairs()
        val chairsDto = mutableListOf<ChairResponse>()

        for (chair in chairs){
            chairsDto.add(chair.toChairResponse())
        }

        return chairsDto
    }

    @Query
    fun getWalls(): List<WallResponse> {
        val walls = _mapService.getAllWalls()
        val wallsDto = mutableListOf<WallResponse>()

        for (wall in walls){
            wallsDto.add(wall.toWallResponse())
        }

        return wallsDto
    }
}