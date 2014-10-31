package airphrame.table

import airphrame.model.Project
import airphrame.query.Users
import airphrame.slick.Driver.simple._
import com.vividsolutions.jts.geom.MultiPolygon

import scala.slick.lifted.Tag


class ProjectTable(tag: Tag) extends ModelTable[Project](tag, "project") {

  def userId = column[Long]("user_id", O.NotNull)

  def geometry = column[MultiPolygon]("geometry", O.NotNull)

  def * = (id.?, version, createTime, updateTime, userId.?, geometry) <>(Project.tupled, Project.unapply)

  def user = foreignKey("user_fk", userId, Users)(_.id)
}
