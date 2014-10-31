package airphrame

import airphrame.model.{Project, User}
import airphrame.query.{Projects, Users}
import airphrame.slick.Driver.simple._
import com.vividsolutions.jts.geom._
import com.vividsolutions.jts.geom.impl.CoordinateArraySequence

object Main extends App {
  lazy val db = Database.forURL(
    url = "jdbc:postgresql://test.c7ssmrrxqzim.us-west-1.rds.amazonaws.com:5432",
    user = "test",
    password = "testtest",
    driver = "org.postgresql.Driver")

  db.withSession { implicit session =>
    (Users.ddl ++ Projects.ddl).create

    val john = Users.save(User(name = "John Doe"))
    val factory = new GeometryFactory(new PrecisionModel(), 4326)
    val geometry = new MultiPolygon(Array(
      new Polygon(
        new LinearRing(
          new CoordinateArraySequence(Array(
            new Coordinate(-122.3, 37.0),
            new Coordinate(-122.2, 37.1),
            new Coordinate(-122.1, 37.0),
            new Coordinate(-122.3, 37.0))), factory),
        Array[LinearRing](), factory)), factory)
    val project = Projects.save(Project(userId = john.id, geometry = geometry))
    println(project)

    println(Projects.filter(_.id === 1l).map(_.geometry).map(_.boundary).run)

    println(john)

    println(Users.save(john.copy(name = "Jon Doe")))
    println(Users.save(john.copy(name = "Jon Doe 2")))

    (Users.ddl ++ Projects.ddl).drop
  }
}