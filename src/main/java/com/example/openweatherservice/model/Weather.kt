package com.example.openweatherservice.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.Table
import org.hibernate.annotations.GenericGenerator
import java.time.LocalDateTime
import java.time.LocalTime

@Entity
@Table(name = "weather")
data class Weather @JvmOverloads constructor(
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    val id:String? = "",
    val requestedCityName:String,
    val cityName:String,
    val country: String,
    val temperature: Int,
    val updatedTime: LocalDateTime,
    val responseLocalTime: LocalTime,
)