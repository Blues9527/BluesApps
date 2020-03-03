package com.blues.module_kaiyan.search;

import android.view.ViewGroup;
import android.widget.TextView;

import com.blues.R;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;

/**
 * User : Blues
 * Date : 2019/8/28
 * Time : 18:30
 */

public class OEHotSearchViewHolder extends BaseViewHolder<String> {

    private TextView tvHotSearch;

    public OEHotSearchViewHolder(ViewGroup parent) {
        super(parent, R.layout.item_hot_search);

        tvHotSearch = $(R.id.tv_hot_search);
    }

    @Override
    public void setData(String data) {
        tvHotSearch.setText(data);
    }
}
