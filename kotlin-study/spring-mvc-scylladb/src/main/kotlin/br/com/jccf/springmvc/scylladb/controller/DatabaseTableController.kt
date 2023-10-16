package br.com.jccf.springmvc.scylladb.controller

import com.datastax.oss.driver.api.core.CqlSession
import org.springframework.data.cassandra.core.cql.CqlTemplate
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/catalog")
class DatabaseTableController(
    val cqlTemplate: CqlTemplate
) {

    @GetMapping("/stax")
    fun fromDatastax(): String {

        val session: CqlSession? = try {
            CqlSession.builder()
                .build()
        } catch (e: Exception) { null }

        session?.execute("select * from catalog.mutant_data")
            ?.forEach { println(it.getString("first_name")) }

        return "Scylla with DataStax"
    }

    @GetMapping("/spring")
    fun fromSpringDataCassandra(): String {

        cqlTemplate.queryForList("select * from catalog.mutant_data")
            .forEach { println(it["first_name"]) }

        return "Scylla with Spring"
    }
}
