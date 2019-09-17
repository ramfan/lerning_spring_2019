package models.questions;

import models.question.IQuestion;

import java.util.ArrayList;
import java.util.Map;

public interface IQuestions {
    IQuestion getQuestionById(Integer id);
    void addQuestion(IQuestion question);
    boolean checkAnswer(IQuestion question, String userAnswer);
    Map<Integer,IQuestion> getQuestions();
}
