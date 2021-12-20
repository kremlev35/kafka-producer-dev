package me.nkremlev.kafka.producer.config.kafka

import org.apache.kafka.clients.producer.ProducerConfig
import org.apache.kafka.common.serialization.StringSerializer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.annotation.EnableKafka
import org.springframework.kafka.core.DefaultKafkaProducerFactory
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.kafka.core.ProducerFactory
import org.springframework.kafka.support.serializer.JsonSerializer
import java.io.File

@Configuration
@EnableKafka
class KafkaConfig {

    companion object {
        private const val BOOTSTRAP_SERVERS = "localhost:9092"
        private val KEY_SERIALIZER = StringSerializer::class.java
        private const val RETRIES = 2
    }

    private val senderFileProps = mapOf(
        ProducerConfig.BOOTSTRAP_SERVERS_CONFIG to BOOTSTRAP_SERVERS,
        ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG to KEY_SERIALIZER,
        ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG to JsonSerializer::class.java,
        ProducerConfig.RETRIES_CONFIG to RETRIES
    )

    private val senderStringProps = mapOf(
        ProducerConfig.BOOTSTRAP_SERVERS_CONFIG to BOOTSTRAP_SERVERS,
        ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG to KEY_SERIALIZER,
        ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG to StringSerializer::class.java,
        ProducerConfig.RETRIES_CONFIG to RETRIES
    )

    @Bean
    fun producerFileFactory() = DefaultKafkaProducerFactory<String, File>(senderFileProps)

    @Bean
    fun producerStringFactory() = DefaultKafkaProducerFactory<String, String>(senderStringProps)

    @Bean
    fun kafkaTemplateFile(producerFileFactory: ProducerFactory<String, File>) = KafkaTemplate(producerFileFactory)

    @Bean
    fun kafkaTemplateString(producerStringFactory: ProducerFactory<String, String>) = KafkaTemplate(producerStringFactory)
}