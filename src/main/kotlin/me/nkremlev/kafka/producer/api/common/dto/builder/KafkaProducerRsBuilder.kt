package me.nkremlev.kafka.producer.api.common.dto.builder

import me.nkremlev.kafka.producer.api.common.dto.KafkaSendDtoRs
import me.nkremlev.kafka.producer.entity.KafkaSendInformation
import org.springframework.stereotype.Service

@Service
class KafkaProducerRsBuilder {

    fun builderKafkaSendDtoRs(kafkaSendInformation: KafkaSendInformation): KafkaSendDtoRs {
        return KafkaSendDtoRs(
            kafkaSendInformation.topicName,
            kafkaSendInformation.offset,
            kafkaSendInformation.partition,
            kafkaSendInformation.valueSize,
            kafkaSendInformation.data
        )
    }
}