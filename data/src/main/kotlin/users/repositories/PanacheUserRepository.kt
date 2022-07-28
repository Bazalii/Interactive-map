package users.repositories

import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepository
import users.extensions.toUser
import users.extensions.toUserDbModel
import users.models.User
import users.models.UserDbModel
import java.util.*

class PanacheUserRepository : PanacheRepository<UserDbModel> {
    fun save(user: User) {
        persist(user.toUserDbModel())
    }

    fun getById(userId: UUID): User {
        return list("id", userId).first().toUser()
    }

    fun deleteById(userId: UUID) {
        delete("id", getById(userId))
    }

    fun getAll(): List<User> {
        val userList: MutableList<User> = mutableListOf()
        findAll().list().forEach { userList.add(it.toUser()) }
        return userList

    }
}