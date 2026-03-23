package com.MobLab3

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tips = GameData.getTips(this)
        val recyclerView: RecyclerView = findViewById(R.id.recycler_view)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = GameAdapter(tips) { tip ->
            val intent = Intent(this, DetailActivity::class.java).apply {
                putExtra("DAY", tip.dayNumber)
                putExtra("TITLE", tip.title)
                putExtra("FULL_DESC", tip.fullDescription)
                putExtra("IMAGE_RES", tip.imageResId)
            }
            startActivity(intent)
        }
    }
}