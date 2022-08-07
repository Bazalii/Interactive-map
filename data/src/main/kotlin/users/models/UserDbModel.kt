package users.models

import io.quarkus.security.jpa.Password
import io.quarkus.security.jpa.Username
import java.util.*
import javax.json.bind.annotation.JsonbTransient
import javax.persistence.Entity
import javax.persistence.Id

@Entity
@javax.persistence.Table(name = "\"users\"")
class UserDbModel(
    var name: String = "",
    var surname: String = "",
    @Username
    var nickname: String = "",
    @Password
    @JsonbTransient
    var password: String = "",
    var role: Role = Role.USER,
    @Id var id: UUID = UUID.randomUUID()
)