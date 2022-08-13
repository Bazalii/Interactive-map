package map

import map.controllers.MapController
import map.dto.*
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
    private val _defaultId = UUID.fromString("00000000-0000-0000-0000-000000000000")

    @Test
    fun saveChair_SuccessPath_SaveChairInMapServiceIsCalledAndReturnsCorrespondingChair() {
        // ARRANGE
        val chairRequest = ChairRequest(0.0, 0.0, "Fox", 2, 4)
        val chair = chairRequest.toChair()

        whenever(_mapService.saveChair(chair)).thenReturn(chair)

        // ACT
        _mapController.saveChair(chairRequest)

        // ASSERT
        verify(_mapService, times(1)).saveChair(chair)
    }

    @Test
    fun saveTable_SuccessPath_SaveTableInMapServiceIsCalledAndReturnsCorrespondingTable() {
        // ARRANGE
        val tableRequest = TableRequest(0.0, 0.0, "Fox", 1, 2, "red")
        val table = tableRequest.toTable()

        whenever(_mapService.saveTable(table)).thenReturn(table)

        // ACT
        _mapController.saveTable(tableRequest)

        // ASSERT
        verify(_mapService, times(1)).saveTable(table)
    }

    @Test
    fun saveWall_SuccessPath_SaveWallInMapServiceIsCalled() {
        // ARRANGE
        val wallRequest = WallRequest(0.0, 0.0, "Fox", 4, 5)
        val wall = wallRequest.toWall()

        whenever(_mapService.saveWall(wall)).thenReturn(wall)

        // ACT
        _mapController.saveWall(wallRequest)

        // ASSERT
        verify(_mapService, times(1)).saveWall(wall)
    }

    @Test
    fun deleteChair_SuccessPath_DeleteChairInMapServiceIsCalled() {
        // ARRANGE
        val chairRequest = ChairRequest(0.0, 0.0, "Fox", 2, 4)
        val chair = chairRequest.toChair()

        whenever(_mapService.deleteChairById(_defaultId)).thenReturn(chair)

        // ACT
        _mapController.deleteChair(_defaultId)

        // ASSERT
        verify(_mapService, times(1)).deleteChairById(_defaultId)
    }

    @Test
    fun deleteTable_SuccessPath_DeleteTableInMapServiceIsCalled() {
        // ARRANGE
        val tableRequest = TableRequest(0.0, 0.0, "Fox", 1, 2, "red")
        val table = tableRequest.toTable()

        whenever(_mapService.deleteTableById(_defaultId)).thenReturn(table)

        // ACT
        _mapController.deleteTable(_defaultId)

        // ASSERT
        verify(_mapService, times(1)).deleteTableById(_defaultId)
    }

    @Test
    fun deleteWall_SuccessPath_DeleteWallInMapServiceIsCalled() {
        // ARRANGE
        val wallRequest = WallRequest(0.0, 0.0, "Fox", 4, 5)
        val wall = wallRequest.toWall()

        whenever(_mapService.deleteWallById(_defaultId)).thenReturn(wall)

        // ACT
        _mapController.deleteWall(_defaultId)

        // ASSERT
        verify(_mapService, times(1)).deleteWallById(_defaultId)
    }

    @Test
    fun getChairById_SuccessPath_GetChairByIdInMapServiceIsCalledAndReturnsCorrespondingChair() {
        // ARRANGE
        val chairRequest = ChairRequest(0.0, 0.0, "Fox", 2, 4)

        whenever(_mapService.getChairById(_defaultId)).thenReturn(chairRequest.toChair())

        // ACT
        _mapController.getChair(_defaultId)

        // ASSERT
        verify(_mapService, times(1)).getChairById(_defaultId)
    }

    @Test
    fun getTableById_SuccessPath_GetTableByIdInMapServiceIsCalledAndReturnsCorrespondingTable() {
        // ARRANGE
        val tableRequest = TableRequest(0.0, 0.0, "Fox", 1, 2, "red")

        whenever(_mapService.getTableById(_defaultId)).thenReturn(tableRequest.toTable())

        // ACT
        _mapController.getTable(_defaultId)

        // ASSERT
        verify(_mapService, times(1)).getTableById(_defaultId)
    }

    @Test
    fun getWallById_SuccessPath_GetWallByIdInMapServiceIsCalledAndReturnsCorrespondingWall() {
        // ARRANGE
        val wallRequest = WallRequest(0.0, 0.0, "Fox", 4, 5)

        whenever(_mapService.getWallById(_defaultId)).thenReturn(wallRequest.toWall())

        // ACT
        _mapController.getWall(_defaultId)

        // ASSERT
        verify(_mapService, times(1)).getWallById(_defaultId)
    }

    @Test
    fun getAllChairs_SuccessPath_GetAllChairsInMapServiceIsCalled() {
        // ARRANGE
        val firstChairRequest = ChairRequest(0.0, 0.0, "Fox", 2, 4)
        val secondChairRequest = ChairRequest(0.0, 0.0, "Fox", 5, 10)

        whenever(_mapService.getAllChairs()).thenReturn(listOf(firstChairRequest.toChair(), secondChairRequest.toChair()))

        // ACT
        _mapController.getChairs()

        // ASSERT
        verify(_mapService, times(1)).getAllChairs()
    }

    @Test
    fun getAllTables_SuccessPath_GetAllTablesInMapServiceIsCalled() {
        // ARRANGE
        val firstTableRequest = TableRequest(0.0, 0.0, "Fox", 1, 2, "red")
        val secondTableRequest = TableRequest(0.0, 0.0, "Fox", 5, 10, "red")

        whenever(_mapService.getAllTables()).thenReturn(listOf(firstTableRequest.toTable(), secondTableRequest.toTable()))

        // ACT
        _mapController.getTables()

        // ASSERT
        verify(_mapService, times(1)).getAllTables()
    }

    @Test
    fun getAllWalls_SuccessPath_GetAllWallsInMapServiceIsCalled() {
        // ARRANGE
        val firstWallRequest = WallRequest(0.0, 0.0, "Fox", 4, 5)
        val secondWallRequest = WallRequest(0.0, 0.0, "Fox", 10, 20)

        whenever(_mapService.getAllWalls()).thenReturn(listOf(firstWallRequest.toWall(), secondWallRequest.toWall()))

        // ACT
        _mapController.getWalls()

        // ASSERT
        verify(_mapService, times(1)).getAllWalls()
    }
}