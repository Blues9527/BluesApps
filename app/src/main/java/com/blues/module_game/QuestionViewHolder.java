package com.blues.module_game;

import android.app.Activity;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.blues.R;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;

import androidx.recyclerview.widget.LinearLayoutManager;

public class QuestionViewHolder extends BaseViewHolder<QuestionEntity.QuestionsBean> {

    private TextView tvTitle;
    private Button btnSubmit;
    private RadioGroup rgAnswers;

    public QuestionViewHolder(ViewGroup parent) {
        super(parent, R.layout.item_game);

        tvTitle = $(R.id.tv_title);
        btnSubmit = $(R.id.btn_submit);
        rgAnswers = $(R.id.rg_answer);
    }

    @Override
    public void setData(QuestionEntity.QuestionsBean data) {
        super.setData(data);

        //1.问题
        tvTitle.setText(String.format("%s.%s", data.getId(), data.getTitle()));

        //设置监听
        btnSubmit.setOnClickListener(v -> {
            //根据焦点radiobutton的id获取对应radiobutton的实例
            if (TextUtils.equals((((RadioButton) ((Activity) getContext()).findViewById(rgAnswers.getCheckedRadioButtonId())).getText().toString()), data.getAnswer())) {
                Toast.makeText(getContext(), "回答正确", Toast.LENGTH_SHORT).show();
                if (getOwnerRecyclerView() != null) {
                    LinearLayoutManager layoutManager = (LinearLayoutManager) getOwnerRecyclerView().getLayoutManager();
                    if (layoutManager != null) {
                        int currentPosition = layoutManager.findFirstVisibleItemPosition();
                        if (getOwnerRecyclerView().getAdapter() != null && currentPosition + 1 < getOwnerRecyclerView().getAdapter().getItemCount()) {
                            getOwnerRecyclerView().scrollToPosition(currentPosition + 1);
                        } else {
                            Toast.makeText(getContext(), "答题结束", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            } else {
                Toast.makeText(getContext(), "回答错误", Toast.LENGTH_SHORT).show();
            }
        });

        //动态添加radiobutton
        for (int i = 0; i < data.getSelections().size(); i++) {
            RadioButton radioButton = new RadioButton(getContext());
            radioButton.setText(data.getSelections().get(i));
            rgAnswers.addView(radioButton);
        }
        ((RadioButton) rgAnswers.getChildAt(0)).setChecked(true);
    }
}
