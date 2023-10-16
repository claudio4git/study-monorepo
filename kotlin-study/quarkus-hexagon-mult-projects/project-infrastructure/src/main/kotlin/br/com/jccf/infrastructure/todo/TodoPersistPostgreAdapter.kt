package br.com.jccf.infrastructure.todo

import br.com.jccf.core.todo.dto.TodoEntity
import br.com.jccf.core.todo.port.TodoPersistPort
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import javax.sql.DataSource

class TodoPersistPostgreAdapter(
    dataSource: DataSource
): TodoPersistPort {

    private val namedTemplate = NamedParameterJdbcTemplate(dataSource)

    override fun insert(entity: TodoEntity) {
        val command = """
            INSERT INTO todos(id, name, created_at)
            VALUES(:id, :name, :createdAt)
        """.trimIndent()

        val parameters = MapSqlParameterSource()
            .addValue("id", entity.id)
            .addValue("name", entity.name)
            .addValue("createdAt", entity.createdAt)

        namedTemplate.update(command, parameters)
    }
}
