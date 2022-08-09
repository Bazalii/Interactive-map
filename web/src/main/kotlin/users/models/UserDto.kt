package users.models

import java.util.*

class UserDto(){
    var name: String = ""
    var surname: String = ""
    var nickname: String = ""
    var password: String = ""
    var role: Role = Role.USER
    var id: UUID = UUID.randomUUID()
    constructor(name: String, surname: String, nickname: String, password: String, role: Role, id: UUID): this() {
        this.name = name
        this.surname = surname
        this.nickname = nickname
        this.password = password
        this.role = role
        this.id = id
    }
}

