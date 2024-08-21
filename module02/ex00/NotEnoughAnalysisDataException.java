package module02.ex00;

public class NotEnoughAnalysisDataException extends RuntimeException {
    public NotEnoughAnalysisDataException() {
        super("Not enough data for analysis.");
    }
}
