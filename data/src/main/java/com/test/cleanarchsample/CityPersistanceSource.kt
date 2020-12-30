package com.test.cleanarchsample

interface CityPersistanceSource {
    fun getPersistedCity(): List<City>
    fun saveNewCity(city: City)
}