package com.route.islamiapp.home

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.route.islamiapp.R
import com.route.islamiapp.databinding.ActivityHomeBinding
import com.route.islamiapp.home.fragments.HadithFragment
import com.route.islamiapp.home.fragments.QuranFragment
import com.route.islamiapp.home.fragments.RadioFragment
import com.route.islamiapp.home.fragments.SebhaFragment

class HomeActivity : AppCompatActivity() {
    lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.islamiBottomNavigationView.setOnItemSelectedListener{ meunItem ->

            if(meunItem.itemId == R.id.navigation_quran){
                showFragment(QuranFragment())
            } else if(meunItem.itemId == R.id.navigation_hadith) {
                showFragment(HadithFragment())
            }else if(meunItem.itemId == R.id.navigation_sebha) {
                showFragment(SebhaFragment())
            }else if(meunItem.itemId == R.id.navigation_radio) {
                showFragment(RadioFragment())
            } else{
              showFragment(QuranFragment())
            }

            return@setOnItemSelectedListener true
        }
        binding.islamiBottomNavigationView.selectedItemId = R.id.navigation_quran
    }

    private fun showFragment(fragment : Fragment){
        supportFragmentManager.beginTransaction().replace(R.id.islami_fragment_container,fragment).commit()
    }
}