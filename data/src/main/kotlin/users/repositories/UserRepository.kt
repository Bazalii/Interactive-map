package users.repositories

import users.models.User
import java.util.*
import javax.enterprise.context.ApplicationScoped
import javax.transaction.Transactional

@ApplicationScoped
class UserRepository(
    private val _userRepository: PanacheUserRepository
) : IUserRepository {
    @Transactional
    override fun save(user: User) {
        _userRepository.save(user)
    }
    @Transactional
    override fun deleteById(id: UUID) {
        return _userRepository.deleteById(id)
    }
    override fun getById(id: UUID): User {
        return _userRepository.getById(id)
    }

    override fun getAll(): List<User> {
        return _userRepository.getAll()
    }

    @Transactional
    override fun update(user: User) {
        _userRepository.update(user)
    }
}