package airphrame.model

import com.github.nscala_time.time.Imports._

trait Model[T] {
  val id: Option[Long]
  val version: Int
  val createTime: DateTime
  val updateTime: DateTime

  def withId(id: Long): T

  def updated(): T
}
