package com.ideasapp.factorial

import androidx.lifecycle.LiveData

class ScreenState(
    val error: Boolean = false,
    val progress: Boolean = false,
    val factorial: String = ""
)