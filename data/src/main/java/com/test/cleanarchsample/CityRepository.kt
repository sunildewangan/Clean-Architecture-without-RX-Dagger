package com.test.cleanarchsample

class CityRepository(
    private val cityPersistanceSource: CityPersistanceSource,
    private val citySource: CitySource
) {

    fun getSaveCity():List<City> = cityPersistanceSource.getPersistedCity()

    fun requestNewCity():List<City>{
        val newCity= citySource.getCity()
        cityPersistanceSource.saveNewCity(newCity)
        return getSaveCity()
    }
}