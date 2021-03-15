package com.kt.imageloader

import android.graphics.drawable.Drawable
import com.kt.bitmapconverter.utils.BitmapConverterManager
import org.junit.Test
import java.io.InputStream

class ExampleUnitTest {
    @Test
    fun isValidBitmap() {
        var myObjectUnderTest = BitmapConverterManager.getInstance()
        var context = myObjectUnderTest.con
        val assetManager = context.assets
        val inputStream: InputStream = assetManager.open(context.getString(R.string.path_assets_folder_name) + "/brick_bump.jpg")
        val d = Drawable.createFromStream(inputStream, null)
//        assertThat(myObjectUnderTest.convertToBitmap(d).toString()).equals(Bitmap)
    }
}