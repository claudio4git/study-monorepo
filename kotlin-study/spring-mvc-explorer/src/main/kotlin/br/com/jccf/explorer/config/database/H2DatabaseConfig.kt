package br.com.jccf.explorer.config.database

import br.com.jccf.explorer.config.spring.SpringContext
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType

@Configuration
@Profile(SpringContext.TEST)
class H2DatabaseConfig {

    @Bean
    fun getDataSource(): EmbeddedDatabase = EmbeddedDatabaseBuilder()
        .generateUniqueName(true)
        .setType(EmbeddedDatabaseType.H2)
        .setScriptEncoding("UTF-8")
        .setSeparator("\n\r")
        .build()
}
