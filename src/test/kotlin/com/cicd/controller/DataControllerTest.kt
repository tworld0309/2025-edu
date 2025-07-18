package com.cicd.controller

import com.cicd.data.dto.DataReqDto
import com.cicd.data.dto.DataResDto
import com.cicd.service.DataService
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.Mockito.*
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class DataControllerTest {

    private lateinit var dataService: DataService
    private lateinit var dataController: DataController

    @BeforeEach
    fun setup() {
        dataService = mock(DataService::class.java)
        dataController = DataController(dataService)

        val dummyData = listOf(DataResDto(id = 1, name = "Test"))
        `when`(dataService.getAllData()).thenReturn(dummyData)
    }

    @Test
    fun `GET 요청으로 데이터 목록 조회`() {
        val result = dataController.getAllData()
        assertEquals(1, result.size)
        assertEquals("Test", result[0].name)
    }

    @Test
    fun `POST 요청으로 데이터 추가`() {
        val reqDto = DataReqDto(name = "New Data")
        val resDto = DataResDto(id = 2, name = "New Data")
        `when`(dataService.saveData(reqDto)).thenReturn(resDto)

        val result = dataController.createData(reqDto)
        assertEquals("New Data", result.name)
    }
}