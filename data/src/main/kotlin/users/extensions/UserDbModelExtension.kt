package users.extensions

import users.models.User
import users.models.UserDbModel

fun UserDbModel.toUser() = User(
    this.name,
    this.surname,
    this.nickname,
    this.id
)