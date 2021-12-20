package me.nkremlev.kafka.producer.service.kafka

import me.nkremlev.kafka.producer.entity.KafkaSendInformation
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service
import java.io.File

@Service
class KafkaProducerServiceFileImpl(private val kafkaTemplateFile: KafkaTemplate<String, File>): KafkaProducerService<String, File> {

    override fun sendMessage(topicName: String, key: String?, data: File): KafkaSendInformation {
        val listenableFuture = if (key.isNullOrBlank()) kafkaTemplateFile.send(topicName, data)
            else kafkaTemplateFile.send(topicName, key, data)
        val result = listenableFuture.get()
        return KafkaSendInformation(
            result.recordMetadata.topic(),
            result.recordMetadata.offset(),
            result.recordMetadata.partition(),
            result.recordMetadata.serializedValueSize(),
            data.path
        )
    }
}