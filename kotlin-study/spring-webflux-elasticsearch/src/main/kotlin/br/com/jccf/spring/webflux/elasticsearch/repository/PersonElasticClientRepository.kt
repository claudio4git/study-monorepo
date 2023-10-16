package br.com.jccf.spring.webflux.elasticsearch.repository

import br.com.jccf.spring.webflux.elasticsearch.model.People
import br.com.jccf.spring.webflux.elasticsearch.model.PeopleDocument
import kotlinx.coroutines.reactive.awaitFirst
import org.elasticsearch.action.get.GetRequest
import org.elasticsearch.action.index.IndexRequest
import org.elasticsearch.action.support.WriteRequest
import org.elasticsearch.common.xcontent.XContentType
import org.springframework.data.elasticsearch.client.reactive.ReactiveElasticsearchClient
import org.springframework.data.elasticsearch.core.ReactiveElasticsearchTemplate
import org.springframework.stereotype.Repository
import reactor.core.publisher.Mono
import java.util.UUID

@Repository
class PersonElasticClientRepository(
    private val restHighLevelClient: ReactiveElasticsearchClient,
    private val elasticsearchTemplate: ReactiveElasticsearchTemplate
) {

    suspend fun save(people: People): Mono<People> {
        val indexPeople = IndexRequest("peoples")
            .id(people.id.toString())
            .source(people, XContentType.JSON)
            .setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE)

        val indexResponse = restHighLevelClient.index(indexPeople)

        val getPeople = GetRequest("peoples", people.id.toString())
        getPeople.storedFields("id", "name", "plainText")

        val getResult = restHighLevelClient.get(getPeople)
        val results = getResult.awaitFirst().sourceAsMap()
        println(results)

        return Mono.just(People(
            id = UUID.fromString(indexResponse.awaitFirst().id),
            name = "test",
            plainText = "test")
        )
    }

    suspend fun save(people: PeopleDocument): Mono<PeopleDocument> {
        return elasticsearchTemplate.save(people)
    }

    suspend fun retrieve(id: UUID): Mono<PeopleDocument> {
        return elasticsearchTemplate.get(id.toString(), PeopleDocument::class.java)
    }
}