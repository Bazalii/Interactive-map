package users.controllers

import users.models.User
import users.services.IUserService
import org.eclipse.microprofile.graphql.*
import java.util.*

@GraphQLApi
class UserController(private val _userService: IUserService) {
    @Query
    fun getById(id: UUID): User? {
        return _userService.find(id)
    }

    @Query
    fun getAll(): List<User>? {
        return _userService.findAll()
    }

    @Mutation
    fun add(user: User) {
        _userService.save(user)
    }

    @Mutation
    fun deleteById(id: UUID) {
        _userService.delete(id)
    }

    @Mutation
    fun createSuperUser(superUser: User) {
        _userService.createSuperUser(superUser)
    }

    @Mutation
    fun deleteSuperUserById(id: UUID) {
        _userService.deleteSuperUserById(id)
    }

    @Mutation
    fun updateNickname(id: UUID, nickname: String) {
        val user: User = _userService.find(id)!!

        _userService.changeNickname(user, nickname)
    }

    @Mutation
    fun updateRole(changedUserId: UUID, superUserId: UUID) {
        val changedUser: User = _userService.find(changedUserId)!!
        val superUser: User = _userService.find(superUserId)!!

        _userService.changeRole(changedUser, superUser)
    }
}