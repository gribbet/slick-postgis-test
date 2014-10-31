package airphrame.table

import airphrame.slick.Driver.simple._

abstract class ModelTable[T](tag: Tag, tableName: String) extends Table[T](tag, tableName) {
  def id = column[Int]("id", O.PrimaryKey, O.AutoInc)
}
