package br.com.jccf.core.task.dto

data class TaskRequest(
    var name: String
) {
    constructor(): this("")
}
