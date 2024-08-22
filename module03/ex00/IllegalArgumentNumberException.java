package module03.ex00;

public class IllegalArgumentNumberException extends RuntimeException {
    public IllegalArgumentNumberException() {
        super("Incorrect number of arguments");
    }
}
