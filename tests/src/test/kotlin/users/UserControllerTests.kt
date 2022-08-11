package users

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever
import users.controllers.UserController
import users.models.*
import users.services.IUserService
import java.util.*

class UserControllerTests {
    private val _userService = mock<IUserService>()
    private val _userController = UserController(_userService)

    @Test
    fun add_SuccessPath_SaveUserIsCalledAndReturnsCorrespondingAddedUser() {
        // ARRANGE
        val usersId = UUID.randomUUID()
        val userDto = UserDto("test", "test", "nickname", "admin", Role.USER, usersId)
        val user = User("test", "test", "nickname", "admin", Role.USER, usersId)

        // ACT
        val newUser = _userController.add(userDto)

        // ASSERT
        Mockito.verify(_userService, Mockito.times(1)).save(user)
        Assertions.assertEquals(userDto, newUser)
    }

    @Test
    fun deleteById_SuccessPath_DeleteUserIsCalledAndReturnsCorrespondingDeletedDtoUser() {
        // ARRANGE
        val usersId = UUID.randomUUID()
        val userDto = UserDto("test", "test", "nickname", "admin", Role.USER, usersId)
        val user = User("test", "test", "nickname", "admin", Role.USER, usersId)
        whenever(_userService.find(userDto.id)).thenReturn(user)

        // ACT
        _userController.add(userDto)
        val deletedUser = _userController.deleteById(userDto.id)

        // ASSERT
        Mockito.verify(_userService, Mockito.times(1)).delete(userDto.id)
        Assertions.assertEquals(userDto.id, deletedUser.id)
    }

    @Test
    fun getById_SuccessPath_FindUserIsCalledAndReturnsCorrespondingDtoUser() {
        // ARRANGE
        val usersId = UUID.randomUUID()
        val userDto = UserDto("test", "test", "nickname", "admin", Role.USER, usersId)
        val user = User("test", "test", "nickname", "admin", Role.USER, usersId)
        whenever(_userService.find(userDto.id)).thenReturn(user)

        // ACT
        val foundUser = _userController.getById(userDto.id)

        // ASSERT
        Mockito.verify(_userService, Mockito.times(1)).find(userDto.id)
        Assertions.assertEquals(userDto.id, foundUser.id)
    }

    @Test
    fun getAll_SuccessPath_FindAllUsersIsCalledAndReturnsCorrespondingDtoUsers() {
        // ARRANGE
        val firstUserId = UUID.randomUUID()
        val firstUser = User("Alexey", "Ivanov", "poker303", "admin", Role.USER, firstUserId)

        val secondUserId = UUID.randomUUID()
        val secondUser = User("Sergey", "Ivanov", "serg", "admin", Role.USER, secondUserId)
        whenever(_userService.findAll()).thenReturn(listOf(firstUser, secondUser))

        // ACT
        _userController.getAll()

        // ASSERT
        Mockito.verify(_userService, Mockito.times(1)).findAll()
    }
    @Test
    fun updateNickname_SuccessPath_ChangeUserNicknameIsCalled() {
        // ARRANGE
        val userId = UUID.randomUUID()
        val newNickname = "Genius"
        val user = User("Sergey", "Ivanov", "Aboltus", "admin", Role.USER, userId)
        val userDto = UserDto("Sergey", "Ivanov", "Aboltus", "admin", Role.USER, userId)
        whenever(_userService.find(userDto.id)).thenReturn(user)

        // ACT
        _userController.updateNickname(userDto, newNickname)

        // ASSERT
        Mockito.verify(_userService, Mockito.times(1)).changeNickname(user, newNickname)
    }

    @Test
    fun updateRole_SuccessPath_ChangeUserRoleIsCalled() {
        // ARRANGE
        val changedUserId = UUID.randomUUID()
        val changedUser = User("Sergey", "Ivanov", "Aboltus", "admin", Role.USER, changedUserId)
        val changedUserDto = UserDto("Sergey", "Ivanov", "Aboltus", "admin", Role.USER, changedUserId)

        val superUserId = UUID.randomUUID()
        val superUser = User("Ivan", "Bazalii", "Boss", "admin", Role.SUPERUSER, superUserId)
        val superUserDto = UserDto("Ivan", "Bazalii", "Boss", "admin", Role.SUPERUSER, superUserId)
        whenever(_userService.find(changedUserDto.id)).thenReturn(changedUser)
        whenever(_userService.find(superUserDto.id)).thenReturn(superUser)

        // ACT
        _userController.updateRole(changedUserDto, superUserDto)

        // ASSERT
        Mockito.verify(_userService, Mockito.times(1)).changeRole(changedUser, superUser)
    }
}