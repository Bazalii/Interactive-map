package users

import io.quarkus.test.junit.QuarkusTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import users.repositories.PanacheUserRepository
import org.mockito.kotlin.*
import users.models.User
import users.repositories.UserRepository
import java.util.*

@QuarkusTest
class UserRepositoryTests {
    private val userPanacheRepository: PanacheUserRepository = mock()
    private val userRepository = UserRepository(userPanacheRepository)

    @Test
    fun saveUserTest(){
        // ARRANGE
        val user = User("test", "test", "nickname", UUID.randomUUID())

        // ACT
        userRepository.save(user)

        // ASSERT
        verify(userRepository, times(1)).save(user)
    }

    @Test
    fun deleteUserByIdTest(){
        // ARRANGE
        val user = User("test", "test", "nickname", UUID.randomUUID())

        // ACT
        userRepository.save(user)
        userRepository.deleteById(user.id)

        // ASSERT
        verify(userPanacheRepository, times(1)).deleteById(user.id)
    }
    @Test
    fun getUserByIdTest(){
        // ARRANGE
        val user = User("test", "test", "nickname", UUID.randomUUID())

        // ACT
        whenever(userRepository.getById(user.id)).thenReturn(user)

        // ASSERT
        Assertions.assertEquals(userRepository.getById(user.id), user)
    }
    @Test
    fun getAllUsersTest(){
        // ARRANGE
        val user = User("test", "test", "nickname", UUID.randomUUID())

        // ACT
        whenever(userPanacheRepository.getAll()).thenReturn(listOf(user))

        // ASSERT
        Assertions.assertEquals(userRepository.getAll(), listOf(user))
    }
}