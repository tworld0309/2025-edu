package com.cicd.data.entity

import jakarta.persistence.*

@Entity
@Table(name = "data_table")
data class DataEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    val name: String
) {
    constructor() : this(0, "")  // 🔥 기본 생성자 추가
}