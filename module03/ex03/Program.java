package module03.ex03;

import java.util.*;
import java.io.*;
import java.util.concurrent.*;

public class Program {

    private static HashMap<String, Boolean> urls = new HashMap<String, Boolean>();

    public static void createUrlsList() throws Exception {
        FileReader fileReader = new FileReader("files_urls.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            urls.put(line, false);
        }
        bufferedReader.close();
        fileReader.close();
    }

    public static void printUrlsList() {
        for (String url : urls.keySet()) {
            System.out.println("url: " + url);
        }
    }

    public static void main(String[] args) {
        try {
            if (args.length != 1) {
                throw new IllegalArgumentNumberException();
            }
            String[] arguments = args[0].split("=");
            int threadsCount = Integer.parseInt(arguments[1]);
            createUrlsList();
            ExecutorService executorService = Executors.newFixedThreadPool(threadsCount);
            int i = 0;
            for (String url: urls.keySet()) {
                executorService.submit(new DownloadFileThread(url, i + 1));
                i++;
            }
            executorService.shutdown();
            if (!executorService.awaitTermination(1, TimeUnit.MINUTES)) {
                executorService.shutdownNow();
            }
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
