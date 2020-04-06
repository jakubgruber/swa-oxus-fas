package me.jakub.fas.model.request

import java.math.BigDecimal

data class LoanRequest(

        val clientId: Int,
        val loanAmount: BigDecimal,
        val callbackUrl: String

)