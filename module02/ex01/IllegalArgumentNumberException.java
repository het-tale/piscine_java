package module02.ex01;

public class IllegalArgumentNumberException extends RuntimeException {
    public IllegalArgumentNumberException() {
        super("Incorrect number of arguments");
    }
}
