package company.project.demoapp.ui.home

import android.content.Context
import android.net.ConnectivityManager
import android.util.Log
import androidx.lifecycle.MutableLiveData
import company.project.demoapp.ui.api.RetrofitBuilder.apiService
import company.project.demoapp.ui.model.Coins
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CoinsDataRepository {

    private var dataset:MutableLiveData<Coins> = MutableLiveData()

    private var instance: CoinsDataRepository ?= null

    fun getRepoInstance() : CoinsDataRepository{
        if (instance == null) instance = CoinsDataRepository()
        return instance!!
    }

    fun getCoinsData(): MutableLiveData<Coins> {

        Log.e("Repository Class", "getCoinsData: method called ", )
        val retrofitCall = apiService.getCoins()

        Log.e("Repository Class", retrofitCall.toString() )
        retrofitCall.enqueue(object : Callback<Coins> {
            override fun onResponse(call: Call<Coins>, response: Response<Coins>) {
                dataset.value = response.body()!!
                Log.e("RetrofitCall", response.body().toString())
            }

            override fun onFailure(call: Call<Coins>, t: Throwable) {
                Log.e("RetrofitCall", t.toString()  )
            }


        })
        return dataset
    }


}