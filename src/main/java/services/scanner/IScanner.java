package services.scanner;

import services.exceptions.BaseException;

import java.io.IOException;

public interface IScanner {
    void startTest() throws IOException, BaseException;
}
