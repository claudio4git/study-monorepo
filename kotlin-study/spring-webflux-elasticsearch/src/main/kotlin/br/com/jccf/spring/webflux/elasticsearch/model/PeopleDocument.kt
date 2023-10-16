package br.com.jccf.spring.webflux.elasticsearch.model

import org.springframework.data.annotation.Id
import org.springframework.data.elasticsearch.annotations.Document
import java.util.UUID

@Document(indexName = "peoples")
data class PeopleDocument(
    @Id val id: UUID,
    val name: String,
    val plainText: String
)