package com.cicd.data.mapper

import com.cicd.data.dto.DataReqDto
import com.cicd.data.dto.DataResDto
import com.cicd.data.entity.DataEntity
import org.mapstruct.Mapper
import org.mapstruct.Mapping

@Mapper(componentModel = "spring") // 🔥 반드시 추가
interface DataMapper {
    fun toDto(entity: DataEntity): DataResDto
    fun toDtoList(entityList: List<DataEntity>): List<DataResDto>

    @Mapping(target = "id", ignore = true) // ID 자동 생성 방지
    @Mapping(target="name", source="name")
    fun toEntity(reqDto: DataReqDto): DataEntity
}