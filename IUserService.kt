package users.services

import map.models.Table
import users.models.User
import java.util.*

interface IUserService {
    fun findUser(id: UUID): User?

    fun saveUser(user: User)

    fun deleteUserById(id: UUID)

    fun findAllUsers(): List<User>?

    fun createSuperUser(user: User)

    fun deleteSuperUserById(id: UUID)

    fun changeNickName(user: User, newNickName: String)

    fun changeRole(changedUser: User, superUser: User)
}