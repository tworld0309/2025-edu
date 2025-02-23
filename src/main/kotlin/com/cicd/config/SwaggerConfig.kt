package com.cicd.config

import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import io.swagger.v3.oas.models.info.License
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class OpenAPIConfig {

    @Bean
    fun customOpenAPI(): OpenAPI {
        return OpenAPI()
            .info(
                Info()
                    .title("CI/CD 파이프라인 교육용 Backend")
                    .version("1.0.0")
                    .description("Spring Boot 3 + Kotlin + H2 + Swagger API 문서")
                    .license(License().name("Apache 2.0").url("http://springdoc.org"))
            )
    }
}