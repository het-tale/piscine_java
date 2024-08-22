package module02.ex02;

public class IllegalArgumentNumberException extends RuntimeException {
    public IllegalArgumentNumberException() {
        super("Incorrect number of arguments");
    }
}
