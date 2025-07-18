package com.cicd.data.repository


import com.cicd.data.entity.DataEntity
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest

@DataJpaTest
class DataRepositoryTest {

    @Autowired
    private lateinit var dataRepository: DataRepository

    @BeforeEach
    fun setup() {
        dataRepository.deleteAll() // 기존 데이터 삭제
        val initialData = listOf(
            DataEntity(name = "Kotlin"),
            DataEntity(name = "Spring Boot"),
            DataEntity(name = "DevOps"),
            DataEntity(name = "H2 Database"),
            DataEntity(name = "JUnit Test")
        )
        dataRepository.saveAll(initialData)
    }

    @Test
    fun `초기 데이터가 올바르게 저장되었는지 확인`() {
        val dataList = dataRepository.findAll()
        assertEquals(5, dataList.size)

        val names = dataList.map { it.name }
        assertTrue(names.contains("Kotlin"))
        assertTrue(names.contains("Spring Boot"))
        assertTrue(names.contains("DevOps"))
        assertTrue(names.contains("H2 Database"))
        assertTrue(names.contains("JUnit Test"))
    }
}