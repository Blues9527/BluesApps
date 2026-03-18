package com.blues.game

import com.alibaba.fastjson.annotation.JSONField
import java.io.Serializable

class QuestionEntity : Serializable {

    @JSONField(name = "questions")
    var questions: List<QuestionsBean> = mutableListOf()

    class QuestionsBean : Serializable {

        /**
         * id : 1
         * title : Question1
         * answer : A
         * selections : ["A","B","C","D"]
         */
        @JSONField(name = "id")
        var id = 0

        @JSONField(name = "title")
        var title: String = ""

        @JSONField(name = "answer")
        var answer: String = ""

        @JSONField(name = "selections")
        var selections: List<String> = mutableListOf()
    }
}