package com.test.cleanarchsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.test.cleanarchsample.framework.FakeCitySource
import com.test.cleanarchsample.framework.InMemoryCityPerrsistanceSource
import com.test.cleanarchsample.presenter.CityAdapter
import com.test.cleanarchsample.presenter.MainPresenter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainPresenter.View {

    private val locationsAdapter = CityAdapter()
    private val presenter: MainPresenter

    init {

        val persistence = InMemoryCityPerrsistanceSource()
        val city = FakeCitySource()
        val locationsRepository = CityRepository(persistence, city)
        presenter = MainPresenter(
            this,
            GetCities(locationsRepository),
            RequestNewCity(locationsRepository)
        )
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recycler.adapter = locationsAdapter

        newLocationBtn.setOnClickListener { presenter.newLocationClicked() }

        presenter.onCreate()
    }

    override fun onDestroy() {
        presenter.onDestroy()
        super.onDestroy()
    }

    override fun renderLocations(locations: List<City>) {
        locationsAdapter.items = locations
    }
}