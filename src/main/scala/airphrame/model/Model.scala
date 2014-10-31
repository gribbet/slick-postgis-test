package airphrame.model
import com.github.nscala_time.time.Imports._

trait Model[T] {
  val id: Option[Int]
  val createTime: DateTime
  val updateTime: DateTime

  def withId(id: Int): T
  def updated(): T
}
