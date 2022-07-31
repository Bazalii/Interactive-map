package map

import io.quarkus.test.junit.QuarkusTest
import map.models.Chair
import map.models.Table
import map.models.Wall
import map.repositories.IMapRepository
import map.services.implementations.MapService
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals
import org.mockito.kotlin.*
import java.util.*

@QuarkusTest
class MapServiceTests {
    private val _mapRepository = mock<IMapRepository>()
    private val _mapService = MapService(_mapRepository)

    @Test
    fun saveChair_SuccessPath_SaveChairInMapRepositoryIsCalledAndArgumentsPassedCorrect() {
        // ARRANGE
        val chair = Chair(0.0, 0.0, UUID.randomUUID(), "Fox", 2, 4)

        // ACT
        _mapService.saveChair(chair)

        // ASSERT
        val captor = argumentCaptor<Chair>()
        verify(_mapRepository, times(1)).saveChair(captor.capture())
        assertEquals(captor.firstValue, chair)
    }

    @Test
    fun saveTable_SuccessPath_SaveTableInMapRepositoryIsCalledAndArgumentsPassedCorrect() {
        // ARRANGE
        val table = Table(0.0, 0.0, UUID.randomUUID(), "Fox", 1, 2, "red")

        // ACT
        _mapService.saveTable(table)

        // ASSERT
        val captor = argumentCaptor<Table>()
        verify(_mapRepository, times(1)).saveTable(captor.capture())
        assertEquals(captor.firstValue, table)
    }

    @Test
    fun saveWall_SuccessPath_SaveWallInMapRepositoryIsCalledAndArgumentsPassedCorrect() {
        // ARRANGE
        val wall = Wall(0.0, 0.0, UUID.randomUUID(), "Fox", 4, 5)

        // ACT
        _mapService.saveWall(wall)

        // ASSERT
        val captor = argumentCaptor<Wall>()
        verify(_mapRepository, times(1)).saveWall(captor.capture())
        assertEquals(captor.firstValue, wall)
    }

    @Test
    fun deleteChair_SuccessPath_DeleteChairInMapRepositoryIsCalled() {
        // ARRANGE
        val firstChair = Chair(0.0, 0.0, UUID.randomUUID(), "Fox", 2, 4)
        val secondChair = Chair(0.0, 0.0, UUID.randomUUID(), "Fox", 5, 10)

        // ACT
        _mapService.saveChair(firstChair)
        _mapService.saveChair(secondChair)
        _mapService.deleteChairById(secondChair.id)

        // ASSERT
        verify(_mapRepository, times(0)).deleteChairById(firstChair.id)
        verify(_mapRepository, times(1)).deleteChairById(secondChair.id)
    }

    @Test
    fun deleteTable_SuccessPath_DeleteTableInMapRepositoryIsCalled() {
        // ARRANGE
        val firstTable = Table(0.0, 0.0, UUID.randomUUID(), "Fox", 1, 2, "red")
        val secondTable = Table(0.0, 0.0, UUID.randomUUID(), "Fox", 5, 10, "red")

        // ACT
        _mapService.saveTable(firstTable)
        _mapService.saveTable(secondTable)
        _mapService.deleteTableById(secondTable.id)

        // ASSERT
        verify(_mapRepository, times(0)).deleteTableById(firstTable.id)
        verify(_mapRepository, times(1)).deleteTableById(secondTable.id)
    }

    @Test
    fun deleteWall_SuccessPath_DeleteWallInMapRepositoryIsCalled() {
        // ARRANGE
        val firstWall = Wall(0.0, 0.0, UUID.randomUUID(), "Fox", 4, 5)
        val secondWall = Wall(0.0, 0.0, UUID.randomUUID(), "Fox", 10, 20)

        // ACT
        _mapService.saveWall(firstWall)
        _mapService.saveWall(secondWall)
        _mapService.deleteWallById(secondWall.id)

        // ASSERT
        verify(_mapRepository, times(0)).deleteWallById(firstWall.id)
        verify(_mapRepository, times(1)).deleteWallById(secondWall.id)
    }

