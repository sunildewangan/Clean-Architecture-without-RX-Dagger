package com.test.cleanarchsample

class RequestNewCity(private val cityRepository: CityRepository) {
    operator fun invoke(): List<City> = cityRepository.requestNewCity()
}