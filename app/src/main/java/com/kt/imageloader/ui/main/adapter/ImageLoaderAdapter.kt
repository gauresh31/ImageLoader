package com.kt.imageloader.ui.main.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.kt.imageloader.R
import com.kt.imageloader.ui.base.DetailActivity


class ImageLoaderAdapter(private val mCtx: Context, private val imagesArr: Array<String>?) :
    RecyclerView.Adapter<ImageLoaderAdapter.ImageViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ImageViewHolder {
        val view: View =
            LayoutInflater.from(mCtx).inflate(
                R.layout.layout_item_images,
                parent, false
            )

        return ImageViewHolder(view)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {

        holder.imageName.text = imagesArr?.get(position)
        holder.clMain.setOnClickListener {
            val myIntent = Intent(mCtx, DetailActivity::class.java)
            myIntent.putExtra(mCtx.getString(R.string.imgName), imagesArr?.get(position))
            mCtx.startActivity(myIntent)
        }
    }

    override fun getItemCount(): Int {
        return imagesArr?.size!!
    }

    class ImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val clMain: ConstraintLayout = itemView.findViewById(R.id.cl_main)
        val imageName: TextView = itemView.findViewById(R.id.tv_image_name)
    }
}