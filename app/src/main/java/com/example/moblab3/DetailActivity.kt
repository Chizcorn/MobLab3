package com.MobLab3

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val day = intent.getIntExtra("DAY", 0)
        val title = intent.getStringExtra("TITLE")
        val fullDescription = intent.getStringExtra("FULL_DESC")
        val imageResId = intent.getIntExtra("IMAGE_RES", 0)

        findViewById<TextView>(R.id.detail_day).text = getString(R.string.day_format, day)
        findViewById<TextView>(R.id.detail_title).text = title
        findViewById<TextView>(R.id.detail_description).text = fullDescription

        val imageView = findViewById<ImageView>(R.id.detail_image)
        if (imageResId != 0) {
            imageView.setImageResource(imageResId)
        } else {
            imageView.setImageResource(android.R.drawable.ic_menu_gallery)
        }
    }
}