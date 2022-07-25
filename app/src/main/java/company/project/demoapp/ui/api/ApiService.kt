package company.project.demoapp.ui.api

import company.project.demoapp.ui.model.Coins
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("/coinlist")
    fun getCoins(): Call<Coins>
}