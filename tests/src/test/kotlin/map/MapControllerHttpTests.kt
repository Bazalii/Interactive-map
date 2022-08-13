package map

import io.quarkus.test.junit.QuarkusTest
import io.restassured.RestAssured.given
import io.restassured.http.ContentType
import io.restassured.response.Response
import map.dto.*
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

    private fun getIdFromResponse(response: String): UUID {
        return UUID.fromString(response.substringAfter("\"id\": \"").substringBefore('\"'))
    }

    @Test
    fun saveChair_SuccessPath_ChairCreatedAndCorrectStatusCodeIsReturned() {
        val chairRequest = ChairRequest(0.0, 0.0, "Fox", 2, 4)
        val file = generateStringFromResource(EndPoints.saveChair)
        val query = GraphQlQuery(file, Variables(chairRequest))

        request(query).prettyPrint()
    }

    @Test
    fun saveTable_SuccessPath_TableCreatedAndCorrectStatusCodeIsReturned() {
        val tableRequest = TableRequest(0.0, 0.0, "Fox", 1, 2, "red")
        val file = generateStringFromResource(EndPoints.saveTable)
        val query = GraphQlQuery(file, Variables(tableRequest))

        request(query).prettyPrint()
    }

    @Test
    fun saveWall_SuccessPath_WallCreatedAndCorrectStatusCodeIsReturned() {
        val wallRequest = WallRequest(0.0, 0.0, "Fox", 4, 5)
        val file = generateStringFromResource(EndPoints.saveWall)
        val query = GraphQlQuery(file, Variables(wallRequest))

        request(query).prettyPrint()
    }

    @Test
    fun deleteChair_SuccessPath_ChairDeletedAndReturnedCorrectStatusCode() {
        val chairRequest = ChairRequest(0.0, 0.0,  "Fox", 2, 4)
        var file = generateStringFromResource(EndPoints.saveChair)
        var query = GraphQlQuery(file, Variables(chairRequest))

        val id = getIdFromResponse(requestWithoutStatusCode(query).prettyPrint())

        file = generateStringFromResource(EndPoints.deleteChair)
        query = GraphQlQuery(file, Variables(id))

        request(query).prettyPrint()
    }

    @Test
    fun deleteTable_SuccessPath_TableDeletedAndReturnedCorrectStatusCode() {
        val tableRequest = TableRequest(0.0, 0.0, "Fox", 1, 2, "red")
        var file = generateStringFromResource(EndPoints.saveTable)
        var query = GraphQlQuery(file, Variables(tableRequest))

        val id = getIdFromResponse(requestWithoutStatusCode(query).prettyPrint())

        file = generateStringFromResource(EndPoints.deleteTable)
        query = GraphQlQuery(file, Variables(id))

        request(query).prettyPrint()
    }

    @Test
    fun deleteWall_SuccessPath_WallDeletedAndReturnedCorrectStatusCode() {
        val wallRequest = WallRequest(0.0, 0.0, "Fox", 4, 5)
        var file = generateStringFromResource(EndPoints.saveWall)
        var query = GraphQlQuery(file, Variables(wallRequest))

        val id = getIdFromResponse(requestWithoutStatusCode(query).prettyPrint())

        file = generateStringFromResource(EndPoints.deleteWall)
        query = GraphQlQuery(file, Variables(id))

        request(query).prettyPrint()
    }

    @Test
    fun getChairById_SuccessPath_ChairFoundAndReturnedCorrectStatusCode() {
        val chairRequest = ChairRequest(0.0, 0.0, "Fox", 2, 4)
        var file = generateStringFromResource(EndPoints.saveChair)
        var query = GraphQlQuery(file, Variables(chairRequest))

        val id = getIdFromResponse(requestWithoutStatusCode(query).prettyPrint())

        file = generateStringFromResource(EndPoints.chairById)
        query = GraphQlQuery(file, Variables(id))

        request(query).prettyPrint()
    }

    @Test
    fun getTableById_SuccessPath_TableFoundAndReturnedCorrectStatusCode() {
        val tableRequest = TableRequest(0.0, 0.0, "Fox", 1, 2, "red")
        var file = generateStringFromResource(EndPoints.saveTable)
        var query = GraphQlQuery(file, Variables(tableRequest))

        val id = getIdFromResponse(requestWithoutStatusCode(query).prettyPrint())

        file = generateStringFromResource(EndPoints.tableById)
        query = GraphQlQuery(file, Variables(id))

        request(query).prettyPrint()
    }

    @Test
    fun getWallById_SuccessPath_WallFoundAndReturnedCorrectStatusCode() {
        val wallRequest = WallRequest(0.0, 0.0, "Fox", 4, 5)
        var file = generateStringFromResource(EndPoints.saveWall)
        var query = GraphQlQuery(file, Variables(wallRequest))

        val id = getIdFromResponse(requestWithoutStatusCode(query).prettyPrint())

        file = generateStringFromResource(EndPoints.wallById)
        query = GraphQlQuery(file, Variables(id))

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