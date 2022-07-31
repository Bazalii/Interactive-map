package map.models

import java.util.*
import javax.persistence.Entity
import javax.persistence.Id

@Entity
@javax.persistence.Table(name = "\"tables\"")
data class TableDbModel(
    val coordinateX: Double = 0.0,
    val coordinateY: Double = 0.0,
    @Id val id: UUID = UUID.randomUUID(),
    val creator: String = "",
    val length: Int = 0,
    val width: Int = 0,
    val color: String = "",
)