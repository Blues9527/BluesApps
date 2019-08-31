package com.example.lanhuajian.blues.module_kaiyan.search;

import android.media.Image;
import android.os.Bundle;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lanhuajian.blues.R;
import com.example.lanhuajian.blues.framework.base.BaseActivity;
import com.example.lanhuajian.blues.module_kaiyan.OpenEyeContract;
import com.example.lanhuajian.blues.module_kaiyan.OpenEyeEntity;
import com.example.lanhuajian.blues.module_kaiyan.OpenEyePresenter;
import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

import java.util.List;

/**
 * User : Blues
 * Date : 2019/8/28
 * Time : 17:16
 */

public class OpenEyeSearchActivity extends BaseActivity implements TextWatcher, View.OnClickListener, OpenEyeContract.iOpenEyeView, TextView.OnEditorActionListener {

    private EditText etSearch;
    private ImageView ivClear;
    private TextView tvCancel;
    private TextView tvSearchResult;

    private EasyRecyclerView rvSearchResult;
    private EasyRecyclerView rvHotSearchResult;

    private String textInput;

    private OpenEyeContract.iOpenEyePresenter iPresenter;
    private RecyclerArrayAdapter<String> mAdapter;

    @Override
    public int setLayoutResourceId() {
        return R.layout.activity_oe_search;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        etSearch = findViewById(R.id.et_search);
        ivClear = findViewById(R.id.iv_clear);
        tvCancel = findViewById(R.id.tv_cancel);
        tvSearchResult = findViewById(R.id.tv_search_result);

        rvSearchResult = findViewById(R.id.rv_search_result);
        rvHotSearchResult = findViewById(R.id.rv_hot_search);


        ivClear.setVisibility(View.GONE);
        rvSearchResult.setVisibility(View.GONE);
        rvHotSearchResult.setVisibility(View.VISIBLE);

        mPresenter = new OpenEyePresenter(this);
        iPresenter.getHotSearch();

        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
        rvHotSearchResult.setLayoutManager(layoutManager);
        rvHotSearchResult.setAdapter(mAdapter = new RecyclerArrayAdapter<String>(mContext) {
            @Override
            public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
                return new OEHotSearchViewHolder(parent);
            }
        });
    }

    @Override
    public void setListener() {
        etSearch.addTextChangedListener(this);

        etSearch.setOnEditorActionListener(this);

        ivClear.setOnClickListener(this);
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        textInput = etSearch.getText().toString().trim();
        if (textInput != null && !TextUtils.isEmpty(textInput)) {
            ivClear.setVisibility(View.VISIBLE);
        } else {
            ivClear.setVisibility(View.GONE);
        }
    }

    @Override
    public void afterTextChanged(Editable s) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_clear:
                etSearch.setText("");
                textInput = "";
                break;
        }
    }

    @Override
    public void showRankList(List<OpenEyeEntity.ItemListBean> openEyeList) {

    }

    @Override
    public void showRequestError(String msg) {

    }

    @Override
    public void showHotSearch(List<String> searches) {
        mAdapter.addAll(searches);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void showSearchResult(List<OpenEyeEntity.ItemListBean> openEyeList) {

    }

    @Override
    public void setPresenter(OpenEyeContract.iOpenEyePresenter presenter) {
        iPresenter = presenter;
    }

    @Override
    public void showBegin() {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void showFinished() {

    }

    @Override
    public void showError() {

    }

    @Override
    public void showEmpty() {

    }

    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        if (actionId == EditorInfo.IME_ACTION_SEARCH) {
            iPresenter.getSearchResult(textInput);
            return true;
        }
        return false;
    }
}
