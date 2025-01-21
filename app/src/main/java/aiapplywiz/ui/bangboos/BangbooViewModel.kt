package aiapplywiz.ui.bangboos

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import aiapplywiz.models.api.bangbooNew.BangbooNewResponseItem
import aiapplywiz.repository.HomeRepository

class BangbooViewModel(
    private val repository: HomeRepository
) : ViewModel() {

//    private val _bangboosLiveData = MutableLiveData<List<BangBoosResponseItem>>()
//    var _bangboos = listOf<BangBoosResponseItem>()
//    val BangboosLiveData: LiveData<List<BangBoosResponseItem>> get() = _bangboosLiveData

    private val _bangboosLiveData = MutableLiveData<List<BangbooNewResponseItem>>()
    var _bangboos = listOf<BangbooNewResponseItem>()
    val BangboosLiveData: LiveData<List<BangbooNewResponseItem>> get() = _bangboosLiveData
    init {
        fetchBangboos()
    }
    private fun fetchBangboos() {
        viewModelScope.launch {
            try {
//                val newItem = withContext(Dispatchers.IO) {
//                    repository.fetchBangboos()
//                }
//                _bangboosLiveData.postValue(newItem.body()?.toList())
//                _bangboos = newItem.body()!!.toList()

                val newItem = withContext(Dispatchers.IO) {
                    repository.fetchBangboosNew()
                }
                _bangboosLiveData.postValue(newItem.body()?.toList())
                _bangboos = newItem.body()!!.toList()
                Log.e("element", newItem.toString())
            } catch (e: Exception) {
                // Handle exceptions, if any
                Log.e("getDetail", "Error fetching details: ${e.message}")
            }
        }
    }

}