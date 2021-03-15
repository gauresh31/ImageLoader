package com.kt.imageloader.ui.base

import android.content.Intent
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.kt.bitmapconverter.utils.BitmapConverterManager
import com.kt.imageloader.R
import java.io.InputStream
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        title = getString(R.string.app_title)
        init()
    }

    private fun init() {
        val intentVal: Intent = intent
        val imgName = intentVal.getStringExtra(getString(R.string.imgName))

        val assetManager = assets
        val inputStream: InputStream = assetManager.open(getString(R.string.path_assets_folder_name) + "/$imgName")

        val d = Drawable.createFromStream(inputStream, null)
        val imgBitmap = BitmapConverterManager.getInstance(this).convertToBitmap(d)

        imageViewDetail.setImageBitmap(imgBitmap)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean = when (item.itemId) {
        android.R.id.home -> {
            finish()
            true
        }
        else -> super.onOptionsItemSelected(item)
    }
}