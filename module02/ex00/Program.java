package module02.ex00;

public class Program {
    public static void main(String[] args) {
        AnalyzeSignatures analyzeSignatures = new AnalyzeSignatures();
        try {
            analyzeSignatures.application();

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
