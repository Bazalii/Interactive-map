package map

import io.quarkus.test.junit.QuarkusTest
import map.models.Chair
import map.models.Table
import map.models.Wall
import map.repositories.ChairRepository
import map.repositories.MapRepository
import map.repositories.TableRepository
import map.repositories.WallRepository
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.kotlin.*
import java.util.*

@QuarkusTest
class MapRepositoryTests {
    private val chairRepository: ChairRepository = mock()
    private val tableRepository: TableRepository = mock()
    private val wallRepository: WallRepository = mock()
    private val mapRepository = MapRepository(chairRepository, wallRepository, tableRepository)

    @Test
    fun saveChair_SuccessPath_SaveInPanacheRepositoryIsCalled() {
        // ARRANGE
        val firstChair = Chair(0.0, 0.0, UUID.randomUUID(), "tima", 1, 2)

        // ACT
        mapRepository.saveChair(firstChair)

        // ASSERT
        verify(chairRepository, times(1)).save(firstChair)
    }


    @Test
    fun saveTable_SavingTwoTables_SuccessPath_SaveInPanacheRepositoryIsCalledTwoTimes() {
        // ARRANGE
        val firstTable = Table(0.0, 0.0, UUID.randomUUID(), "tima", 1, 2, "red")
        val secondTable = Table(1.0, 2.0, UUID.randomUUID(), "tima", 2, 3, "red")

        // ACT
        mapRepository.saveTable(firstTable)
        mapRepository.saveTable(secondTable)

        // ASSERT
        verify(tableRepository, times(1)).save(firstTable)
        verify(tableRepository, times(1)).save(secondTable)
    }

    @Test
    fun saveWall_SaveThreeWalls_SuccessPath_SaveInPanacheRepositoryIsCalledThreeTimes() {
        // ARRANGE
        val firstWall = Wall(0.0, 0.0, UUID.randomUUID(), "tima", 1, 2)
        val secondWall = Wall(1.0, 2.0, UUID.randomUUID(), "tima", 2, 3)
        val thirdWall = Wall(2.0, 2.0, UUID.randomUUID(), "tima", 2, 3)

        // ACT
        mapRepository.saveWall(firstWall)
        mapRepository.saveWall(secondWall)
        mapRepository.saveWall(thirdWall)

        // ASSERT
        verify(wallRepository, times(1)).save(firstWall)
        verify(wallRepository, times(1)).save(secondWall)
        verify(wallRepository, times(1)).save(thirdWall)
    }

    @Test
    fun deleteChair_SuccessPath_DeleteInPanacheRepositoryIsCalled() {
        // ARRANGE
        val chair = Chair(0.0, 0.0, UUID.randomUUID(), "tima", 1, 2)

        // ACT
        mapRepository.saveChair(chair)
        mapRepository.deleteChairById(chair.id)

        // ASSERT
        verify(chairRepository, times(1)).deleteById(chair.id)
    }

    @Test
    fun deleteTable_SuccessPath_DeleteInPanacheRepositoryIsCalled()  {
        // ARRANGE
        val table = Table(0.0, 0.0, UUID.randomUUID(), "tima", 1, 2, "red")

        // ACT
        mapRepository.saveTable(table)
        mapRepository.deleteTableById(table.id)

        // ASSERT
        verify(tableRepository, times(1)).deleteById(table.id)
    }

    @Test
    fun deleteWall_SuccessPath_DeleteInPanacheRepositoryIsCalled() {
        // ARRANGE
        val wall = Wall(0.0, 0.0, UUID.randomUUID(), "tima", 1, 2)

        // ACT
        mapRepository.saveWall(wall)
        mapRepository.deleteWallById(wall.id)

        // ASSERT
        verify(wallRepository, times(1)).deleteById(wall.id)
    }

    @Test
    fun getChairById_SuccessPath_ReturnsCorrespondingChair() {
        // ARRANGE
        val chair = Chair(0.0, 0.0, UUID.randomUUID(), "tima", 1, 2)

        // ACT
        whenever(chairRepository.getById(chair.id)).thenReturn(chair)

        // ASSERT
        Assertions.assertEquals(mapRepository.getChairById(chair.id), chair)
    }

    @Test
    fun getTableById_SuccessPath_ReturnsCorrespondingTable() {
        // ARRANGE
        val table = Table(0.0, 0.0, UUID.randomUUID(), "tima", 1, 2, "red")

        // ACT
        whenever(tableRepository.getById(table.id)).thenReturn(table)

        // ASSERT
        Assertions.assertEquals(mapRepository.getTableById(table.id), table)
    }

    @Test
    fun getWallById_SuccessPath_ReturnsCorrespondingTable() {
        // ARRANGE
        val wall = Wall(0.0, 0.0, UUID.randomUUID(), "tima", 1, 2)

        // ACT
        whenever(wallRepository.getById(wall.id)).thenReturn(wall)

        // ASSERT
        Assertions.assertEquals(mapRepository.getWallById(wall.id), wall)
    }


    @Test
    fun getAllChairsListCount_SuccessPath_ReturnsActualList() {
        // ARRANGE
        val chair = Chair(0.0, 0.0, UUID.randomUUID(), "tima", 1, 2)

        // ACT
        whenever(chairRepository.getAll()).thenReturn(listOf(chair))

        // ASSERT
        Assertions.assertEquals(mapRepository.getAllChairs(), listOf(chair))
    }

    @Test
    fun getAllTables_SuccessPath_ReturnsActualList() {
        // ARRANGE
        val table = Table(0.0, 0.0, UUID.randomUUID(), "tima", 1, 2, "red")

        // ACT
        whenever(tableRepository.getAll()).thenReturn(listOf(table))

        // ASSERT
        Assertions.assertEquals(mapRepository.getAllTables(), listOf(table))
    }

    @Test
    fun getAllWallsListCount_SuccessPath_ReturnsActualList() {
        // ARRANGE
        val wall = Wall(0.0, 0.0, UUID.randomUUID(), "tima", 1, 2) // ACT

        // ACT
        whenever(wallRepository.getAll()).thenReturn(listOf(wall))

        // ASSERT
        Assertions.assertEquals(mapRepository.getAllWalls(), listOf(wall))
    }
}