package com.ideasapp.factorial

import androidx.lifecycle.LiveData

sealed class ScreenState(
) {
    class Error: ScreenState()
    class Progress: ScreenState()
    class Result(val factorial: String): ScreenState()
}