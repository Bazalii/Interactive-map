package users.models

import java.util.*
import javax.persistence.Entity

@Entity
class UserDbModel(
    var name: String = "",
    var surname: String = "",
    var nickname: String = "",
    var id: UUID = UUID.randomUUID()
)