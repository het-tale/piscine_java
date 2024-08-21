package module02.ex00;

import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Program {
    private static Map<String, String> signatures = new HashMap<String, String>();
    private static Scanner scanner = new Scanner(System.in);

    public static void readSignatures() throws Exception {
        FileInputStream file = new FileInputStream("signatures.txt");
        int i = 0;
        String signature = "";
        String type = "";
        boolean typePartComplete = false;
        while ((i = file.read()) != -1) {
            if ((char) i == ',') {
                typePartComplete = true;
            } else if ((char) i == ' ') {
                continue;
            } else if ((char) i == '\n') {
                typePartComplete = false;
                signatures.put(type, signature);
                type = "";
                signature = "";
            } else {
                if (!typePartComplete) {
                    type += (char) i;
                } else {
                    signature += (char) i;
                }
            }
        }
        file.close();
    }

    public static String getFileSignature(String path) throws Exception {
        FileInputStream file = new FileInputStream(path);
        byte[] bytes = new byte[8];
        int bytesRead = file.read(bytes);
        if (bytesRead == -1) {
            System.err.println("File is empty.");
            System.exit(-1);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bytesRead; i++) {
            sb.append(String.format("%02X", bytes[i]));
        }
        file.close();
        return sb.toString();
    }

    public static void writeResult(List<String> list) throws Exception {
        FileOutputStream file = new FileOutputStream("result.txt");
        boolean processed = false;
        String type = "";
        for (String signature : list) {
            for (Map.Entry<String, String> entry : signatures.entrySet()) {
                if (signature.startsWith(entry.getValue())) {
                    processed = true;
                    type = entry.getKey();
                    break;
                }
            }
            if (processed) {
                file.write(type.getBytes());
                file.write('\n');
            } 
        }
        file.close();
    }

    public static void printResult(String signature) throws Exception {

        boolean processed = false;


        for (Map.Entry<String, String> entry : signatures.entrySet()) {
            if (signature.startsWith(entry.getValue())) {
                processed = true;
                break;
            }
        }
        if (processed) {
            System.out.println("PROCESSED");

        } else {
            System.out.println("UNDEFINED");
        }
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        try {
            readSignatures();
            if (signatures.size() < 10) {
                throw new NotEnoughAnalysisDataException();
            }
            while (true) {
                String input = scanner.nextLine();
                if (input.equals("42")) {
                    break;
                }
                String signature = getFileSignature(input);

                list.add(signature);
                printResult(signature);
            }
            writeResult(list);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
