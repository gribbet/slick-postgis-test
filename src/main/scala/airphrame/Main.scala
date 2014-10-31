package airphrame

import airphrame.model.{Project, User}
import airphrame.query.{projects, users}

import scala.slick.driver.H2Driver.simple._

object Main extends App {
  val db = Database.forURL("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1", driver = "org.h2.Driver")

  db.withSession { implicit session =>
    (users.ddl ++ projects.ddl).create
    val john = users.save(User(name = "John Doe"))
    val project = projects.save(Project(userId = john.id))
    println(project)

    println(users.save(john.copy(name = "Jon Doe")))
  }
}