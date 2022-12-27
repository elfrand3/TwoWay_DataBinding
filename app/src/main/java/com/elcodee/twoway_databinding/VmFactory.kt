package com.elcodee.twoway_databinding

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class VmFactory(private val startingTotal: Int): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ChallengeViewModel::class.java)){
            return ChallengeViewModel(startingTotal) as T
        }
        throw IllegalArgumentException("Unknow View Model Class")
    }
}