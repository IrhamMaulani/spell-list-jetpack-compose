package com.example.jetpackcomposedemo.data.mapper

interface DomainMapper<INPUT, OUTPUT> {
    fun mapToDomain(input: INPUT): OUTPUT
}