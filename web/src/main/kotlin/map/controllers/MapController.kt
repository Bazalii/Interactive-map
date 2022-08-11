package map.controllers

import map.dto.ChairDto
import map.dto.TableDto
import map.dto.WallDto
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
    fun saveTable(tableDto: TableDto): TableDto {
        return _mapService.saveTable(tableDto.toTable()).toTableDto()
    }

    @Mutation
    fun saveChair(chairDto: ChairDto): ChairDto {
        return _mapService.saveChair(chairDto.toChair()).toChairDto()
    }

    @Mutation
    fun saveWall(wallDto: WallDto): WallDto {
        return _mapService.saveWall(wallDto.toWall()).toWallDto()
    }

    @Mutation
    fun deleteTable(id: UUID): TableDto {
        return _mapService.deleteTableById(id).toTableDto()
    }

    @Mutation
    fun deleteChair(id: UUID): ChairDto {
        return _mapService.deleteChairById(id).toChairDto()
    }

    @Mutation
    fun deleteWall(id: UUID): WallDto {
        return _mapService.deleteWallById(id).toWallDto()
    }

    @Query
    fun getTable(id: UUID): TableDto {
        return _mapService.getTableById(id).toTableDto()
    }

    @Query
    fun getChair(id: UUID): ChairDto {
        return _mapService.getChairById(id).toChairDto()
    }

    @Query
    fun getWall(id: UUID): WallDto {
        return _mapService.getWallById(id).toWallDto()
    }

    @Query
    fun getTables(): List<TableDto> {
        val tables = _mapService.getAllTables()
        val tablesDto = mutableListOf<TableDto>()

        for (table in tables){
            tablesDto.add(table.toTableDto())
        }

        return tablesDto
    }

    @Query
    fun getChairs(): List<ChairDto> {
        val chairs = _mapService.getAllChairs()
        val chairsDto = mutableListOf<ChairDto>()

        for (chair in chairs){
            chairsDto.add(chair.toChairDto())
        }

        return chairsDto
    }

    @Query
    fun getWalls(): List<WallDto> {
        val walls = _mapService.getAllWalls()
        val wallsDto = mutableListOf<WallDto>()

        for (wall in walls){
            wallsDto.add(wall.toWallDto())
        }

        return wallsDto
    }
}