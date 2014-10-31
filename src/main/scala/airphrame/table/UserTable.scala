package airphrame.table

import airphrame.model.User
import airphrame.slick.Driver.simple._

import scala.slick.lifted.Tag

class UserTable(tag: Tag) extends ModelTable[User](tag, "user") {

  def name = column[String]("name", O.NotNull)

  def * = (id.?, version, createTime, updateTime, name) <>(User.tupled, User.unapply)
}
