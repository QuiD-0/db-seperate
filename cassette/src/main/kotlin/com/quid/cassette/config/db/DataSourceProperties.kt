package com.quid.cassette.config.db

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "datasource")
data class DataSourceProperties(
    val main: DataSourceInfo,
    val replication: DataSourceInfo
)

data class DataSourceInfo(
    val url: String,
    val username: String,
    val password: String,
    val driverClassName: String
)
