package com.test.cleanarchsample.framework

import com.test.cleanarchsample.City
import com.test.cleanarchsample.CitySource

class FakeCitySource:CitySource {
    private val cityList = listOf<String>("Banglore","Delhi","Hydrabad","Chennai","Mumbai","Pune","Raipur","Nagpur","Kolkata","Indore")
    private val t_list = listOf<Int>(20,21,22,23,24,25,26,27,28,29)
    override fun getCity(): City  = City(cityList.get((0..9).random()),t_list.get((0..9).random()))
}