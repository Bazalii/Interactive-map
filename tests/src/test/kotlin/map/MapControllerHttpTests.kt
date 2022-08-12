package map

import io.quarkus.test.junit.QuarkusTest
import io.restassured.RestAssured.given
import io.restassured.http.ContentType
import io.restassured.response.Response
import map.dto.ChairDto
import map.dto.TableDto
import map.dto.WallDto
import org.junit.jupiter.api.Test
import java.nio.file.Files
import java.nio.file.Paths
import java.util.*

@QuarkusTest
class MapControllerHttpTests {
    private val _baseURL = "http://localhost:8080/mapins"

    private fun generateStringFromResource(path: String): String {
        return String(Files.readAllBytes(Paths.get(path)))
    }

    private fun request(query: GraphQlQuery): Response {
        return given()
            .contentType(ContentType.JSON)
            .body(query)
            .`when`()
            .post(_baseURL)
            .then()
            .assertThat()
            .statusCode(200)
            .and()
            .extract()
            .response()
    }

    private fun requestWithoutStatusCode(query: GraphQlQuery): Response {
        return given()
            .contentType(ContentType.JSON)
            .body(query)
            .post(_baseURL)
    }

    @Test
    fun saveChair_SuccessPath_ChairCreatedAndCorrectStatusCodeIsReturned() {
        val chair = ChairDto(0.0, 0.0, UUID.randomUUID(), "Fox", 2, 4)
        val file = generateStringFromResource(EndPoints.saveChair)
        val query = GraphQlQuery(file, Variables(chair))

        request(query).prettyPrint()
    }

    @Test
    fun saveTable_SuccessPath_TableCreatedAndCorrectStatusCodeIsReturned() {
        val table = TableDto(0.0, 0.0, UUID.randomUUID(), "Fox", 1, 2, "red")
        val file = generateStringFromResource(EndPoints.saveTable)
        val query = GraphQlQuery(file, Variables(table))

        request(query).prettyPrint()
    }

    @Test
    fun saveWall_SuccessPath_WallCreatedAndCorrectStatusCodeIsReturned() {
        val wall = WallDto(0.0, 0.0, UUID.randomUUID(), "Fox", 4, 5)
        val file = generateStringFromResource(EndPoints.saveWall)
        val query = GraphQlQuery(file, Variables(wall))

        request(query).prettyPrint()
    }

    @Test
    fun deleteChair_SuccessPath_ChairDeletedAndReturnedCorrectStatusCode() {
        val chair = ChairDto(0.0, 0.0, UUID.randomUUID(), "Fox", 2, 4)
        var file = generateStringFromResource(EndPoints.saveChair)
        var query = GraphQlQuery(file, Variables(chair))

        requestWithoutStatusCode(query).prettyPrint()

        file = generateStringFromResource(EndPoints.deleteChair)
        query = GraphQlQuery(file, Variables(chair.id))

        request(query).prettyPrint()
    }

    @Test
    fun deleteTable_SuccessPath_TableDeletedAndReturnedCorrectStatusCode() {
        val table = TableDto(0.0, 0.0, UUID.randomUUID(), "Fox", 1, 2, "red")
        var file = generateStringFromResource(EndPoints.saveTable)
        var query = GraphQlQuery(file, Variables(table))

        requestWithoutStatusCode(query).prettyPrint()

        file = generateStringFromResource(EndPoints.deleteTable)
        query = GraphQlQuery(file, Variables(table.id))

        request(query).prettyPrint()
    }

    @Test
    fun deleteWall_SuccessPath_WallDeletedAndReturnedCorrectStatusCode() {
        val wall = WallDto(0.0, 0.0, UUID.randomUUID(), "Fox", 4, 5)
        var file = generateStringFromResource(EndPoints.saveWall)
        var query = GraphQlQuery(file, Variables(wall))

        requestWithoutStatusCode(query).prettyPrint()

        file = generateStringFromResource(EndPoints.deleteWall)
        query = GraphQlQuery(file, Variables(wall.id))

        request(query).prettyPrint()
    }

    @Test
    fun getChairById_SuccessPath_ChairFoundAndReturnedCorrectStatusCode() {
        val chair = ChairDto(0.0, 0.0, UUID.randomUUID(), "Fox", 2, 4)
        var file = generateStringFromResource(EndPoints.saveChair)
        var query = GraphQlQuery(file, Variables(chair))

        requestWithoutStatusCode(query).prettyPrint()

        file = generateStringFromResource(EndPoints.chairById)
        query = GraphQlQuery(file, Variables(chair.id))

        request(query).prettyPrint()
    }

    @Test
    fun getTableById_SuccessPath_TableFoundAndReturnedCorrectStatusCode() {
        val table = TableDto(0.0, 0.0, UUID.randomUUID(), "Fox", 1, 2, "red")
        var file = generateStringFromResource(EndPoints.saveTable)
        var query = GraphQlQuery(file, Variables(table))

        requestWithoutStatusCode(query).prettyPrint()

        file = generateStringFromResource(EndPoints.tableById)
        query = GraphQlQuery(file, Variables(table.id))

        request(query).prettyPrint()
    }

    @Test
    fun getWallById_SuccessPath_WallFoundAndReturnedCorrectStatusCode() {
        val wall = WallDto(0.0, 0.0, UUID.randomUUID(), "Fox", 4, 5)
        var file = generateStringFromResource(EndPoints.saveWall)
        var query = GraphQlQuery(file, Variables(wall))

        requestWithoutStatusCode(query).prettyPrint()

        file = generateStringFromResource(EndPoints.wallById)
        query = GraphQlQuery(file, Variables(wall.id))

        request(query).prettyPrint()
    }

    @Test
    fun getAllChairs_SuccessPath_AllChairsFoundAndCorrectStatusCodeIsReturned() {
        val file = generateStringFromResource(EndPoints.chairs)
        val query = GraphQlQuery(file)

        request(query).prettyPrint()
    }

    @Test
    fun getAllTables_SuccessPath_AllTablesFoundAndCorrectStatusCodeIsReturned() {
        val file = generateStringFromResource(EndPoints.tables)
        val query = GraphQlQuery(file)

        request(query).prettyPrint()
    }

    @Test
    fun getAllWalls_SuccessPath_AllWallsFoundAndCorrectStatusCodeIsReturned() {
        val file = generateStringFromResource(EndPoints.walls)
        val query = GraphQlQuery(file)

        request(query).prettyPrint()
    }
}