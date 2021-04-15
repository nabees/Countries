package com.project_b.countries.di

import com.project_b.countries.model.CountriesService
import com.project_b.countries.viewmodel.ListViewModel
import dagger.Component

@Component(modules = [ApiModule::class])
interface ApiComponent {
    fun inject(service:CountriesService)
    fun inject(viewModel:ListViewModel)

}