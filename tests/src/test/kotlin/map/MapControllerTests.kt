package map

import map.controllers.MapController
import map.dto.ChairDto
import map.dto.TableDto
import map.dto.WallDto
import map.exensions.toChair
import map.exensions.toTable
import map.exensions.toWall
import map.services.IMapService
import org.junit.jupiter.api.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.times
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever
import java.util.*

class MapControllerTests {
    private val _mapService = mock<IMapService>()
    private val _mapController = MapController(_mapService)

    @Test
    fun saveChair_SuccessPath_SaveChairInMapServiceIsCalledAndReturnsCorrespondingChair() {
        // ARRANGE
        val chairDto = ChairDto(0.0, 0.0, "Fox", 2, 4)
        val chair = chairDto.toChair()
        whenever(_mapService.saveChair(chair)).thenReturn(chair)

        // ACT
        _mapController.saveChair(chairDto)

        // ASSERT
        verify(_mapService, times(1)).saveChair(chair)
    }

    @Test
    fun saveTable_SuccessPath_SaveTableInMapServiceIsCalledAndReturnsCorrespondingTable() {
        // ARRANGE
        val tableDto = TableDto(0.0, 0.0, UUID.randomUUID(), "Fox", 1, 2, "red")
        val table = tableDto.toTable()
        whenever(_mapService.saveTable(table)).thenReturn(table)

        // ACT
        _mapController.saveTable(tableDto)

        // ASSERT
        verify(_mapService, times(1)).saveTable(table)
    }

    @Test
    fun saveWall_SuccessPath_SaveWallInMapServiceIsCalled() {
        // ARRANGE
        val wallDto = WallDto(0.0, 0.0, UUID.randomUUID(), "Fox", 4, 5)
        val wall = wallDto.toWall()
        whenever(_mapService.saveWall(wall)).thenReturn(wall)

        // ACT
        _mapController.saveWall(wallDto)

        // ASSERT
        verify(_mapService, times(1)).saveWall(wall)
    }

    @Test
    fun deleteChair_SuccessPath_DeleteChairInMapServiceIsCalled() {
        // ARRANGE
        val firstChairDto = ChairDto(0.0, 0.0, UUID.randomUUID(), "Fox", 2, 4)
        val secondChairDto = ChairDto(0.0, 0.0, UUID.randomUUID(), "Fox", 5, 10)
        val firstChair = firstChairDto.toChair()
        val secondChair = secondChairDto.toChair()
        whenever(_mapService.saveChair(firstChair)).thenReturn(firstChair)
        whenever(_mapService.saveChair(secondChair)).thenReturn(secondChair)
        whenever(_mapService.deleteChairById(secondChair.id)).thenReturn(secondChair)


        // ACT
        _mapController.saveChair(firstChairDto)
        _mapController.saveChair(secondChairDto)
        _mapController.deleteChair(secondChairDto.id)

        // ASSERT
        verify(_mapService, times(0)).deleteChairById(firstChairDto.id)
        verify(_mapService, times(1)).deleteChairById(secondChairDto.id)
    }

    @Test
    fun deleteTable_SuccessPath_DeleteTableInMapServiceIsCalled() {
        // ARRANGE
        val firstTableDto = TableDto(0.0, 0.0, UUID.randomUUID(), "Fox", 1, 2, "red")
        val secondTableDto = TableDto(0.0, 0.0, UUID.randomUUID(), "Fox", 5, 10, "red")
        val firstTable = firstTableDto.toTable()
        val secondTable = secondTableDto.toTable()
        whenever(_mapService.saveTable(firstTable)).thenReturn(firstTable)
        whenever(_mapService.saveTable(secondTable)).thenReturn(secondTable)
        whenever(_mapService.deleteTableById(secondTable.id)).thenReturn(secondTable)

        // ACT
        _mapController.saveTable(firstTableDto)
        _mapController.saveTable(secondTableDto)
        _mapController.deleteTable(secondTableDto.id)

        // ASSERT
        verify(_mapService, times(0)).deleteTableById(firstTableDto.id)
        verify(_mapService, times(1)).deleteTableById(secondTableDto.id)
    }

