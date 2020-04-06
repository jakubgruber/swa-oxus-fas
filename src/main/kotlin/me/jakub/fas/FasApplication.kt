package me.jakub.fas

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class FasApplication

fun main(args: Array<String>) {
    runApplication<FasApplication>(*args)
}
