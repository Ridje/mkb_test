package com.kis.mkb_test.ui


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kis.mkb_test.model.pojo.AssetRate
import com.kis.mkb_test.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class AssetsViewModel @Inject constructor(private val repository: Repository) : ViewModel() {

    private val _ratesLiveData : MutableLiveData<AssetsState> = MutableLiveData()
    val ratesLiveData : LiveData<AssetsState> = _ratesLiveData

    fun getRates() {
        viewModelScope.launch {
            _ratesLiveData.postValue(AssetsState.Loading)
            val result = withContext(Dispatchers.IO) {
                val ratesDTO : List<com.kis.mkb_test.model.dto.AssetRate>
                try {
                    ratesDTO = repository.getAssetsExchangeRates()
                } catch (e : Exception) {
                    e.printStackTrace()
                    return@withContext AssetsState.Error(e)
                }

                val ratesPojo: MutableList<AssetRate> = mutableListOf()
                for (item in ratesDTO) {
                    ratesPojo.add(AssetRate(item))
                }
                return@withContext AssetsState.Success(ratesPojo.toList())
            }
            _ratesLiveData.postValue(result)
        }
    }

}