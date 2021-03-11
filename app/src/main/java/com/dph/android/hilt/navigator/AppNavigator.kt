package com.dph.android.hilt.navigator

interface AppNavigator {
    fun navigateTo(screen: Screen)
}

enum class Screen {
    BUTTONS, LOGS
}