package airphrame.model

import com.github.nscala_time.time.Imports._
import com.vividsolutions.jts.geom.MultiPolygon

case class Project(
  id: Option[Long] = None,
  version: Int = 1,
  createTime: DateTime = DateTime.now,
  updateTime: DateTime = DateTime.now,
  userId: Option[Long] = None,
  geometry: MultiPolygon) extends Model[Project] {

  def withId(id: Long) = copy(id = Some(id))

  def updated() = copy(version = version + 1, updateTime = DateTime.now)
}
