package br.com.jccf.core.task.dto

import java.time.LocalDateTime
import java.util.UUID

data class TaskResponse(
    val id: UUID?,
    val name: String,
    val createdAt: LocalDateTime?
) {
    constructor(): this(null, "", null)
}
