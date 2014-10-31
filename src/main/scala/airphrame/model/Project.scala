package airphrame.model

case class Project(
  id: Option[Int] = None,
  userId: Option[Int] = None) extends Model[Project] {

  def withId(id: Int) = copy(id = Some(id))
}
