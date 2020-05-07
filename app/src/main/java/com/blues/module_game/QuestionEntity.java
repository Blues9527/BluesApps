package com.blues.module_game;

import java.io.Serializable;
import java.util.List;

public class QuestionEntity implements Serializable {


    private List<QuestionsBean> questions;

    public List<QuestionsBean> getQuestions() {
        return questions;
    }

    public void setQuestions(List<QuestionsBean> questions) {
        this.questions = questions;
    }

    public static class QuestionsBean implements Serializable {
        /**
         * id : 1
         * title : Question1
         * answer : A
         * selections : ["A","B","C","D"]
         */

        private int id;
        private String title;
        private String answer;
        private List<String> selections;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getAnswer() {
            return answer;
        }

        public void setAnswer(String answer) {
            this.answer = answer;
        }

        public List<String> getSelections() {
            return selections;
        }

        public void setSelections(List<String> selections) {
            this.selections = selections;
        }

        @Override
        public String toString() {
            return "QuestionsBean{" +
                    "id=" + id +
                    ", title='" + title + '\'' +
                    ", answer='" + answer + '\'' +
                    ", selections=" + selections +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "QuestionEntity{" +
                "questions=" + questions +
                '}';
    }
}
