package com.cicd.service

import com.cicd.data.dto.DataReqDto
import com.cicd.data.mapper.DataMapper
import com.cicd.data.dto.DataResDto
import org.springframework.stereotype.Service
import com.cicd.data.repository.DataRepository

@Service
class DataService(
    private val dataRepository: DataRepository,
    private val dataMapper: DataMapper
) {

    fun getAllData(): List<DataResDto> {
        val entityList = dataRepository.findAll()
        return dataMapper.toDtoList(entityList)
    }

    fun saveData(reqDto: DataReqDto): DataResDto {
        val entity = dataMapper.toEntity(reqDto)
        val savedEntity = dataRepository.save(entity)
        return dataMapper.toDto(savedEntity)
    }

    fun deleteData(id: Long) {
        dataRepository.deleteById(id)
    }
}