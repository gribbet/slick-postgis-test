package airphrame.table

import airphrame.slick.Driver.simple._
import com.github.nscala_time.time.Imports._

abstract class ModelTable[T](tag: Tag, tableName: String) extends Table[T](tag, tableName) {
  def id = column[Int]("id", O.PrimaryKey, O.AutoInc)

  def createTime = column[DateTime]("create_time", O.NotNull)

  def updateTime = column[DateTime]("update_time", O.NotNull)
}
