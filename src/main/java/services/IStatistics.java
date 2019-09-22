package services;

import models.question.IQuestion;

public interface IStatistics {
    void print();
    void setAnswer(IQuestion question, String userAnswer, boolean isCorrect);
}
