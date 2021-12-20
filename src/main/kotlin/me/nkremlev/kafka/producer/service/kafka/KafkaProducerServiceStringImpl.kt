package me.nkremlev.kafka.producer.service.kafka

import me.nkremlev.kafka.producer.entity.KafkaSendInformation
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service

@Service
class KafkaProducerServiceStringImpl(private val kafkaTemplateString: KafkaTemplate<String, String>): KafkaProducerService<String, String> {

    override fun sendMessage(topicName: String, key: String?, data: String): KafkaSendInformation {
        val listenableFuture = if (key.isNullOrBlank()) kafkaTemplateString.send(topicName, data)
            else kafkaTemplateString.send(topicName, key, data)
        val result = listenableFuture.get()
        return KafkaSendInformation(
            result.recordMetadata.topic(),
            result.recordMetadata.offset(),
            result.recordMetadata.partition(),
            result.recordMetadata.serializedValueSize(),
            data
        )
    }
}