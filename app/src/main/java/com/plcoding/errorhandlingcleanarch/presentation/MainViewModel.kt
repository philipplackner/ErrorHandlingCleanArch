package com.plcoding.errorhandlingcleanarch.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.plcoding.errorhandlingcleanarch.R
import com.plcoding.errorhandlingcleanarch.domain.SubmitEmail
import com.plcoding.errorhandlingcleanarch.util.Resource
import com.plcoding.errorhandlingcleanarch.util.UiText
import kotlinx.coroutines.launch

class MainViewModel(
    private val submitEmail: SubmitEmail = SubmitEmail()
): ViewModel() {

    var email by mutableStateOf("")
        private set

    var message by mutableStateOf<UiText?>(null)

    fun onEmailChange(email: String) {
        this.email = email
    }

    fun submit() {
        viewModelScope.launch {
            val result = submitEmail.execute(email)
            message = when(result) {
                is Resource.Success -> {
                    UiText.StringResource(R.string.successfully_submitted)
                }
                is Resource.Error -> {
                    result.message
                }
            }
        }
    }
}