package com.test.cleanarchsample.framework

import com.test.cleanarchsample.City
import com.test.cleanarchsample.CityPersistanceSource

class InMemoryCityPerrsistanceSource:CityPersistanceSource {

    private var cities:List<City> = emptyList()

    override fun getPersistedCity(): List<City> = cities

    override fun saveNewCity(city: City) {
        cities = cities+city
    }
}