package users.controllers

import users.services.IUserService
import org.eclipse.microprofile.graphql.*
import users.models.*
import java.util.*
import javax.annotation.security.*
import javax.enterprise.context.RequestScoped
import javax.inject.Inject

@GraphQLApi
@RequestScoped
class UserController(@Inject private val _userService: IUserService) {
    @RolesAllowed("**")
    @Query
    fun getById(id: UUID): UserDto {
        return userConvertToDto(_userService.find(id))
    }

    @RolesAllowed("**")
    @Query
    fun getAll(): List<UserDto> {
        val users = _userService.findAll()
        val usersDto = mutableListOf<UserDto>()

        if (users != null) {
            for (user in users) {
                usersDto.add(userConvertToDto(user))
            }
        }

        return usersDto
    }

    @RolesAllowed("**")
    @Mutation
    fun add(userDto: UserDto): UserDto {
        val newUser = userDtoConvertToUser(userDto)

        _userService.save(newUser)

        return userDto
    }

    @RolesAllowed("ADMIN", "SUPERUSER")
    @Mutation
    fun deleteById(id: UUID): UserDto {
        val deletedUser = _userService.find(id)

        _userService.delete(id)

        return userConvertToDto(deletedUser)
    }

    @RolesAllowed("SUPERUSER")
    @Mutation
    fun createSuperUser(superUserDto: UserDto): UserDto {
        val newSuperUser = userDtoConvertToUser(superUserDto)

        _userService.createSuperUser(newSuperUser)

        return superUserDto
    }

    @RolesAllowed("SUPERUSER")
    @Mutation
    fun deleteSuperUserById(id: UUID): UserDto {
        val deletedSuperUser = _userService.find(id)

        _userService.deleteSuperUserById(id)

        return userConvertToDto(deletedSuperUser)
    }

    @RolesAllowed("USER", "SUPERUSER")
    @Mutation
    fun updateNickname(userDto: UserDto, nickname: String): UserDto {
        val changedUser: User = _userService.find(userDto.id)

        _userService.changeNickname(changedUser, nickname)

        return userConvertToDto(_userService.find(userDto.id))
    }

    @RolesAllowed("SUPERUSER")
    @Mutation
    fun updateRole(changedUserDto: UserDto, superUserDto: UserDto): UserDto {
        val changedUser: User = _userService.find(changedUserDto.id)
        val superUser: User = _userService.find(superUserDto.id)

        _userService.changeRole(changedUser, superUser)

        return userConvertToDto(_userService.find(changedUserDto.id))
    }

    private fun userConvertToDto(user: User): UserDto {
        return UserDto(user.name, user.surname, user.nickname, user.password, user.role, user.id)
    }

    private fun userDtoConvertToUser(userDto: UserDto): User {
        return User(userDto.name, userDto.surname, userDto.nickname, userDto.password, userDto.role, userDto.id)
    }
}