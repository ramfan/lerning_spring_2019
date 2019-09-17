package dao;

import models.question.IQuestion;
import models.questions.IQuestions;
import services.exceptions.BaseException;
import java.io.IOException;
import java.util.Map;

public interface IDaoCsv {
    Map<Integer, IQuestion> getData() throws IOException, BaseException;
    IQuestions getAll();
}
