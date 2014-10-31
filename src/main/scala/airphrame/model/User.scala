package airphrame.model

import com.github.nscala_time.time.Imports._

case class User(
  id: Option[Int] = None,
  createTime: DateTime = DateTime.now,
  updateTime: DateTime = DateTime.now,
  name: String = "") extends Model[User] {

  def withId(id: Int) = copy(id = Some(id))

  def updated() = copy(updateTime = DateTime.now)
}
