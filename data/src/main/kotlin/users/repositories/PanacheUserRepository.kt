package users.repositories

import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepository
import users.extensions.toUser
import users.extensions.toUserDbModel
import users.models.User
import users.models.UserDbModel
import java.util.*
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class PanacheUserRepository : PanacheRepository<UserDbModel> {
    fun save(user: User) {
        persist(user.toUserDbModel())
    }

    fun deleteById(id: UUID) {
        delete("id", getById(id))
    }

    fun getById(id: UUID): User {
        return list("id", id).first().toUser()
    }

    fun getAll(): List<User> {
        val userList: MutableList<User> = mutableListOf()

        findAll().list().forEach { userList.add(it.toUser()) }

        return userList
    }
}