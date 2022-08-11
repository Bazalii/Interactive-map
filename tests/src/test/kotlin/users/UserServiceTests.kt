package users

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.Mockito.*
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever
import users.models.Role
import users.models.User
import users.repositories.IUserRepository
import users.services.implementations.UserService
import java.util.*

class UserServiceTests {
    private val _userRepository = mock<IUserRepository>()
    private val _userService = UserService(_userRepository)

    @Test
    fun save_SuccessPath_SaveUserIsCalledInUserRepository() {
        // ARRANGE
        val user = User("test", "test", "nickname", "admin", Role.USER, UUID.randomUUID())

        // ACT
        _userService.save(user)

        // ASSERT
        verify(_userRepository, times(1)).save(user)
    }

    @Test
    fun delete_SuccessPath_DeleteUserByIdIsCalledInUserRepository() {
        // ARRANGE
        val user = User("test", "test", "nickname", "admin", Role.USER, UUID.randomUUID())

        // ACT
        _userService.save(user)
        _userService.delete(user.id)

        // ASSERT
        verify(_userRepository, times(1)).deleteById(user.id)
    }

    @Test
    fun find_SuccessPath_GetUserByIdIsCalledFromUserRepositoryAndReturnsCorrespondingUser() {
        // ARRANGE
        val user = User("test", "test", "nickname", "admin", Role.USER, UUID.randomUUID())
        whenever(_userRepository.getById(user.id)).thenReturn(user)

        // ACT
        val foundUser = _userService.find(user.id)

        // ASSERT
        verify(_userRepository, times(1)).getById(user.id)
        Assertions.assertEquals(user, foundUser)
    }

    @Test
    fun getAll_SuccessPath_GetAllUsersIsCalledFromUserRepositoryAndReturnsCorrespondingUsers() {
        // ARRANGE
        val firstUser = User("Alexey", "Ivanov", "poker303", "admin", Role.USER, UUID.randomUUID())
        val secondUser = User("Sergey", "Ivanov", "serg", "admin", Role.USER, UUID.randomUUID())
        whenever(_userRepository.getAll()).thenReturn(listOf(firstUser, secondUser))

        // ACT
        val foundUsers = _userService.findAll()

        // ASSERT
        verify(_userRepository, times(1)).getAll()
        Assertions.assertEquals(listOf(firstUser, secondUser), foundUsers)
    }

    @Test
    fun createSuperUser_SuccessPath_CreateSuperUserIsCalled() {
        // ARRANGE
        val superUser = User("Ivan", "Bazalii", "Boss", "admin", Role.SUPERUSER, UUID.randomUUID())

        // ACT
        _userService.createSuperUser(superUser)

        // ASSERT
        verify(_userRepository, times(1)).save(superUser)
    }

    @Test
    fun deleteSuperUserById_SuccessPath_DeleteSuperUserByIdIsCalled() {
        // ARRANGE
        val superUser = User("Ivan", "Bazalii", "Boss", "admin", Role.SUPERUSER, UUID.randomUUID())

        // ACT
        _userService.createSuperUser(superUser)
        _userService.deleteSuperUserById(superUser.id)

        // ASSERT
        verify(_userRepository, times(1)).deleteById(superUser.id)
    }

    @Test
    fun changeNickname_SuccessPath_ChangeUserNicknameIsCalledAndNicknameSuccessfullyChanged() {
        // ARRANGE
        val user = User("Sergey", "Ivanov", "Aboltus","admin", Role.USER, UUID.randomUUID())

        // ACT
        _userService.changeNickname(user, "Genius")

        // ASSERT
        verify(_userRepository, times(1)).update(user)
        Assertions.assertEquals("Genius", user.nickname)
    }

    @Test
    fun changeRole_SuccessPath_ChangeUserRoleIsCalledAndRoleSuccessfullyChanged() {
        // ARRANGE
        val changedUser = User("Sergey", "Ivanov", "Aboltus","admin", Role.USER, UUID.randomUUID())
        val superUser = User("Ivan", "Bazalii", "Boss", "admin", Role.SUPERUSER, UUID.randomUUID())

        // ACT
        _userService.changeRole(changedUser, superUser)

        // ASSERT
        verify(_userRepository, times(1)).update(changedUser)
        Assertions.assertEquals(Role.ADMIN, changedUser.role)
    }
}