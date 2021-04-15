package com.project_b.countries.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.project_b.countries.databinding.ItemCountryBinding
import com.project_b.countries.model.Country
import com.project_b.countries.util.getProgressDrawable
import com.project_b.countries.util.loadImage

class CountryListAdapter(var countries: ArrayList<Country>) : RecyclerView.Adapter<CountryListAdapter.CountryViewHolder>() {


    fun updateCountries(newCountries:List<Country>){
        countries.clear()
        countries.addAll(newCountries)
        notifyDataSetChanged()

    }

    override fun getItemCount() = countries.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val binding = ItemCountryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CountryViewHolder(binding)
    }


    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        holder.bind(countries[position])
    }

    class CountryViewHolder(val binding: ItemCountryBinding) : RecyclerView.ViewHolder(binding.root) {
        private val countryName = binding.name
        private val countryCapital=binding.capital
        private val imageView=binding.imageView
        private val progressDrawable=getProgressDrawable(binding.root.context)

        fun bind(country: Country) {
            countryName.text = country.countryName
            countryCapital.text=country.capital
            imageView.loadImage(country.flag,progressDrawable)
        }
    }


}