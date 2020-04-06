package me.jakub.fas.service

import me.jakub.fas.model.result.OxusAppData
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate

@Component
class OxusLoanAppClient(private val restTemplate: RestTemplate) {

    private val logger = LoggerFactory.getLogger(this::class.java)

    @Value("\${oxus.loan.app.url}")
    private lateinit var oxusAppUrl: String

    fun pushData(data: OxusAppData) {
        logger.info("> pushData - {}", data)

        restTemplate.postForLocation("$oxusAppUrl/api/v1/loan", data)
    }

}