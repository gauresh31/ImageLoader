package com.kt.imageloader.ui.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.kt.imageloader.R
import com.kt.imageloader.ui.main.adapter.ImageLoaderAdapter
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private lateinit var imgLoaderAdapter: ImageLoaderAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = getString(R.string.app_title)
        init()
    }

    private fun init() {
        val assetManager = assets
        val images = assetManager.list(getString(R.string.path_assets_folder_name))

        imgLoaderAdapter = ImageLoaderAdapter(this@MainActivity, images)
        recyclerview_images.adapter = imgLoaderAdapter
        recyclerview_images.layoutManager = LinearLayoutManager(this)
    }
}