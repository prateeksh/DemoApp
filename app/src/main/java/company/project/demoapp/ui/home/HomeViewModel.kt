package company.project.demoapp.ui.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import company.project.demoapp.ui.model.Coins

class HomeViewModel : ViewModel() {

    var mCoinsData: MutableLiveData<Coins> ?= null;
    private lateinit var mRepository: CoinsDataRepository

    fun init(){
        if (mCoinsData != null){
            Log.e("View model class", "init: coinsdata is not null", )
            mCoinsData
        }
        else mCoinsData = MutableLiveData()

        mRepository = CoinsDataRepository().getRepoInstance()
        mCoinsData = mRepository.getCoinsData()
    }
}