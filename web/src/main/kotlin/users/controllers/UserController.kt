package users.controllers

import users.models.User
import users.services.IUserService
import org.eclipse.microprofile.graphql.*
import java.util.*

@GraphQLApi
class UserController(private val _userService: IUserService) {
    @Query
    fun getUser(id: UUID): User? {
        return _userService.find(id)
    }

    @Query
    fun getUsers(): List<User>? {
        return _userService.findAll()
    }

    @Mutation
    fun addUser(user: User) {
        _userService.save(user)
    }

    @Mutation
    fun deleteUser(id: UUID) {
        _userService.delete(id)
    }

    @Mutation
    fun createSuperUser(superUser: User) {
        _userService.createSuperUser(superUser)
    }

    @Mutation
    fun deleteSuperUser(id: UUID) {
        _userService.deleteSuperUserById(id)
    }

    @Mutation
    fun updateUserNickname(id: UUID, nickname: String) {
        val user: User = _userService.find(id)!!
        _userService.changeNickname(user, nickname)
    }

    @Mutation
    fun updateUserRole(changedUserId: UUID, superUserId: UUID) {
        val changedUser: User = _userService.find(changedUserId)!!
        val superUser: User = _userService.find(superUserId)!!
        _userService.changeRole(changedUser, superUser)
    }
}