package airphrame.table

import airphrame.model.Project
import airphrame.query.Users
import com.vividsolutions.jts.geom.MultiPolygon

import airphrame.slick.Driver.simple._
import scala.slick.lifted.Tag


class ProjectTable(tag: Tag) extends ModelTable[Project](tag, "project") {

  def userId = column[Int]("user_id", O.NotNull)

  def geometry = column[MultiPolygon]("geometry")

  def * = (id.?, userId.?, geometry) <>(Project.tupled, Project.unapply)

  def user = foreignKey("user_fk", userId, Users)(_.id)
}
