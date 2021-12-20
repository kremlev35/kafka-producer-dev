package me.nkremlev.kafka.producer.api.v1.endpoint.kafka.file

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.tags.Tag
import me.nkremlev.kafka.producer.api.common.*
import me.nkremlev.kafka.producer.api.common.dto.KafkaSendDtoRs
import me.nkremlev.kafka.producer.api.v1.processor.KafkaProducerRestProcessor
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.io.File

@RestController
@RequestMapping(KAFKA_APPLICATION_PATH, produces = [MediaType.APPLICATION_JSON_VALUE])
@Tag(name = "Kafka-Producer File", description = "Отправка в кафку файлов")
class KafkaProducerFileController(
    private val kafkaProducerRestProcessor: KafkaProducerRestProcessor<File>
) {

    @Operation(
        summary = "Отправить в кафку готовый файл для первичной выгрузки",
        description = "Отправить в кафку готовый файл для первичной выгрузки",
        responses = [
            ApiResponse(responseCode = "200", description = "Успешное отправление")
        ]
    )
    @GetMapping(PRIMARY_DEFAULT_MESSAGE_FILE_PATH)
    suspend fun sendKafkaPrimaryDefaultFileMessage(): ResponseEntity<KafkaSendDtoRs> {
        return kafkaProducerRestProcessor.sendPrimaryInKafka()
    }

    @Operation(
        summary = "Отправить в кафку готовый файл для выгрузки инкремента",
        description = "Отправить в кафку готовый файл для выгрузки инкремента",
        responses = [
            ApiResponse(responseCode = "200", description = "Успешное отправление")
        ]
    )
    @GetMapping(INCREMENT_DEFAULT_MESSAGE_FILE_PATH)
    suspend fun sendKafkaIncrementDefaultFileMessage(): ResponseEntity<KafkaSendDtoRs> {
        return kafkaProducerRestProcessor.sendIncrementInKafka()
    }

}