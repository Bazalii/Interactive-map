package users.controllers

import users.models.User
import users.services.IUserService
import org.eclipse.microprofile.graphql.*
import java.util.*
import javax.annotation.security.*
import javax.enterprise.context.RequestScoped
import javax.inject.Inject

@GraphQLApi
@RequestScoped
class UserController(@Inject private val _userService: IUserService) {
    @RolesAllowed("**")
    @Query
    fun getById(id: UUID): User {
        return _userService.find(id)
    }

    @RolesAllowed("**")
    @Query
    fun getAll(): List<User>? {
        return _userService.findAll()
    }

    @RolesAllowed("**")
    @Mutation
    fun add(user: User): User {
        _userService.save(user)
        return user
    }

    @RolesAllowed("ADMIN", "SUPERUSER")
    @Mutation
    fun deleteById(id: UUID): User {
        _userService.delete(id)
        return _userService.find(id)
    }

    @RolesAllowed("SUPERUSER")
    @Mutation
    fun createSuperUser(superUser: User): User {
        _userService.createSuperUser(superUser)
        return superUser
    }

    @RolesAllowed("SUPERUSER")
    @Mutation
    fun deleteSuperUserById(id: UUID): User {
        _userService.deleteSuperUserById(id)
        return _userService.find(id)
    }

    @RolesAllowed("USER", "SUPERUSER")
    @Mutation
    fun updateNickname(user: User, nickname: String): User {
        _userService.changeNickname(user, nickname)
        return user
    }

    @RolesAllowed("SUPERUSER")
    @Mutation
    fun updateRole(changedUser: User, superUser: User): User {
        _userService.changeRole(changedUser, superUser)
        return changedUser
    }
}