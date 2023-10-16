package br.com.jccf.core.todo.dto

import java.time.LocalDateTime
import java.util.UUID

data class TodoResponse(
    var id: UUID?,
    var name: String,
    var createdAt: LocalDateTime?
) {
    constructor(): this(null, "", null)
}
