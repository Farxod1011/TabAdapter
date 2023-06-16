package uz.farxod.tabadapter

import android.media.audiofx.Equalizer.Settings
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.tabs.TabLayoutMediator
import uz.farxod.tabadapter.databinding.ActivityMainBinding
import uz.farxod.tabadapter.fragments.CallsFragment
import uz.farxod.tabadapter.fragments.HomeFragment
import uz.farxod.tabadapter.fragments.SettingsFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val tabAdapter = TabAdapter(this)
        tabAdapter.addFragment(HomeFragment(), "Home")
        tabAdapter.addFragment(CallsFragment(), "Calls")
        tabAdapter.addFragment(SettingsFragment(), "Settings")

        binding.viewPager.adapter = tabAdapter
        binding.viewPager.currentItem = 0   // default, по умолчанию da shu oyna chiqib turishi uchun

                   // tabLayout va viewPager ni bir- biriga bog'lab qo'yamiz
        TabLayoutMediator(binding.tabLayout, binding.viewPager){tab, position ->
            tab.text = tabAdapter.getTabTitle(position)
        }.attach()

        binding.viewPager.isUserInputEnabled = false // qo'lda svayp qilish imkoni o'chadi
    }
}