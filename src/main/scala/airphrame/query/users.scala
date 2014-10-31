package airphrame.query

import airphrame.model.User
import airphrame.table.Users

object users extends ModelTableQuery[User, Users](new Users(_))