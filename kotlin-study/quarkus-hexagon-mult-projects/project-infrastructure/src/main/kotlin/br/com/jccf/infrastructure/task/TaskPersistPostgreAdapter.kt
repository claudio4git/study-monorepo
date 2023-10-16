package br.com.jccf.infrastructure.task

import br.com.jccf.core.task.dto.TaskEntity
import br.com.jccf.core.task.port.TaskPersistPort
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import javax.sql.DataSource

class TaskPersistPostgreAdapter(
    dataSource: DataSource
): TaskPersistPort {

    private val namedTemplate = NamedParameterJdbcTemplate(dataSource)

    override fun insert(entity: TaskEntity) {
        val command = """
            INSERT INTO tasks(id, name, created_at)
            VALUES(:id, :name, :createdAt)
        """.trimIndent()

        val parameters = MapSqlParameterSource()
            .addValue("id", entity.id)
            .addValue("name", entity.name)
            .addValue("createdAt", entity.createdAt)

        namedTemplate.update(command, parameters)
    }
}
