package me.nkremlev.kafka.producer.config.api

import me.nkremlev.kafka.producer.api.v1.endpoint.kafka.file.KafkaProducerFileController
import me.nkremlev.kafka.producer.api.v1.endpoint.kafka.string.KafkaProducerStringController
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.PropertySource

@Configuration
@PropertySource("classpath:open-api-ui.properties")
@ComponentScan("me.nkremlev.kafka.producer")
class OpenApiUiConfiguration {

    companion object {
        private const val descriptionFile = "Приложения для локальной работы с kafka. Отправляет файл в kafka имитируя работу KK360"
        private const val descriptionString = "Приложения для локальной работы с kafka. Отправляет строку в kafka имитируя работу KK360"
    }

    @Bean
    fun clientFileV1() = defineOpenApi(
        group = "kafka-producer-dev-file",
        packageName = KafkaProducerFileController::class.java.`package`.name,
        version = "1",
        title = "Kafka-Producer-DEV-File",
        description = descriptionFile
    )

    @Bean
    fun clientStringV1() = defineOpenApi(
        group = "kafka-producer-dev-string",
        packageName = KafkaProducerStringController::class.java.`package`.name,
        version = "1",
        title = "Kafka-Producer-DEV-String",
        description = descriptionString
    )
}