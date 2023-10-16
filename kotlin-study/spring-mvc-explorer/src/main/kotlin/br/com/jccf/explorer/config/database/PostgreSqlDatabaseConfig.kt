package br.com.jccf.explorer.config.database

import br.com.jccf.explorer.config.spring.SpringContext
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile
import org.springframework.jdbc.datasource.DriverManagerDataSource
import javax.sql.DataSource

@Configuration
@Profile(SpringContext.DEV)
class PostgreSqlDatabaseConfig {

    @Bean
    fun getDriver(): DataSource {
        val driverManager = DriverManagerDataSource()
        driverManager.setDriverClassName("org.postgresql.Driver")
        driverManager.url = "jdbc:postgres://localhost:5432/postgres"
        driverManager.username = "root"
        driverManager.password = "admin"

        return driverManager
    }
}
