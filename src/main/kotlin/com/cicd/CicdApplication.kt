package com.cicd

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication(scanBasePackages = ["com.cicd"])
class CicdApplication

fun main(args: Array<String>) {
    runApplication<CicdApplication>(*args)
}
