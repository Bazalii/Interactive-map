package map

import map.controllers.MapController
import map.models.Chair
import map.models.Table
import map.models.Wall
import map.services.IMapService
import org.junit.jupiter.api.Assertions
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
    fun saveChair_SuccessPath_SaveChairInMapServiceIsCalled() {
        // ARRANGE
        val chair = Chair(0.0, 0.0, UUID.randomUUID(), "Fox", 2, 4)

        // ACT
        _mapController.saveChair(chair)

        // ASSERT
        verify(_mapService, times(1)).saveChair(chair)
    }

    @Test
    fun saveTable_SuccessPath_SaveTableInMapServiceIsCalled() {
        // ARRANGE
        val table = Table(0.0, 0.0, UUID.randomUUID(), "Fox", 1, 2, "red")

        // ACT
        _mapController.saveTable(table)

        // ASSERT
        verify(_mapService, times(1)).saveTable(table)
    }

    @Test
    fun saveWall_SuccessPath_SaveWallInMapServiceIsCalled() {
        // ARRANGE
        val wall = Wall(0.0, 0.0, UUID.randomUUID(), "Fox", 4, 5)

        // ACT
        _mapController.saveWall(wall)

        // ASSERT
        verify(_mapService, times(1)).saveWall(wall)
    }

    @Test
    fun deleteChair_SuccessPath_DeleteChairInMapServiceIsCalled() {
        // ARRANGE
        val firstChair = Chair(0.0, 0.0, UUID.randomUUID(), "Fox", 2, 4)
        val secondChair = Chair(0.0, 0.0, UUID.randomUUID(), "Fox", 5, 10)

        // ACT
        _mapController.saveChair(firstChair)
        _mapController.saveChair(secondChair)
        _mapController.deleteChair(secondChair.id)

        // ASSERT
        verify(_mapService, times(0)).deleteChairById(firstChair.id)
        verify(_mapService, times(1)).deleteChairById(secondChair.id)
    }

    @Test
    fun deleteTable_SuccessPath_DeleteTableInMapServiceIsCalled() {
        // ARRANGE
        val firstTable = Table(0.0, 0.0, UUID.randomUUID(), "Fox", 1, 2, "red")
        val secondTable = Table(0.0, 0.0, UUID.randomUUID(), "Fox", 5, 10, "red")

        // ACT
        _mapController.saveTable(firstTable)
        _mapController.saveTable(secondTable)
        _mapController.deleteTable(secondTable.id)

        // ASSERT
        verify(_mapService, times(0)).deleteTableById(firstTable.id)
        verify(_mapService, times(1)).deleteTableById(secondTable.id)
    }

    @Test
    fun deleteWall_SuccessPath_DeleteWallInMapServiceIsCalled() {
        // ARRANGE
        val firstWall = Wall(0.0, 0.0, UUID.randomUUID(), "Fox", 4, 5)
        val secondWall = Wall(0.0, 0.0, UUID.randomUUID(), "Fox", 10, 20)

        // ACT
        _mapController.saveWall(firstWall)
        _mapController.saveWall(secondWall)
        _mapController.deleteWall(secondWall.id)

        // ASSERT
        verify(_mapService, times(0)).deleteWallById(firstWall.id)
        verify(_mapService, times(1)).deleteWallById(secondWall.id)
    }

    @Test
    fun getChairById_SuccessPath_GetChairByIdInMapServiceIsCalledAndReturnsCorrespondingChair() {
        // ARRANGE
        val chair = Chair(0.0, 0.0, UUID.randomUUID(), "Fox", 2, 4)
        whenever(_mapService.getChairById(chair.id)).thenReturn(chair)

        // ACT
        val receivedChair = _mapController.getChair(chair.id)

        // ASSERT
        verify(_mapService, times(1)).getChairById(chair.id)
        Assertions.assertEquals(receivedChair, chair)
    }

    @Test
    fun getTableById_SuccessPath_GetTableByIdInMapServiceIsCalledAndReturnsCorrespondingTable() {
        // ARRANGE
        val table = Table(0.0, 0.0, UUID.randomUUID(), "Fox", 1, 2, "red")
        whenever(_mapService.getTableById(table.id)).thenReturn(table)

        // ACT
        val receivedTable = _mapController.getTable(table.id)

        // ASSERT
        verify(_mapService, times(1)).getTableById(table.id)
        Assertions.assertEquals(receivedTable, table)
    }

    @Test
    fun getWallById_SuccessPath_GetWallByIdInMapServiceIsCalledAndReturnsCorrespondingWall() {
        // ARRANGE
        val wall = Wall(0.0, 0.0, UUID.randomUUID(), "Fox", 4, 5)
        whenever(_mapService.getWallById(wall.id)).thenReturn(wall)

        // ACT
        val receivedWall = _mapController.getWall(wall.id)

        // ASSERT
        verify(_mapService, times(1)).getWallById(wall.id)
        Assertions.assertEquals(receivedWall, wall)
    }

    @Test
    fun getAllChairs_SuccessPath_GetAllChairsInMapServiceIsCalledAndReturnsActualList() {
        // ARRANGE
        val firstChair = Chair(0.0, 0.0, UUID.randomUUID(), "Fox", 2, 4)
        val secondChair = Chair(0.0, 0.0, UUID.randomUUID(), "Fox", 5, 10)
        whenever(_mapService.getAllChairs()).thenReturn(listOf(firstChair, secondChair))

        // ACT
        val receivedChairs = _mapController.getChairs()

        // ASSERT
        verify(_mapService, times(1)).getAllChairs()
        Assertions.assertEquals(receivedChairs, listOf(firstChair, secondChair))
    }

    @Test
    fun getAllTables_SuccessPath_GetAllTablesInMapServiceIsCalledAndReturnsActualList() {
        // ARRANGE
        val firstTable = Table(0.0, 0.0, UUID.randomUUID(), "Fox", 1, 2, "red")
        val secondTable = Table(0.0, 0.0, UUID.randomUUID(), "Fox", 5, 10, "red")
        whenever(_mapService.getAllTables()).thenReturn(listOf(firstTable, secondTable))

        // ACT
        val receivedTables = _mapController.getTables()

        // ASSERT
        verify(_mapService, times(1)).getAllTables()
        Assertions.assertEquals(receivedTables, listOf(firstTable, secondTable))
    }

    @Test
    fun getAllWalls_SuccessPath_GetAllWallsInMapServiceIsCalledAndReturnsActualList() {
        // ARRANGE
        val firstWall = Wall(0.0, 0.0, UUID.randomUUID(), "Fox", 4, 5)
        val secondWall = Wall(0.0, 0.0, UUID.randomUUID(), "Fox", 10, 20)
        whenever(_mapService.getAllWalls()).thenReturn(listOf(firstWall, secondWall))

        // ACT
        val receivedWalls = _mapController.getWalls()

        // ASSERT
        verify(_mapService, times(1)).getAllWalls()
        Assertions.assertEquals(receivedWalls, listOf(firstWall, secondWall))
    }
}