package br.com.jccf.core.todo.dto

data class TodoRequest(
    var name: String
) {
    constructor(): this("")
}
