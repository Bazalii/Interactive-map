package users.models

import java.util.UUID

class User(
    val name: String,
    val surname: String,
    val nickname: String,
    val id: UUID
)