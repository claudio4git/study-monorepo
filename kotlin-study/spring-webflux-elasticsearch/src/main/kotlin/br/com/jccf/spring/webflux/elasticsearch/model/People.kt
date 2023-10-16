package br.com.jccf.spring.webflux.elasticsearch.model

import java.util.UUID

data class People(
    val id: UUID,
    val name: String,
    val plainText: String
)