package users

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import users.repositories.PanacheUserRepository
import org.mockito.kotlin.*
import users.models.Role
import users.models.User
import users.repositories.UserRepository
import java.util.*

class UserRepositoryTests {
    private val panacheRepository: PanacheUserRepository = mock()
    private val repository = UserRepository(panacheRepository)

    @Test
    fun saveUser_SuccessPath_SaveInPanacheRepositoryIsCalled() {
        // ARRANGE
        val user = User("test", "test", "nickname", "admin", Role.USER, UUID.randomUUID())

        // ACT
        repository.save(user)

        // ASSERT
        verify(panacheRepository, times(1)).save(user)
    }

    @Test
    fun deleteUserById_SuccessPath_DeleteInPanacheRepositoryIsCalled() {
        // ARRANGE
        val user = User("test", "test", "nickname", "admin", Role.USER, UUID.randomUUID())

        // ACT
        repository.save(user)
        repository.deleteById(user.id)

        // ASSERT
        verify(panacheRepository, times(1)).deleteById(user.id)
    }

    @Test
    fun getUserById_SuccessPath_ReturnsRequiredUser() {
        // ARRANGE
        val user = User("test", "test", "nickname", "admin", Role.USER, UUID.randomUUID())

        // ACT
        whenever(repository.getById(user.id)).thenReturn(user)

        // ASSERT
        Assertions.assertEquals(repository.getById(user.id), user)
    }

    @Test
    fun getAllUsers_SuccessPath_ReturnsActualList() {
        // ARRANGE
        val user = User("test", "test", "nickname", "admin", Role.USER, UUID.randomUUID())

        // ACT
        whenever(panacheRepository.getAll()).thenReturn(listOf(user))

        // ASSERT
        Assertions.assertEquals(repository.getAll(), listOf(user))
    }
}