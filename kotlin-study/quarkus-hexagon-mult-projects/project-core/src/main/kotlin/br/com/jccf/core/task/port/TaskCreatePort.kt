package br.com.jccf.core.task.port

import br.com.jccf.core.task.dto.TaskRequest
import br.com.jccf.core.task.dto.TaskResponse

interface TaskCreatePort {
    fun create(request: TaskRequest): TaskResponse
}
