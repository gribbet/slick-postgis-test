package airphrame.table

import airphrame.model.Project
import airphrame.query.users

import scala.slick.driver.PostgresDriver.simple._
import scala.slick.lifted.Tag

class Projects(tag: Tag) extends ModelTable[Project](tag, "project") {

  def userId = column[Int]("user_id", O.NotNull)

  def user = foreignKey("user_fk", userId, users)(_.id)

  def * = (id.?, userId.?) <>(Project.tupled, Project.unapply)
}
