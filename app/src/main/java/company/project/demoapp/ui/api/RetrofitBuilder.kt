package company.project.demoapp.ui.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object RetrofitBuilder {

    private val baseUrl = "https://demo3231717.mockable.io"

    private fun getRetrofit(): Retrofit{
        return Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create()).build()
    }
    val apiService : ApiService = getRetrofit().create(ApiService::class.java)
}