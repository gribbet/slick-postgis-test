package airphrame.model

import com.vividsolutions.jts.geom.MultiPolygon

case class Project(
  id: Option[Int] = None,
  userId: Option[Int] = None,
  geometry: MultiPolygon) extends Model[Project] {

  def withId(id: Int) = copy(id = Some(id))
}
