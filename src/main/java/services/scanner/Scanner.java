package services.scanner;

import dao.IDaoCsv;
import models.question.EQuestionType;
import models.question.IQuestion;
import models.questions.IQuestions;
import services.IStatistics;
import services.exceptions.BaseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

public class Scanner implements IScanner {

    private final IDaoCsv dao;
    private IQuestions questions = null;
    private final IStatistics stats;

    public Scanner(IDaoCsv dao, IStatistics stats){
        this.dao = dao;
        this.stats = stats;
        questions = dao.getAll();
    }

    private String waitingAnswer() throws IOException {
        return new BufferedReader(new InputStreamReader(System.in)).readLine();
    }

    private void askSingle(IQuestion question) throws IOException {
        System.out.print(
                "№ " + question.getId()
                +"Вопрос с одиночным ответом: " + question.getQuestion()
                +"\n Ваш ответ: "
        );
        String answer = waitingAnswer();
        stats.setAnswer(question, answer, questions.checkAnswer(question, answer));
    }

    private void askText(IQuestion question) throws IOException {
        System.out.print(
                "№ " + question.getId()
                        +"Вопрос со свободным ответом: " + question.getQuestion()
                        +"\n Ваш ответ: "
        );
        String answer = waitingAnswer();
        stats.setAnswer(question, answer, questions.checkAnswer(question, answer));
    }

    private void askMulti(IQuestion question) throws IOException {
        System.out.print(
                "№ " + question.getId()
                        +"Вопрос с множественым ответом: " + question.getQuestion()
                        +"\n Ваш ответ: "
        );
        String answer = waitingAnswer();
        stats.setAnswer(question, answer, questions.checkAnswer(question, answer));
    }

    public void startTest() throws IOException, BaseException {
        Map<Integer, IQuestion> questions = dao.getData();

        for(Map.Entry<Integer, IQuestion> question : questions.entrySet()) {
            EQuestionType type = question.getValue().getType();
            switch (type){
                case TEXT:
                    askText(question.getValue());
                    break;
                case MULTI:
                    askMulti(question.getValue());
                    break;
                case SINGLE:
                    askSingle(question.getValue());
                    break;
            }
        }
        stats.print();
    }
}
