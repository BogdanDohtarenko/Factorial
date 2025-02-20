package com.ideasapp.factorial

import androidx.lifecycle.LiveData

sealed class ScreenState {
    object Error: ScreenState()
    object Progress: ScreenState()
    class Result(val factorial: String): ScreenState()
}