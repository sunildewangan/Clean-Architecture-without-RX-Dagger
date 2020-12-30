package com.test.cleanarchsample.presenter


import com.test.cleanarchsample.City
import com.test.cleanarchsample.GetCities
import com.test.cleanarchsample.RequestNewCity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainPresenter(
    private var view: View?,
    private val getCities: GetCities,
    private val requestNewCity: RequestNewCity
) {
    interface View {
        fun renderLocations(locations: List<City>)
    }

    fun onCreate() = GlobalScope.launch(Dispatchers.Main) {
        val locations = withContext(Dispatchers.IO) { getCities() }
        view?.renderLocations(locations)
    }

    fun newLocationClicked() = GlobalScope.launch(Dispatchers.Main) {
        val requestcity = withContext(Dispatchers.IO) { requestNewCity() }
        view?.renderLocations(requestcity)
    }

    fun onDestroy() {
        view = null
    }
}