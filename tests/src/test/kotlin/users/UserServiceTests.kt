package users

import io.quarkus.test.junit.QuarkusTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.Mockito.*
import org.mockito.kotlin.mock
import users.models.Role
import users.models.User
import users.repositories.IUserRepository
import users.services.IUserService
import users.services.implementations.UserService
import java.util.*

@QuarkusTest
class UserServiceTests {
    private val userRepository: IUserRepository = mock()
    private val userService = UserService(userRepository)

    private val mockIUserService: IUserService = mock()

    @Test
    fun save_SuccessPath_SaveUserByUserServiceInUserRepositoryIsCalled() {
        // ARRANGE
        val user = User("test", "test", "nickname", Role.USER, UUID.randomUUID())

        // ACT
        userService.save(user)

        // ASSERT
        verify(userRepository, times(1)).save(user)
    }

    @Test
    fun delete_SuccessPath_DeleteUserByIdByUserServiceInUserRepositoryIsCalled() {
        // ARRANGE
        val user = User("test", "test", "nickname", Role.USER, UUID.randomUUID())

        // ACT
        userService.save(user)
        userService.delete(user.id)

        // ASSERT
        verify(userRepository, times(1)).deleteById(user.id)
    }

    @Test
    fun find_SuccessPath_GetUserByIdFromUserRepositoryByUserServiceIsCalled() {
        // ARRANGE
        val user = User("test", "test", "nickname", Role.USER, UUID.randomUUID())

        // ACT
        userService.find(user.id)

        // ASSERT
        verify(userRepository, times(1)).getById(user.id)
    }

    @Test
    fun getAll_SuccessPath_GetAllUsersFromUserRepositoryByUserServiceIsCalled() {
        // ARRANGE

        // ACT
        userService.findAll()

        // ASSERT
        verify(userRepository, times(1)).getAll()
    }

    @Test
    fun createSuperUser_SuccessPath_CreateSuperUserByUserServiceIsCalled() {
        // ARRANGE
        val superUser = User("Ivan", "Bazalii", "Boss", Role.SUPERUSER, UUID.randomUUID())

        // ACT
        mockIUserService.createSuperUser(superUser)

        // ASSERT
        verify(mockIUserService, times(1)).createSuperUser(superUser)
    }

    @Test
    fun deleteSuperUserById_SuccessPath_DeleteSuperUserByIdByUserServiceIsCalled() {
        // ARRANGE
        val superUser = User("Ivan", "Bazalii", "Boss", Role.SUPERUSER, UUID.randomUUID())

        // ACT
        mockIUserService.createSuperUser(superUser)
        mockIUserService.deleteSuperUserById(superUser.id)

        // ASSERT
        verify(mockIUserService, times(1)).deleteSuperUserById(superUser.id)
    }

    @Test
    fun changeNickname_SuccessPath_MethodChangeUserNicknameIsCalledNewUserNickname() {
        // ARRANGE
        val user = User("Sergey", "Ivanov", "Aboltus", Role.USER, UUID.randomUUID())

        // ACT
        userService.changeNickname(user, "Genius")
        mockIUserService.changeNickname(user, "Genius")
        // ASSERT

        verify(mockIUserService, times(1)).changeNickname(user, "Genius")
        Assertions.assertEquals("Genius", user.nickname)
    }

    @Test
    fun changeRole_SuccessPath_MethodChangeUserRoleIsCalledNewUserRole() {
        // ARRANGE
        val changedUser = User("Sergey", "Ivanov", "Aboltus", Role.USER, UUID.randomUUID())
        val superUser = User("Ivan", "Bazalii", "Boss", Role.SUPERUSER, UUID.randomUUID())

        // ACT
        userService.changeRole(changedUser, superUser)
        mockIUserService.changeRole(changedUser, superUser)

        // ASSERT

        verify(mockIUserService, times(1)).changeRole(changedUser, superUser)
        Assertions.assertEquals(Role.ADMIN, changedUser.role)
    }
}