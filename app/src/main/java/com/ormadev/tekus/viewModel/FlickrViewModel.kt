package com.ormadev.tekus.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ormadev.tekus.model.PhotoItemResponse
import com.ormadev.tekus.model.PhotoResponse
import com.ormadev.tekus.repository.FlickrRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class FlickrViewModel @Inject constructor(private val repository: FlickrRepository) : ViewModel() {

    private val _flickrResponse = MutableStateFlow<List<PhotoItemResponse>>(emptyList())
    val flickrResponse = _flickrResponse.asStateFlow()

    init {
        getFlickrResponse()
    }

    private fun getFlickrResponse(){
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                val result = repository.getContent()
                _flickrResponse.value = result?.photo ?: emptyList()
            }
        }
    }





}