package com.kis.mkb_test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.kis.mkb_test.ui.AssetsFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            navigateToDefaultFragment();
        }
    }

    fun navigateToDefaultFragment() {
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container, getDefaultFragment()).commit()
    }

    fun navigateToFragment(fragment : Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container, fragment).addToBackStack(null).commit()
    }

    private fun getDefaultFragment() : Fragment {
        return AssetsFragment.newInstance()
    }
}