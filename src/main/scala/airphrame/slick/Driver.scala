package airphrame.slick

import java.sql.Timestamp

import com.github.tminglei.slickpg.PgPostGISSupport
import org.joda.time.DateTime

import scala.slick.driver.PostgresDriver

object Driver extends PostgresDriver with PgPostGISSupport {

  override lazy val Implicit = new Implicits with PostGISImplicits
  
  override val simple = new Implicits with SimpleQL with PostGISImplicits with PostGISAssistants {

    implicit val dateTimeType = MappedColumnType.base[DateTime, Timestamp](
      dateTime => new Timestamp(dateTime.getMillis()),
      timestamp => new DateTime(timestamp.getTime()))
  }
}