    @Test
    fun deleteWall_SuccessPath_DeleteWallInMapServiceIsCalled() {
        // ARRANGE
        val firstWallDto = WallDto(0.0, 0.0, UUID.randomUUID(), "Fox", 4, 5)
        val secondWallDto = WallDto(0.0, 0.0, UUID.randomUUID(), "Fox", 10, 20)
        val firstWall = firstWallDto.toWall()
        val secondWall = secondWallDto.toWall()
        whenever(_mapService.saveWall(firstWall)).thenReturn(firstWall)
        whenever(_mapService.saveWall(secondWall)).thenReturn(secondWall)
        whenever(_mapService.deleteWallById(secondWall.id)).thenReturn(secondWall)


        // ACT
        _mapController.saveWall(firstWallDto)
        _mapController.saveWall(secondWallDto)
        _mapController.deleteWall(secondWallDto.id)

        // ASSERT
        verify(_mapService, times(0)).deleteWallById(firstWallDto.id)
        verify(_mapService, times(1)).deleteWallById(secondWallDto.id)
    }

    @Test
    fun getChairById_SuccessPath_GetChairByIdInMapServiceIsCalledAndReturnsCorrespondingChair() {
        // ARRANGE
        val chairDto = ChairDto(0.0, 0.0, UUID.randomUUID(), "Fox", 2, 4)
        whenever(_mapService.getChairById(chairDto.id)).thenReturn(chairDto.toChair())

        // ACT
        _mapController.getChair(chairDto.id)

        // ASSERT
        verify(_mapService, times(1)).getChairById(chairDto.id)
    }

    @Test
    fun getTableById_SuccessPath_GetTableByIdInMapServiceIsCalledAndReturnsCorrespondingTable() {
        // ARRANGE
        val tableDto = TableDto(0.0, 0.0, UUID.randomUUID(), "Fox", 1, 2, "red")
        whenever(_mapService.getTableById(tableDto.id)).thenReturn(tableDto.toTable())

        // ACT
        _mapController.getTable(tableDto.id)

        // ASSERT
        verify(_mapService, times(1)).getTableById(tableDto.id)
    }

    @Test
    fun getWallById_SuccessPath_GetWallByIdInMapServiceIsCalledAndReturnsCorrespondingWall() {
        // ARRANGE
        val wallDto = WallDto(0.0, 0.0, UUID.randomUUID(), "Fox", 4, 5)
        whenever(_mapService.getWallById(wallDto.id)).thenReturn(wallDto.toWall())

        // ACT
        _mapController.getWall(wallDto.id)

        // ASSERT
        verify(_mapService, times(1)).getWallById(wallDto.id)
    }

    @Test
    fun getAllChairs_SuccessPath_GetAllChairsInMapServiceIsCalled() {
        // ARRANGE
        val firstChairDto = ChairDto(0.0, 0.0, UUID.randomUUID(), "Fox", 2, 4)
        val secondChairDto = ChairDto(0.0, 0.0, UUID.randomUUID(), "Fox", 5, 10)
        whenever(_mapService.getAllChairs()).thenReturn(listOf(firstChairDto.toChair(), secondChairDto.toChair()))

        // ACT
        _mapController.getChairs()

        // ASSERT
        verify(_mapService, times(1)).getAllChairs()
    }

    @Test
    fun getAllTables_SuccessPath_GetAllTablesInMapServiceIsCalled() {
        // ARRANGE
        val firstTableDto = TableDto(0.0, 0.0, UUID.randomUUID(), "Fox", 1, 2, "red")
        val secondTableDto = TableDto(0.0, 0.0, UUID.randomUUID(), "Fox", 5, 10, "red")
        whenever(_mapService.getAllTables()).thenReturn(listOf(firstTableDto.toTable(), secondTableDto.toTable()))

        // ACT
        _mapController.getTables()

        // ASSERT
        verify(_mapService, times(1)).getAllTables()
    }

    @Test
    fun getAllWalls_SuccessPath_GetAllWallsInMapServiceIsCalled() {
        // ARRANGE
        val firstWallDto = WallDto(0.0, 0.0, UUID.randomUUID(), "Fox", 4, 5)
        val secondWallDto = WallDto(0.0, 0.0, UUID.randomUUID(), "Fox", 10, 20)
        whenever(_mapService.getAllWalls()).thenReturn(listOf(firstWallDto.toWall(), secondWallDto.toWall()))

        // ACT
        _mapController.getWalls()

        // ASSERT
        verify(_mapService, times(1)).getAllWalls()
    }
}