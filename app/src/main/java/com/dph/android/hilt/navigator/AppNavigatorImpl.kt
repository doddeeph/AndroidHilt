package com.dph.android.hilt.navigator

import androidx.fragment.app.FragmentActivity
import com.dph.android.hilt.R
import com.dph.android.hilt.ui.ButtonsFragment
import com.dph.android.hilt.ui.LogsFragment
import javax.inject.Inject

class AppNavigatorImpl @Inject constructor(
    private val activity: FragmentActivity
) : AppNavigator {

    override fun navigateTo(screen: Screen) {
        val fragment = when (screen) {
            Screen.BUTTONS -> ButtonsFragment()
            Screen.LOGS -> LogsFragment()
        }

        activity.supportFragmentManager.beginTransaction()
            .replace(R.id.main_container, fragment)
            .addToBackStack(fragment::class.java.canonicalName)
            .commit()
    }
}