package com.dph.android.hilt.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.dph.android.hilt.data.LoggerDataSource
import com.dph.android.hilt.databinding.FragmentButtonsBinding
import com.dph.android.hilt.di.InMemoryLogger
import com.dph.android.hilt.navigator.AppNavigator
import com.dph.android.hilt.navigator.Screen
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ButtonsFragment : Fragment() {

    @InMemoryLogger
    @Inject lateinit var logger: LoggerDataSource
    @Inject lateinit var navigator: AppNavigator
    private lateinit var binding: FragmentButtonsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentButtonsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.button1.setOnClickListener {
            logger.addLog("Interaction with 'Button 1'")
        }
        binding.button2.setOnClickListener {
            logger.addLog("Interaction with 'Button 2'")
        }
        binding.button3.setOnClickListener {
            logger.addLog("Interaction with 'Button 3'")
        }
        binding.allLogs.setOnClickListener {
            navigator.navigateTo(Screen.LOGS)
        }
        binding.deleteLogs.setOnClickListener {
            logger.removeLogs()
        }
    }
}