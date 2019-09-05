package com.example.androidtutorial.P01_xml_recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.androidtutorial.R

class WeatherRecyclerViewAdapter(val weatherList: ArrayList<XmlRecyclerViewActivity.WeatherData>)
    : RecyclerView.Adapter<WeatherRecyclerViewAdapter.WeatherViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_weather, parent, false)
        return WeatherViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return weatherList.size
    }

    override fun onBindViewHolder(holder: WeatherViewHolder, position: Int) {
        val data = weatherList[position]
        holder.bind(data)
    }

    class WeatherViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bind(data: XmlRecyclerViewActivity.WeatherData) {
            textViewDay.text = "${data.day}일"
            textViewHour.text = "${data.hour}시"
            textViewTemp.text = "${data.temp}도"
            textViewWfKor.text = "${data.wfKor}"
        }

        val textViewDay: TextView = itemView.findViewById(R.id.textViewDay)
        val textViewHour: TextView = itemView.findViewById(R.id.textViewHour)
        val textViewTemp: TextView = itemView.findViewById(R.id.textViewTemp)
        val textViewWfKor: TextView = itemView.findViewById(R.id.textViewWfKor)
    }
}