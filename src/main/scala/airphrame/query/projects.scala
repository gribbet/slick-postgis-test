package airphrame.query

import airphrame.model.Project
import airphrame.table.ProjectTable

object Projects extends ModelTableQuery[Project, ProjectTable](new ProjectTable(_))
