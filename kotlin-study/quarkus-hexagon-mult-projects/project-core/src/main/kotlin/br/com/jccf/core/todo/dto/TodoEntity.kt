package br.com.jccf.core.todo.dto

import java.time.LocalDateTime
import java.util.UUID

data class TodoEntity(
    val id: UUID,
    val name: String,
    val createdAt: LocalDateTime? = null
)
