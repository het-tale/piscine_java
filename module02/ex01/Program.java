package module02.ex01;

import java.io.FileReader;

public class Program {
    private static String textA;
    private static String textB;

    public static String readFromFile(String path) throws Exception {
        String text = "";
        int character;
        FileReader file = new FileReader(path);
        while ((character = file.read()) != -1) {
            text += (char) character;
        }
        file.close();
        return text;
    }

    public static void main(String[] args) {
        try {
            if (args.length != 2) {
                throw new IllegalArgumentNumberException();
            }
            textA = readFromFile(args[0]);
            textB = readFromFile(args[1]);
            StringSimilarity similarity = new StringSimilarity(textA, textB);
            similarity.application();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
