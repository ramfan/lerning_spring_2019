package services;

import models.question.IQuestion;

import java.util.HashMap;
import java.util.Map;

public class Statistics {
    private Map<Integer, Boolean> correctAnswers = new HashMap();

    public void setAnswer(IQuestion question, boolean answer) {
        correctAnswers.put(question.getId(), answer);
    }


}
