package me.nkremlev.kafka.producer.api.v1.endpoint.kafka.string

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.tags.Tag
import me.nkremlev.kafka.producer.api.common.INCREMENT_DEFAULT_MESSAGE_STRING
import me.nkremlev.kafka.producer.api.common.KAFKA_APPLICATION_PATH
import me.nkremlev.kafka.producer.api.common.PRIMARY_DEFAULT_MESSAGE_STRING
import me.nkremlev.kafka.producer.api.common.dto.KafkaSendDtoRs
import me.nkremlev.kafka.producer.api.v1.processor.KafkaProducerRestProcessor
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(KAFKA_APPLICATION_PATH, produces = [MediaType.APPLICATION_JSON_VALUE])
@Tag(name = "Kafka-Producer String", description = "Отправка в кафку строковых сообщений")
class KafkaProducerStringController(
    private val kafkaProducerRestProcessor: KafkaProducerRestProcessor<String>
) {

    @Operation(
        summary = "Отправить в кафку готовую строку для первичной выгрузки",
        description = "Отправить в кафку готовую строку для первичной выгрузки",
        responses = [
            ApiResponse(responseCode = "200", description = "Успешное отправление")
        ]
    )
    @GetMapping(PRIMARY_DEFAULT_MESSAGE_STRING)
    suspend fun sendKafkaPrimaryDefaultStringMessage(): ResponseEntity<KafkaSendDtoRs> {
        return kafkaProducerRestProcessor.sendPrimaryInKafka()
    }

    @Operation(
        summary = "Отправить в кафку готовую строку для выгрузки инкремента",
        description = "Отправить в кафку готовую строку для выгрузки инкремента",
        responses = [
            ApiResponse(responseCode = "200", description = "Успешное отправление")
        ]
    )
    @GetMapping(INCREMENT_DEFAULT_MESSAGE_STRING)
    suspend fun sendKafkaIncrementDefaultStringMessage(): ResponseEntity<KafkaSendDtoRs> {
        return kafkaProducerRestProcessor.sendIncrementInKafka()
    }
}