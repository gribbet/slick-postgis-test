package airphrame.query

import airphrame.model.Model
import airphrame.table.ModelTable

import scala.slick.driver.H2Driver.simple._
import scala.slick.jdbc.JdbcBackend
import scala.slick.lifted.{TableQuery, Tag}

abstract class ModelTableQuery[ModelType <: Model[ModelType], ModelTableType <: ModelTable[ModelType]](cons: Tag => ModelTableType) extends TableQuery[ModelTableType](cons) {
  def find(id: Int)(implicit session: JdbcBackend#Session) =
    filter(_.id === id).firstOption

  def save(model: ModelType)(implicit session: JdbcBackend#Session) =
    model.id match {
      case None => insert(model)
      case Some(_) => update(model)
    }

  private def insertAndReturnId(model: ModelType)(implicit session: JdbcBackend#Session): Int =
    (this returning map(_.id)) += model

  private def insert(model: ModelType)(implicit session: JdbcBackend#Session): ModelType =
    model.withId(insertAndReturnId(model))

  private def update(model: ModelType)(implicit session: JdbcBackend#Session): ModelType = {
    filter(_.id === model.id).update(model)
    model
  }
}
