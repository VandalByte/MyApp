package com.example.myapp

import androidx.lifecycle.ViewModel

class DBViewModel:ViewModel() {
    var count = 0

    fun incrementCount(){
        count++
    }
}