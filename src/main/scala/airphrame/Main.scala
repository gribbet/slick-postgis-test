package airphrame

import airphrame.model.{Project, User}
import airphrame.query.{projects, users}

import scala.slick.driver.PostgresDriver.simple._

object Main extends App {
  val db = Database.forURL(
    url = "jdbc:postgresql://test.c7ssmrrxqzim.us-west-1.rds.amazonaws.com:5432",
    user = "test",
    password ="testtest",
    driver = "org.postgresql.Driver")

  db.withSession { implicit session =>
    (users.ddl ++ projects.ddl).create
    
    val john = users.save(User(name = "John Doe"))
    val project = projects.save(Project(userId = john.id))
    println(project)

    println(users.save(john.copy(name = "Jon Doe")))

    (users.ddl ++ projects.ddl).drop
  }
}