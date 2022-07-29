package users.models

import java.util.UUID

data class User(
    val name: String,
    val surname: String,
    var nickname: String,
    var role: Role = Role.USER,
    val id: UUID = UUID.randomUUID()
)