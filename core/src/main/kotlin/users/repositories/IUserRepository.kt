package users.repositories

import users.models.User
import java.util.UUID

interface IUserRepository {
    fun save(user: User)

    fun deleteById(id: UUID)

    fun getById(id: UUID): User

    fun getAll(): List<User>

    fun update(user: User)
}