package com.test.cleanarchsample

class GetCities(private val cityRepository: CityRepository) {
    operator fun invoke():List<City> = cityRepository.getSaveCity()
}