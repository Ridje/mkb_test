package com.kis.mkb_test.ui.assets

import com.kis.mkb_test.model.pojo.AssetRate

sealed class AssetsState {
    data class Success(val rates : List<AssetRate>) : AssetsState()
    data class Error(val e : Throwable) : AssetsState()
    object Loading : AssetsState()
}
