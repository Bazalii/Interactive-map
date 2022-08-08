package users.services

import users.models.User
import java.util.*

interface IUserService {
    fun find(id: UUID): User

    fun save(user: User)

    fun delete(id: UUID)

    fun findAll(): List<User>?

    fun createSuperUser(user: User)

    fun deleteSuperUserById(id: UUID)

    fun changeNickname(user: User, newNickName: String)

    fun changeRole(changedUser: User, superUser: User)
}