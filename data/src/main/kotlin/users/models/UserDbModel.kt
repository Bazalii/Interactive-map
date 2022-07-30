package users.models

import java.util.*
import javax.persistence.Entity
import javax.persistence.Id

@Entity
class UserDbModel(
    var name: String = "",
    var surname: String = "",
    var nickname: String = "",
    var role: Role = Role.USER,
    @Id var id: UUID = UUID.randomUUID()
)