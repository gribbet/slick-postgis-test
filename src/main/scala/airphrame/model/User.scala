package airphrame.model

import com.github.nscala_time.time.Imports._

case class User(
  id: Option[Long] = None,
  version: Int = 1,
  createTime: DateTime = DateTime.now,
  updateTime: DateTime = DateTime.now,
  name: String = "") extends Model[User] {

  def withId(id: Long) = copy(id = Some(id))

  def updated() = copy(version = version + 1, updateTime = DateTime.now)
}
