package com.dph.android.hilt.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dph.android.hilt.databinding.ActivityMainBinding
import com.dph.android.hilt.navigator.AppNavigator
import com.dph.android.hilt.navigator.Screen
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject lateinit var navigator: AppNavigator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            navigator.navigateTo(Screen.BUTTONS)
        }
    }
}