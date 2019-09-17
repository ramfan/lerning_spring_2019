import dao.DaoCsv;
import dao.IDaoCsv;
import models.question.Question;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import services.exceptions.BaseException;
import services.scanner.IScanner;


import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, BaseException {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("/spring-config.xml");
        IScanner scanner = ctx.getBean(IScanner.class);
        scanner.startTest();
    }
}
