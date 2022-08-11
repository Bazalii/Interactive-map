package users

import io.quarkus.test.junit.QuarkusTest
import io.quarkus.test.security.TestSecurity
import io.restassured.RestAssured.given
import io.restassured.http.ContentType
import org.junit.jupiter.api.Test
import java.util.*


@QuarkusTest
class UserControllerHttpTests {
    private val _baseURL = "http://localhost:8080/mapins"

    @Test
    fun add_SuccessPath_UserCreatedAndCorrectStatusCodeIsReturned() {
        val id = UUID.randomUUID()

        given()
            .contentType(ContentType.JSON)
            .body("{\"query\" : \"mutation add {add(userDto:{name: \\\"Adda\\\" surname: \\\"Bazalii\\\" nickname: \\\"Amogus\\\" password: \\\"123\\\" id: \\\"$id\\\"}){name surname id}}\"}")
            .`when`()
            .post(_baseURL)
            .then()
            .assertThat()
            .statusCode(200)
            .and()
            .extract()
            .response()
            .prettyPrint()
    }

    @Test
    fun deleteById_SuccessPath_UserDeletedAndCorrectStatusCodeIsReturned() {
        val id = UUID.randomUUID()

        given()
            .contentType(ContentType.JSON)
            .body("{\"query\" : \"mutation add {add(userDto:{name: \\\"Biba\\\" surname: \\\"Bazalii\\\" nickname: \\\"Amogus\\\" password: \\\"123\\\" id: \\\"$id\\\"}){name surname id}}\"}")
            .`when`()
            .post(_baseURL)
            .prettyPrint()

        given()
            .contentType(ContentType.JSON)
            .body("{\"query\" : \"mutation deleteById {deleteById(id: \\\"$id\\\"){name id}}\"}")
            .`when`()
            .post(_baseURL)
            .then()
            .assertThat()
            .statusCode(200)
            .and()
            .extract()
            .response()
            .prettyPrint()
    }

    @Test
    fun getById_SuccessPath_UserFoundAndCorrectStatusCodeIsReturned() {
        val id = UUID.randomUUID()

        given()
            .contentType(ContentType.JSON)
            .body("{\"query\" : \"mutation add {add(userDto:{name: \\\"Cila\\\" surname: \\\"Bazalii\\\" nickname: \\\"Amogus\\\" password: \\\"123\\\" id: \\\"$id\\\"}){name surname id}}\"}")
            .`when`()
            .post(_baseURL)
            .prettyPrint()

        given()
            .contentType(ContentType.JSON)
            .body("{\"query\" : \"query getById {byId(id: \\\"$id\\\"){name surname nickname password role id}}\"}")
            .`when`()
            .post(_baseURL)
            .then()
            .assertThat()
            .statusCode(200)
            .and()
            .extract()
            .response()
            .prettyPrint()
    }

    @Test
    fun getAll_SuccessPath_AllUsersFoundAndCorrectStatusCodeIsReturned() {
        given()
            .contentType(ContentType.JSON)
            .body("{\"query\" : \"query getAll {all {name surname nickname password role id}}\"}")
            .`when`()
            .post(_baseURL)
            .then()
            .assertThat()
            .statusCode(200)
            .and()
            .extract()
            .response()
            .prettyPrint()
    }

    @Test
    fun updateNickname_SuccessPath_UserNicknameUpdatedAndCorrectStatusCodeIsReturned() {
        val id = UUID.randomUUID()

        given()
            .contentType(ContentType.JSON)
            .body("{\"query\" : \"mutation add {add(userDto:{name: \\\"Dita\\\" surname: \\\"Bazalii\\\" nickname: \\\"Amogus\\\" password: \\\"123\\\" id: \\\"$id\\\"}){name surname id}}\"}")
            .`when`()
            .post(_baseURL)
            .prettyPrint()

        given()
            .contentType(ContentType.JSON)
            .body("{\"query\" : \"mutation updateNickName {updateNickname(userDto:{id: \\\"$id\\\"}, nickname: \\\"Retta\\\"){name surname password role id}}\"}")
            .`when`()
            .post(_baseURL)
            .then()
            .assertThat()
            .statusCode(200)
            .and()
            .extract()
            .response()
            .prettyPrint()
    }

    @Test
    fun updateRole_SuccessPath_UserRoleUpdatedAndCorrectStatusCodeIsReturned() {
        val changedUserId = UUID.randomUUID()

        val superUserId = UUID.randomUUID()

        given()
            .contentType(ContentType.JSON)
            .body("{\"query\" : \"mutation add {add(userDto:{name: \\\"Eva\\\" surname: \\\"Bazalii\\\" nickname: \\\"Amogus\\\" password: \\\"123\\\" id: \\\"$changedUserId\\\"}){name surname id role}}\"}")
            .`when`()
            .post(_baseURL)
            .prettyPrint()

        given()
            .contentType(ContentType.JSON)
            .body("{\"query\" : \"mutation add {add(userDto:{name: \\\"Fucker\\\" surname: \\\"Bazalii\\\" nickname: \\\"Amogus\\\" password: \\\"123\\\" role: SUPERUSER id: \\\"$superUserId\\\"}){name surname id role}}\"}")
            .`when`()
            .post(_baseURL)
            .prettyPrint()

        given()
            .contentType(ContentType.JSON)
            .body("{\"query\" : \"mutation updateRole {updateRole(changedUserDto:{id: \\\"$changedUserId\\\"}, superUserDto:{id: \\\"$superUserId\\\"}){id}}\"}")
            .`when`()
            .post(_baseURL)
            .then()
            .assertThat()
            .statusCode(200)
            .and()
            .extract()
            .response()
            .prettyPrint()
    }
}