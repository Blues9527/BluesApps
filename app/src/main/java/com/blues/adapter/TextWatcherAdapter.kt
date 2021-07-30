package com.blues.adapter

import android.text.Editable
import android.text.TextWatcher

/**
 * File: com.blues.adapter.TextWatcherAdapter
 * Description: xxx
 *
 * @author: lanhuajian
 * @time: 2021-07-21
 **/

interface TextWatcherAdapter : TextWatcher {

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

    }

    override fun afterTextChanged(s: Editable?) {

    }
}