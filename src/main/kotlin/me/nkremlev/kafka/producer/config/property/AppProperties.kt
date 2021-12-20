package me.nkremlev.kafka.producer.config.property

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

@ConstructorBinding
@ConfigurationProperties(prefix = "spring.kafka.topics")
data class AppProperties(
    val topicPrimary: String,
    val topicIncrement: String
)