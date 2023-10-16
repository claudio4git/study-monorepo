package br.com.jccf.springmvc.scylladb.config

import com.datastax.oss.driver.api.core.CqlSession
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.cassandra.core.cql.CqlTemplate

@Configuration
class CassandraConfig {

    @Bean
    fun getSession() = CqlSession.builder().withLocalDatacenter("datacenter1").build()

    @Bean
    fun getCqlTemplate() = CqlTemplate(getSession())
}
