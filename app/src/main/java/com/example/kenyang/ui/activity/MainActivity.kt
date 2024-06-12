package com.example.kenyang.ui.activity

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kenyang.R
import com.example.kenyang.adapter.RecommendationAdapter
import com.example.kenyang.data.dataclass.Recommendation
import com.example.kenyang.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val adapter = RecommendationAdapter()
        val recommendationList = makeList()
        adapter.submitList(recommendationList)

        binding.rvRecommendation.adapter = adapter
        binding.rvRecommendation.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
    }

    private fun makeList(): List<Recommendation> {
        val list = mutableListOf<Recommendation>()

        val images = resources.obtainTypedArray(R.array.menu_image)
        val menu = resources.getStringArray(R.array.menu_array)
        val restaurant = resources.getStringArray(R.array.restaurant_array)
        val stock = resources.getIntArray(R.array.stock_array)
        val rating = resources.getStringArray(R.array.rating_array)
        val distance = resources.getStringArray(R.array.distance_array)
        val price = resources.getIntArray(R.array.price_array)

        for (i in menu.indices) {
            val recommendation = Recommendation(
                images.getResourceId(i, -1),
                menu[i],
                restaurant[i],
                stock[i],
                rating[i].toDouble(),
                distance[i].toDouble(),
                price[i]
            )
            list.add(recommendation)
        }

        return list
    }
}