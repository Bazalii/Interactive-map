package users.extensions

import users.models.User
import users.models.UserDbModel

fun UserDbModel.toUser() = User(
    name,
    surname,
    nickname,
    role,
    id
)