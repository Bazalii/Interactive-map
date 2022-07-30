package users.extensions

import users.models.User
import users.models.UserDbModel

fun User.toUserDbModel() = UserDbModel(
    name,
    surname,
    nickname,
    role,
    id
)
