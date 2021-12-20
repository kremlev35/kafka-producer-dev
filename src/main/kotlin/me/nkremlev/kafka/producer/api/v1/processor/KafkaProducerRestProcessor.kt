package me.nkremlev.kafka.producer.api.v1.processor

import me.nkremlev.kafka.producer.api.common.dto.KafkaSendDtoRs
import org.springframework.http.ResponseEntity

interface KafkaProducerRestProcessor<T> {

    /**
     *  Отправить файл первичной выгрузки в kafka
     */
    suspend fun sendPrimaryInKafka(): ResponseEntity<KafkaSendDtoRs>

    /**
     * Отправить файл выгрузки инкремента в kafka
     */
    suspend fun sendIncrementInKafka(): ResponseEntity<KafkaSendDtoRs>
}