package com.cicd.config

import com.cicd.data.entity.DataEntity
import com.cicd.data.repository.DataRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class DataInitializer(private val dataRepository: DataRepository) : CommandLineRunner {

    override fun run(vararg args: String?) {
        // 데이터가 없으면 초기 데이터 추가
        if (dataRepository.count() == 0L) {
            val initialData = listOf(
                DataEntity(name = "Kotlin"),
                DataEntity(name = "Spring Boot"),
                DataEntity(name = "DevOps"),
                DataEntity(name = "H2 Database"),
                DataEntity(name = "JUnit Test")
            )
            dataRepository.saveAll(initialData)
            println("✅ 초기 데이터 삽입 완료!")
        }
    }
}