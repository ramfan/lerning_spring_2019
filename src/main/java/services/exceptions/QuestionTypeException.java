package services.exceptions;

public class QuestionTypeException extends BaseException {
    public QuestionTypeException(String type){
        super();
        System.out.println("Not found type:" + type);
        super.printStackTrace();
    }

}
