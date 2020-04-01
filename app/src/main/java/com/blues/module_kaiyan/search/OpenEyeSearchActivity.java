package com.blues.module_kaiyan.search;

import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.blues.R;
import com.blues.framework.base.BaseActivity;
import com.blues.module_kaiyan.OpenEyeContract;
import com.blues.module_kaiyan.OpenEyeEntity;
import com.blues.module_kaiyan.OpenEyePresenter;
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
    private TextView tvSearchResult;
    private LinearLayout llHotSearch;

    private EasyRecyclerView rvSearchResult;
    private EasyRecyclerView rvHotSearchResult;
    private TextView tvCancel;

    private String textInput;

    private OpenEyeContract.iOpenEyePresenter iPresenter;
    private RecyclerArrayAdapter<String> mHotSearchAdapter;
    private RecyclerArrayAdapter<OpenEyeEntity.ItemListBean.DataBean> mResultAdapter;

    @Override
    public int setLayoutResourceId() {
        return R.layout.activity_oe_search;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        etSearch = findViewById(R.id.et_search);
        ivClear = findViewById(R.id.iv_clear);
        tvSearchResult = findViewById(R.id.tv_search_result);

        rvSearchResult = findViewById(R.id.rv_search_result);
        rvHotSearchResult = findViewById(R.id.rv_hot_search);
        llHotSearch = findViewById(R.id.ll_hot_search);
        tvCancel = findViewById(R.id.tv_cancel);


        ivClear.setVisibility(View.GONE);
        rvSearchResult.setVisibility(View.GONE);
        llHotSearch.setVisibility(View.VISIBLE);
        tvSearchResult.setTextColor(getResources().getColor(R.color.color_weak_white));
        tvSearchResult.setTextSize(TypedValue.COMPLEX_UNIT_SP, 11F);

        mPresenter = new OpenEyePresenter(this);
        iPresenter.getHotSearch();

        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
        rvHotSearchResult.setLayoutManager(layoutManager);
        rvHotSearchResult.setAdapter(mHotSearchAdapter = new RecyclerArrayAdapter<String>(mContext) {
            @Override
            public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
                return new OEHotSearchViewHolder(parent);
            }
        });

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext);
        rvSearchResult.setLayoutManager(linearLayoutManager);
        rvSearchResult.setAdapter(mResultAdapter = new RecyclerArrayAdapter<OpenEyeEntity.ItemListBean.DataBean>(mContext) {
            @Override
            public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
                return new OESearchResultViewHolder(parent);
            }
        });
    }

    @Override
    public void setListener() {
        etSearch.addTextChangedListener(this);
        etSearch.setOnEditorActionListener(this);
        ivClear.setOnClickListener(this);
        tvCancel.setOnClickListener(this);

        if (mHotSearchAdapter != null) {

            mHotSearchAdapter.setOnItemClickListener(position -> {
                textInput = mHotSearchAdapter.getItem(position);
                etSearch.setText(textInput);
                iPresenter.getSearchResult(textInput);
            });
        }
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        textInput = etSearch.getText().toString().trim();
        ivClear.setVisibility(!TextUtils.isEmpty(textInput) ? View.VISIBLE : View.GONE);
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
            case R.id.tv_cancel:
                finish();
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
        mHotSearchAdapter.addAll(searches);
        mHotSearchAdapter.notifyDataSetChanged();
    }

    @Override
    public void showSearchResult(List<OpenEyeEntity.ItemListBean> openEyeList) {
        llHotSearch.setVisibility(View.GONE);
        rvSearchResult.setVisibility(View.VISIBLE);

        tvSearchResult.setTextColor(getResources().getColor(R.color.color_black));
        tvSearchResult.setTextSize(TypedValue.COMPLEX_UNIT_SP, 13F);
        tvSearchResult.setText(String.format("『%s』共有%s条搜索结果", textInput, openEyeList.size()));

        for (OpenEyeEntity.ItemListBean item : openEyeList) {
            mResultAdapter.add(item.getData());
        }
        mResultAdapter.notifyDataSetChanged();
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
            mResultAdapter.clear();
            iPresenter.getSearchResult(textInput);
            return true;
        }
        return false;
    }
}
