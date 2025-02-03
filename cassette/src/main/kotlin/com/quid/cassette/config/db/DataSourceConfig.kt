package com.quid.cassette.config.db

import com.zaxxer.hikari.HikariDataSource
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import org.springframework.jdbc.datasource.LazyConnectionDataSourceProxy
import javax.sql.DataSource

@Configuration
@EnableConfigurationProperties(DataSourceProperties::class)
class DataSourceConfig(
    private val dataSourceProperties: DataSourceProperties
) {

    @Bean
    @Primary
    fun dataSource(): DataSource {
        return LazyConnectionDataSourceProxy(mainDataSource()).apply {
            setReadOnlyDataSource(replicationDataSource())
        }
    }

    @Bean("mainDataSource")
    fun mainDataSource(): DataSource {
        val dataSourceInfo = dataSourceProperties.main
        return HikariDataSource().apply {
            jdbcUrl = dataSourceInfo.url
            username = dataSourceInfo.username
            password = dataSourceInfo.password
            driverClassName = dataSourceInfo.driverClassName
        }
    }

    @Bean("replicationDataSource")
    fun replicationDataSource(): DataSource {
        val dataSourceInfo = dataSourceProperties.replication
        return HikariDataSource().apply {
            jdbcUrl = dataSourceInfo.url
            username = dataSourceInfo.username
            password = dataSourceInfo.password
            driverClassName = dataSourceInfo.driverClassName
        }
    }
}
