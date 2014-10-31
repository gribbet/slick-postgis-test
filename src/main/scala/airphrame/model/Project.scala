package airphrame.model

import com.github.nscala_time.time.Imports._
import com.vividsolutions.jts.geom.MultiPolygon

case class Project(
  id: Option[Int] = None,
  createTime: DateTime = DateTime.now,
  updateTime: DateTime = DateTime.now,
  userId: Option[Int] = None,
  geometry: MultiPolygon) extends Model[Project] {

  def withId(id: Int) = copy(id = Some(id))

  def updated() = copy(updateTime = DateTime.now)
}
