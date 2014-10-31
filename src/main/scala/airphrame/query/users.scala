package airphrame.query

import airphrame.model.User
import airphrame.table.UserTable

object Users extends ModelTableQuery[User, UserTable](new UserTable(_))