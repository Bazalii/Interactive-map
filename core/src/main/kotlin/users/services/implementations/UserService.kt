package users.services.implementations

import users.models.Role
import users.models.User
import users.repositories.IUserRepository
import users.services.IUserService
import java.util.UUID
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class UserService(private val _userRepository: IUserRepository) : IUserService {

    override fun findUser(id: UUID): User {
        return _userRepository.getById(id)
    }

    override fun saveUser(user: User) {
        _userRepository.save(user)
    }

    override fun deleteUserById(id: UUID) {
        _userRepository.deleteById(id)
    }

    override fun findAllUsers(): List<User> {
        return _userRepository.getAll()
    }

    override fun createSuperUser(user: User) {
        return _userRepository.save(user)
    }

    override fun deleteSuperUserById(id: UUID) {
        _userRepository.deleteById(id)
    }

    override fun changeNickName(user: User, newNickName: String) {
        user.nickname = newNickName
    }

    override fun changeRole(changedUser: User, superUser: User) {
        if (superUser.role == Role.SUPERUSER) {
            changedUser.role = Role.ADMIN
        }
    }
}