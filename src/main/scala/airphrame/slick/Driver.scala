package airphrame.slick

import com.github.tminglei.slickpg.PgPostGISSupport

import scala.slick.driver.PostgresDriver

object Driver extends PostgresDriver with PgPostGISSupport {

  override lazy val Implicit = new Implicits with PostGISImplicits
  override val simple = new Implicits with SimpleQL with PostGISImplicits
    with PostGISAssistants
}
