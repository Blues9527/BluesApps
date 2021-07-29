package com.blues.module_game;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.List;

public class QuestionEntity implements Serializable {


    @JSONField(name = "questions")
    public List<QuestionsBean> questions;

    public static class QuestionsBean implements Serializable {
        /**
         * id : 1
         * title : Question1
         * answer : A
         * selections : ["A","B","C","D"]
         */

        @JSONField(name = "id")
        public int id;
        @JSONField(name = "title")
        public String title;
        @JSONField(name = "answer")
        public String answer;
        @JSONField(name = "selections")
        public List<String> selections;
    }
}
