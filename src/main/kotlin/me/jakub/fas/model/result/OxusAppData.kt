package me.jakub.fas.model.result

import java.math.BigDecimal

data class OxusAppData(

        val clientId: Int,
        val loanAmount: BigDecimal,
        val result: String

)