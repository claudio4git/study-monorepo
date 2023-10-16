package br.com.jccf.core.task.port

import br.com.jccf.core.task.dto.TaskEntity

interface TaskPersistPort {
    fun insert(entity: TaskEntity)
}