    @Test
    fun getChairById_SuccessPath_GetChairByIdInMapRepositoryIsCalledAndReturnsCorrespondingChair() {
        // ARRANGE
        val chair = Chair(0.0, 0.0, UUID.randomUUID(), "Fox", 2, 4)
        whenever(_mapRepository.getChairById(chair.id)).thenReturn(chair)

        // ACT
        val receivedChair = _mapService.getChairById(chair.id)

        // ASSERT
        verify(_mapRepository, times(1)).getChairById(chair.id)
        assertEquals(receivedChair, chair)
    }

    @Test
    fun getTableById_SuccessPath_GetTableByIdInMapRepositoryIsCalledAndReturnsCorrespondingTable() {
        // ARRANGE
        val table = Table(0.0, 0.0, UUID.randomUUID(), "Fox", 1, 2, "red")
        whenever(_mapRepository.getTableById(table.id)).thenReturn(table)

        // ACT
        val receivedTable = _mapService.getTableById(table.id)

        // ASSERT
        verify(_mapRepository, times(1)).getTableById(table.id)
        assertEquals(receivedTable, table)
    }

    @Test
    fun getWallById_SuccessPath_GetWallByIdInMapRepositoryIsCalledAndReturnsCorrespondingWall() {
        // ARRANGE
        val wall = Wall(0.0, 0.0, UUID.randomUUID(), "Fox", 4, 5)
        whenever(_mapRepository.getWallById(wall.id)).thenReturn(wall)

        // ACT
        val receivedWall = _mapService.getWallById(wall.id)

        // ASSERT
        verify(_mapRepository, times(1)).getWallById(wall.id)
        assertEquals(receivedWall, wall)
    }

    @Test
    fun getAllChairs_SuccessPath_GetAllChairsInMapRepositoryIsCalledAndReturnsActualList() {
        // ARRANGE
        val firstChair = Chair(0.0, 0.0, UUID.randomUUID(), "Fox", 2, 4)
        val secondChair = Chair(0.0, 0.0, UUID.randomUUID(), "Fox", 5, 10)
        whenever(_mapRepository.getAllChairs()).thenReturn(listOf(firstChair, secondChair))

        // ACT
        val receivedChairs = _mapService.getAllChairs()

        // ASSERT
        verify(_mapRepository, times(1)).getAllChairs()
        assertEquals(receivedChairs, listOf(firstChair, secondChair))
    }

    @Test
    fun getAllTables_SuccessPath_GetAllTablesInMapRepositoryIsCalledAndReturnsActualList() {
        // ARRANGE
        val firstTable = Table(0.0, 0.0, UUID.randomUUID(), "Fox", 1, 2, "red")
        val secondTable = Table(0.0, 0.0, UUID.randomUUID(), "Fox", 5, 10, "red")
        whenever(_mapRepository.getAllTables()).thenReturn(listOf(firstTable, secondTable))

        // ACT
        val receivedTables = _mapService.getAllTables()

        // ASSERT
        verify(_mapRepository, times(1)).getAllTables()
        assertEquals(receivedTables, listOf(firstTable, secondTable))
    }

    @Test
    fun getAllWalls_SuccessPath_GetAllWallsInMapRepositoryIsCalledAndReturnsActualList() {
        // ARRANGE
        val firstWall = Wall(0.0, 0.0, UUID.randomUUID(), "Fox", 4, 5)
        val secondWall = Wall(0.0, 0.0, UUID.randomUUID(), "Fox", 10, 20)
        whenever(_mapRepository.getAllWalls()).thenReturn(listOf(firstWall, secondWall))

        // ACT
        val receivedWalls = _mapService.getAllWalls()

        // ASSERT
        verify(_mapRepository, times(1)).getAllWalls()
        assertEquals(receivedWalls, listOf(firstWall, secondWall))
    }
}