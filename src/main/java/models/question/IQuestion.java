package models.question;

import java.util.ArrayList;

public interface IQuestion {
    boolean checkAnswer(String answer);
    boolean checkAnswer(ArrayList<Integer> answer);
    boolean checkAnswer(int answer);
    Integer getId();
    String getQuestion();
    EQuestionType getType();
    String getAnswer();
}
