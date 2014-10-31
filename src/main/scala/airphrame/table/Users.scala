package airphrame.table

import airphrame.model.User

import scala.slick.driver.PostgresDriver.simple._
import scala.slick.lifted.Tag

class Users(tag: Tag) extends ModelTable[User](tag, "user") {

  def name = column[String]("name", O.NotNull)

  def * = (id.?, name) <>(User.tupled, User.unapply)
}
