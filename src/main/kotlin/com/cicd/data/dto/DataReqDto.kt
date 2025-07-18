package com.cicd.data.dto

import jakarta.validation.constraints.NotBlank

data class DataReqDto(
    @field:NotBlank(message = "이름은 필수 입력 항목입니다.")
    val name: String
)