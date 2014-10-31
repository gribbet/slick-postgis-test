package airphrame.model

case class User(
  id: Option[Int] = None,
  name: String = "") extends Model[User] {

  def withId(id: Int) = copy(id = Some(id))
}
