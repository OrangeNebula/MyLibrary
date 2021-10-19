import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class Book(
    val title: String,
    val summary: String,
    val content: String,
    @ManyToOne @JoinColumn val author: User,
    @Id @GeneratedValue val id: Long? = null,
    val addedAt: LocalDateTime = LocalDateTime.now()
)

@Entity
data class User(
   @Id val login: String,
   val name: String,
)
