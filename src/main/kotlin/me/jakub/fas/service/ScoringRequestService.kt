package me.jakub.fas.service

import me.jakub.fas.model.request.LoanRequestDTO
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service


@Service
class ScoringRequestService(private val kafkaTemplate: KafkaTemplate<String, Any>) {

    private val logger: Logger = LoggerFactory.getLogger(this::class.java)

    @Value("\${fas.kafka.topic.scoringrequest}")
    lateinit var kafkaTopic: String

    fun scoreCustomer(request: LoanRequestDTO) {
        logger.debug("> scoreCustomer - sending {}", request)

        kafkaTemplate.send(kafkaTopic, request)
    }

}