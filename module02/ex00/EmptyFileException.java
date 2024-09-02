package module02.ex00;

public class EmptyFileException extends RuntimeException {
    public EmptyFileException() {
        super("File is empty");
    }

}
