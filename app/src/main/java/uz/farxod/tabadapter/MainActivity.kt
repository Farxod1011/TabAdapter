package uz.farxod.tabadapter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.tabs.TabLayoutMediator
import uz.farxod.tabadapter.databinding.ActivityMainBinding
import uz.farxod.tabadapter.fragments.ListFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val tabAdapter = TabAdapter(this)

        tabAdapter.addFragment(ListFragment.newInctance(0), "Animals")
        tabAdapter.addFragment(ListFragment.newInctance(1), "Cars")


        binding.viewPager.adapter = tabAdapter
        binding.viewPager.currentItem = 0   // default, по умолчанию da shu oyna chiqib turishi uchun

                   // tabLayout va viewPager ni bir- biriga bog'lab qo'yamiz
        TabLayoutMediator(binding.tabLayout, binding.viewPager){tab, position ->
            tab.text = tabAdapter.getTabTitle(position)
        }.attach()

    //    binding.viewPager.isUserInputEnabled = false // qo'lda svayp qilish imkoni o'chadi
    }

}