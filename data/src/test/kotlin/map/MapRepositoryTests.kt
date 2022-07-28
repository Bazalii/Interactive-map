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
    fun saveChairs_RightAmountOfInteractionsOfSaveMethod() {
        val firstChair = Chair(0.0, 0.0, UUID.randomUUID(), "tima", 1, 2)

        mapRepository.saveChair(firstChair)

        verify(chairRepository, times(1)).save(any())
    }


    @Test
    fun saveTables_RightAmountOfInteractionsOfSaveMethod() {
        val firstTable = Table(0.0, 0.0, UUID.randomUUID(), "tima", 1, 2, "red")
        val secondTable = Table(1.0, 2.0, UUID.randomUUID(), "tima", 2, 3, "red")

        mapRepository.saveTable(firstTable)
        mapRepository.saveTable(secondTable)

        verify(tableRepository, times(2)).save(any())
    }

    @Test
    fun saveWalls_VerifyRightAmountOfInteractionsOfSaveMethod() {
        val firstWall = Wall(0.0, 0.0, UUID.randomUUID(), "tima", 1, 2)
        val secondWall = Wall(1.0, 2.0, UUID.randomUUID(), "tima", 2, 3)
        val thirdWall = Wall(2.0, 2.0, UUID.randomUUID(), "tima", 2, 3)

        mapRepository.saveWall(firstWall)
        mapRepository.saveWall(secondWall)
        mapRepository.saveWall(thirdWall)

        verify(wallRepository, times(3)).save(any())
    }

    @Test
    fun deleteChair_DeleteMethodCalledOnce() {
        val chair = Chair(0.0, 0.0, UUID.randomUUID(), "tima", 1, 2)

        mapRepository.saveChair(chair)
        mapRepository.deleteChairById(chair.id)

        verify(chairRepository, times(1)).deleteById(chair.id)
    }

    @Test
    fun deleteTable_DeleteMethodCalledOnce() {
        val table = Table(0.0, 0.0, UUID.randomUUID(), "tima", 1, 2, "red")

        mapRepository.saveTable(table)
        mapRepository.deleteTableById(table.id)

        verify(tableRepository, times(1)).deleteById(table.id)
    }

    @Test
    fun deleteWall_DeleteMethodCalledOnce() {
        val wall = Wall(0.0, 0.0, UUID.randomUUID(), "tima", 1, 2)

        mapRepository.saveWall(wall)
        mapRepository.deleteWallById(wall.id)

        verify(wallRepository, times(1)).deleteById(wall.id)
    }

    @Test
    fun getChairById_ReturnsCorrectTable() {
        val chair = Chair(0.0, 0.0, UUID.randomUUID(), "tima", 1, 2)

        whenever(chairRepository.getById(chair.id)).thenReturn(chair)

        Assertions.assertEquals(mapRepository.getChairById(chair.id), chair)
    }

    @Test
    fun getTableById_ReturnsCorrectTable() {
        val table = Table(0.0, 0.0, UUID.randomUUID(), "tima", 1, 2, "red")

        whenever(tableRepository.getById(table.id)).thenReturn(table)

        Assertions.assertEquals(mapRepository.getTableById(table.id), table)
    }

    @Test
    fun getWallById_ReturnsCorrectTable() {
        val wall = Wall(0.0, 0.0, UUID.randomUUID(), "tima", 1, 2)

        whenever(wallRepository.getById(wall.id)).thenReturn(wall)

        Assertions.assertEquals(mapRepository.getWallById(wall.id), wall)
    }


    @Test
    fun getAllChairsListCount_ReturnsActualCount() {
        val chair = Chair(0.0, 0.0, UUID.randomUUID(), "tima", 1, 2)

        whenever(chairRepository.getAll()).thenReturn(listOf(chair))

        Assertions.assertEquals(mapRepository.getAllChairs().count(), 1)
    }

    @Test
    fun getAllTablesListCount_ReturnsActualCount() {
        val table = Table(0.0, 0.0, UUID.randomUUID(), "tima", 1, 2, "red")

        whenever(tableRepository.getAll()).thenReturn(listOf(table))

        Assertions.assertEquals(mapRepository.getAllTables().count(), 1)
    }

    @Test
    fun getAllWallsListCount_ReturnsActualCount() {
        val wall = Wall(0.0, 0.0, UUID.randomUUID(), "tima", 1, 2)

        whenever(wallRepository.getAll()).thenReturn(listOf(wall))

        Assertions.assertEquals(mapRepository.getAllWalls().count(), 1)
    }
}