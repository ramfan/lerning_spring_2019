package services;

import models.question.IQuestion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Statistics implements IStatistics {
    private ArrayList<Integer> correctAnswers = new ArrayList<>();
    private Map<Integer, InCorrectAnswer> inCorrectAnswers = new HashMap<>();



    public void setAnswer(IQuestion question, String userAnswer, boolean isCorrect ) {
        if(isCorrect){
            correctAnswers.add(question.getId());
        } else {
            inCorrectAnswers.put(question.getId(), new InCorrectAnswer(question.getAnswer(), userAnswer));
        }

    }

    private Float getPercent(Integer count){
        Integer countCorrects = correctAnswers.size();

        return (float) ((double)countCorrects / (double)count);
    }

    private Integer getGrade(){
        Integer countAnswers = correctAnswers.size() + inCorrectAnswers.size();
        Float percent = getPercent(countAnswers);
        if(percent > 0.51 && percent < 0.72) {
            return 3;
        }
        if(percent > 0.72 && percent < 0.86){
            return 4;
        }

        if(percent > 0.86) {
            return 5;
        }
        return 0;
    }


    public void print() {
        Integer countAnswers = correctAnswers.size() + inCorrectAnswers.size();
        System.out.println("===============================");
        System.out.println("Вы ответили правильно на "
                + correctAnswers.size()
                + " из "
                + countAnswers
        );
        System.out.println("===============================");
        System.out.println("Ваша оценка: " +  getGrade());
        System.out.println("===============================");
        for(Map.Entry<Integer, InCorrectAnswer> item: inCorrectAnswers.entrySet()) {
            System.out.println("Ошибка в вопросе № "
                    + item.getKey()
                    + "\n правильный ответ был "
                    + item.getValue().getCorrectAnswer()
                    + "\n ваш ответ: "
                    + item.getValue().getUserAnswer()

            );
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
