package module02.ex02;

import java.io.FileNotFoundException;

public class Program {
    public static void main(String[] args) {
        try {
            if (args.length != 1) {
                throw new IllegalArgumentNumberException();
            }
            String[] arguments = args[0].split("=");
            String folderPath = arguments[1];
            FileManager fm = new FileManager(folderPath);
            fm.application();
            
        }
        catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
