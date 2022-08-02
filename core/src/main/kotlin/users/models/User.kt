package users.models

import io.quarkus.security.jpa.Password
import io.quarkus.security.jpa.Roles
import io.quarkus.security.jpa.UserDefinition
import io.quarkus.security.jpa.Username
import java.util.UUID
import javax.json.bind.annotation.JsonbTransient
import javax.persistence.*

@Entity
@Table(name = "users")
@UserDefinition
data class User(
    @Column(name = "name", nullable = false)
    val name: String,

    @Column(name = "surname", nullable = false)
    val surname: String,

    @Column(name = "nickname", nullable = false)
    @Username
    var nickname: String,

    @Column(name = "password", nullable = false)
    @Password
    @JsonbTransient
    var password: String,

    @Column(name = "role", nullable = false)
    @Roles
    var role: Role = Role.USER,

    @Column(name = "id", nullable = false)
    @Id
    val id: UUID = UUID.randomUUID()
)



