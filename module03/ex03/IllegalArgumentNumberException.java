package module03.ex03;

public class IllegalArgumentNumberException extends RuntimeException {
    public IllegalArgumentNumberException() {
        super("Incorrect number of arguments");
    }
}
