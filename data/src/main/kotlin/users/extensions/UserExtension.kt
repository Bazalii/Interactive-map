package users.extensions

import users.models.User
import users.models.UserDbModel

fun User.toUserDbModel() = UserDbModel(
    this.name,
    this.surname,
    this.nickname,
    this.id
)
