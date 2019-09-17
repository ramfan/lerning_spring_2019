package models.questions;

import models.question.IQuestion;

import java.util.HashMap;
import java.util.Map;

public class Questions implements IQuestions {

    private Map<Integer,IQuestion> list = new HashMap<>();

    public IQuestion getQuestionById(Integer id) {
        return list.get(id);
    }

    public void addQuestion(IQuestion question) {
        try {
            list.put(question.getId(), question);
        }
        catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    public boolean checkAnswer(IQuestion question, String userAnswer) {
        return question.getAnswer().equals(userAnswer);
    }

    public Map<Integer, IQuestion> getQuestions() {
        return list;
    }
}
