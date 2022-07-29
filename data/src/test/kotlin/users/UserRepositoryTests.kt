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
    private val panacheRepository: PanacheUserRepository = mock()
    private val repository = UserRepository(panacheRepository)

    @Test
    fun saveTest() {
        // ARRANGE
        val user = User("test", "test", "nickname", UUID.randomUUID())

        // ACT
        repository.save(user)

        // ASSERT
        verify(repository, times(1)).save(user)
    }

    @Test
    fun deleteByIdTest() {
        // ARRANGE
        val user = User("test", "test", "nickname", UUID.randomUUID())

        // ACT
        repository.save(user)
        repository.deleteById(user.id)

        // ASSERT
        verify(panacheRepository, times(1)).deleteById(user.id)
    }

    @Test
    fun getByIdTest() {
        // ARRANGE
        val user = User("test", "test", "nickname", UUID.randomUUID())

        // ACT
        whenever(repository.getById(user.id)).thenReturn(user)

        // ASSERT
        Assertions.assertEquals(repository.getById(user.id), user)
    }

    @Test
    fun getAllTest() {
        // ARRANGE
        val user = User("test", "test", "nickname", UUID.randomUUID())

        // ACT
        whenever(panacheRepository.getAll()).thenReturn(listOf(user))

        // ASSERT
        Assertions.assertEquals(repository.getAll(), listOf(user))
    }
}