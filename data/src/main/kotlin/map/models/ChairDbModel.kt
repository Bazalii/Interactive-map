package map.models

import java.util.*
import javax.persistence.Entity
import javax.persistence.Id

@Entity
@javax.persistence.Table(name = "\"chairs\"")
data class ChairDbModel(
    var coordinateX: Double = 0.0,
    var coordinateY: Double = 0.0,
    @Id var id: UUID = UUID.fromString("00000000-0000-0000-0000-000000000000"),
    val creator: String = "",
    var height: Int = 0,
    val legsAmount: Int = 0,
)