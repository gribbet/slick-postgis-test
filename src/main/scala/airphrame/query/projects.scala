package airphrame.query

import airphrame.model.Project
import airphrame.table.Projects

object projects extends ModelTableQuery[Project, Projects](new Projects(_))
