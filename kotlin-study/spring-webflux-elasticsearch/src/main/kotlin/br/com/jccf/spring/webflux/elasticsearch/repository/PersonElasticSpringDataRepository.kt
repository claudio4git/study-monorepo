package br.com.jccf.spring.webflux.elasticsearch.repository

import br.com.jccf.spring.webflux.elasticsearch.model.PeopleDocument
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository
import org.springframework.stereotype.Repository

@Repository
interface PersonElasticSpringDataRepository : ElasticsearchRepository<PeopleDocument, String>