package com.cicd.controller
import com.cicd.data.dto.DataResDto
import com.cicd.data.dto.DataReqDto
import com.cicd.service.DataService
import org.springframework.web.bind.annotation.*
import io.swagger.v3.oas.annotations.Operation
import jakarta.validation.Valid


@RestController
@RequestMapping("/data")
class DataController(private val dataService: DataService) {

    @Operation(summary = "모든 데이터 조회", description = "저장된 모든 데이터를 DTO로 변환하여 반환합니다.")
    @GetMapping
    fun getAllData(): List<DataResDto> = dataService.getAllData()

    @Operation(summary = "데이터 추가", description = "새로운 데이터를 추가하고 DTO로 반환합니다.")
    @PostMapping
    fun createData(@Valid @RequestBody reqDto: DataReqDto): DataResDto {
        return dataService.saveData(reqDto)
    }

    @Operation(summary = "데이터 삭제", description = "ID를 기반으로 데이터를 삭제합니다.")
    @DeleteMapping("/{id}")
    fun deleteData(@PathVariable id: Long) = dataService.deleteData(id)
}