package com.cicd.data.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import com.cicd.data.entity.DataEntity

@Repository
interface DataRepository : JpaRepository<DataEntity, Long>
