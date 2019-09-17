package dao;

import models.question.IQuestion;
import models.question.Question;
import models.questions.IQuestions;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import services.exceptions.BaseException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Map;

public class DaoCsv implements IDaoCsv {
    private final String path;
    private IQuestions questions;
    private static final String[] HEADERS = {"id", "question", "answer", "type"};


    public DaoCsv(String path, IQuestions questions) throws IOException, BaseException {
        this.path = path;
        this.questions = questions;
        parse();

    }

    private void parse() throws NullPointerException, IOException, BaseException {
        URL url = ClassLoader.getSystemResource(this.path);
        BufferedReader file = new BufferedReader(new FileReader(url.getPath()));
        Iterable<CSVRecord> records = CSVFormat.DEFAULT.withHeader(HEADERS).withFirstRecordAsHeader().parse(file);
        for(CSVRecord record : records) {
            Integer id = new Integer(record.get(HEADERS[0]));
            String textOfQuestion = record.get(HEADERS[1]);
            String answer = record.get(HEADERS[2]);
            String type = record.get(HEADERS[3]);
            IQuestion question = new Question(id, textOfQuestion, type, answer);
            questions.addQuestion(question);
        }

        for(Map.Entry<Integer, IQuestion> question : questions.getQuestions().entrySet()) {
            System.out.println(question.getValue().toString());
        }
    }

    public IQuestions getAll(){
        return questions;
    }

    public Map<Integer, IQuestion> getData(){
        return questions.getQuestions();
    }
}

