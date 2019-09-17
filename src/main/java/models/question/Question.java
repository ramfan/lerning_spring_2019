package models.question;

import services.exceptions.BaseException;
import services.exceptions.QuestionTypeException;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Question implements IQuestion {
    private final Integer _id;
    private final String _question;
    private final EQuestionType _type;
    private String _text_answer = null;
    private ArrayList<Integer> _multi_answer = null;
    private Integer _single_answer = null;


    public Question(Integer id, String question, String type, String answer) throws BaseException {
        _id = id;
        _question = question;
        _type = EQuestionType.instanceOf(type);
        if(_type == null) {
            throw new QuestionTypeException(type);
        }
        setAnswer(_type, answer);
    }

    private void setListAnswer(List<String> list){
        _multi_answer = new ArrayList<>();
        for(String item : list){
            _multi_answer.add(new Integer(item));
        }
    }

    private void setAnswer(EQuestionType type, String answer) {
        switch (type) {
            case MULTI:
               setListAnswer(Arrays.asList(answer.split("\\s*,\\s*")));
               break;
            case TEXT:
                _text_answer = answer;
                break;
            case SINGLE:
                _single_answer = new Integer(answer);
               break;
        }
    }

    public boolean checkAnswer(String answer){
        return _text_answer.equals(answer);
    }

    public boolean checkAnswer(ArrayList<Integer> answer){
        Collections.sort(answer);
        return _multi_answer.equals(answer);
    }

    public boolean checkAnswer(int answer){
        return _single_answer == answer;
    }

    public Integer getId() {
        return _id;
    }

    public String getQuestion() {
        return _question;
    }

    public EQuestionType getType(){
        return _type;
    }

    public String getAnswer(){
        if(_multi_answer != null){
            return _multi_answer.toString()
                    .substring(1, _multi_answer.toString().length() -1)
                    .replaceAll(" ", "");
        }
        if(_single_answer != null) {
            return _single_answer.toString();
        }
        if(_text_answer != null){
            return _text_answer;
        }
        return null;
    }

    public String toString(){
        return "" + getId() + ", " + getQuestion() +", " + getType() +", " + getAnswer();
    }
}
