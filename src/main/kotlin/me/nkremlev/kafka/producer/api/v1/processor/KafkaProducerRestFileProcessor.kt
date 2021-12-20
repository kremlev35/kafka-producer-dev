package me.nkremlev.kafka.producer.api.v1.processor

import me.nkremlev.kafka.producer.api.common.*
import me.nkremlev.kafka.producer.api.common.dto.KafkaSendDtoRs
import me.nkremlev.kafka.producer.api.common.dto.builder.KafkaProducerRsBuilder
import me.nkremlev.kafka.producer.config.property.AppProperties
import me.nkremlev.kafka.producer.service.kafka.KafkaProducerService
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import java.io.File

@Service
class KafkaProducerRestFileProcessor(
    private val kafkaProducerServiceFile: KafkaProducerService<String, File>,
    private val kafkaProducerRsBuilder: KafkaProducerRsBuilder,
    private val properties: AppProperties
): KafkaProducerRestProcessor<File> {

    companion object {
        private val PRIMARY_PATH = "$JSON_FOLDER_PATH$PRIMARY_JSON_PATH"
        private val INCREMENT_PATH = "$JSON_FOLDER_PATH$INCREMENT_JSON_PATH"
    }

    override suspend fun sendPrimaryInKafka(): ResponseEntity<KafkaSendDtoRs> {
        return ResponseEntity.ok(kafkaProducerRsBuilder.builderKafkaSendDtoRs(
            kafkaProducerServiceFile.sendMessage(properties.topicPrimary, null, File(PRIMARY_PATH))))
    }

    override suspend fun sendIncrementInKafka(): ResponseEntity<KafkaSendDtoRs> {
        return ResponseEntity.ok(kafkaProducerRsBuilder.builderKafkaSendDtoRs(
            kafkaProducerServiceFile.sendMessage(properties.topicIncrement, null, File(INCREMENT_PATH))))
    }
}