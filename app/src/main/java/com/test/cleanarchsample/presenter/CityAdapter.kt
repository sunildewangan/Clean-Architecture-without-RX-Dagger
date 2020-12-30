package com.test.cleanarchsample.presenter

import android.annotation.SuppressLint
import androidx.recyclerview.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.test.cleanarchsample.City
import com.test.cleanarchsample.R
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.view_city_item.view.*
import kotlin.properties.Delegates

class CityAdapter : RecyclerView.Adapter<CityAdapter.ViewHolder>() {

    var items: List<City> by Delegates.observable(emptyList()) { _, _, _ -> notifyDataSetChanged() }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(parent.inflate(R.layout.view_city_item))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    class ViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView),
        LayoutContainer {
        @SuppressLint("SetTextI18n")
        fun bind(city: City) {
            with(city) {
                containerView.city_name.text = cityname
                containerView.temp.text = temp.toString()+"°"
            }
        }
    }
}
