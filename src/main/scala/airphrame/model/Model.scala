package airphrame.model

trait Model[T] {
  val id: Option[Int]

  def withId(id: Int): T
}
