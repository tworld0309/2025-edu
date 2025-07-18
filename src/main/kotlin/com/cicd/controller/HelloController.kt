package com.cicd.controller

import io.swagger.v3.oas.annotations.Operation

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/hello")
class HelloController {

    @GetMapping
    @Operation(summary = "Hello API", description = "Hello World 메시지를 반환합니다.")
    fun hello(): String = "Hello, World!"
}