package module02.ex01;

import java.io.*;

public class Program {
    private static String textA;
    private static String textB;

    public static String readFromFile(String path) throws Exception {
        String text = "";
        String textLine;
        FileReader file = new FileReader(path);
        BufferedReader buffer = new BufferedReader(file);
        while ((textLine = buffer.readLine()) != null) {
            text += textLine;
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
