package com.example.dka.ui.files

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FilesViewModel : ViewModel() {
    var arquivo: MutableLiveData<String> = MutableLiveData()
    var estado: MutableLiveData<String> = MutableLiveData()
    var conteudo: MutableLiveData<String> = MutableLiveData()

}