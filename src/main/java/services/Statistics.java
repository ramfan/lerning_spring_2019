package services;

import models.question.IQuestion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Statistics {
    private ArrayList<Integer> correctAnswers = new ArrayList<>();
    private Map<Integer, InCorrectAnswer> inCorrectAnswers = new HashMap<>();

    public void setAnswer(IQuestion question, String userAnswer, boolean isCorrect ) {
        if(isCorrect){
            correctAnswers.add(question.getId());
        } else {
            inCorrectAnswers.put(question.getId(), new InCorrectAnswer(question.getAnswer(), userAnswer));
        }

    }

    private class InCorrectAnswer {
        public String getCorrectAnswer() {
            return correctAnswer;
        }

        public String getUserAnswer() {
            return userAnswer;
        }

        private final String correctAnswer;
        private final String userAnswer;

        public InCorrectAnswer(String correctAnswer, String userAnswer) {
            this.correctAnswer = correctAnswer;
            this.userAnswer = userAnswer;
        }

    }

}
