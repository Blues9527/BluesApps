package com.blues.framework.utils

import android.widget.ImageView
import coil.load
import com.blues.R

/**
 * File: com.blues.framework.utils.CoilExt
 * Description: xxx
 *
 * @author: lanhuajian
 * @time: 2021-08-02 14:42
 **/

fun ImageView.simpleLoad(url: String) {
    this.load(url) {
        placeholder(R.drawable.shape_place_holder)
        error(R.mipmap.ic_img_error)
    }
}

