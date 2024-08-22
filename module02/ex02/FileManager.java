package module02.ex02;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

public class FileManager {
    private File currentDir;
    private Scanner scanner = new Scanner(System.in);

    public FileManager(String path) {
        this.currentDir = new File(path);
    }

    public void listContent() throws Exception {
        File[] files = currentDir.listFiles();
        for (File file : files) {
            System.out.print(file.getName());
            System.out.print(" ");
            System.out.print(file.length() * 1024);
            System.out.println(" KB");
        }
    }

    public void changeDirectory(String path) throws Exception {
        File newDir;
        if (path.startsWith("/")) {

            newDir = new File(path);
        } else {

            newDir = new File(this.currentDir, path).getCanonicalFile();
        }

        if (newDir.exists() && newDir.isDirectory()) {
            this.currentDir = newDir;
            System.out.println(this.currentDir.getCanonicalPath());
        } else {
            System.err.println("Directory does not exist: " + newDir.getCanonicalPath());
        }
    }

    public void moveDirectory(String what, String where) throws Exception {
        File source = new File(this.currentDir, what);
        File destination = new File(this.currentDir, where);

        if (!source.exists()) {
            System.err.println("Source file does not exist: " + source.getCanonicalPath());
            return;
        }
        if (source.exists() && source.isFile() && destination.exists() && destination.isDirectory()) {
            Files.move(source.toPath(), destination.toPath().resolve(source.getName()),
                    StandardCopyOption.REPLACE_EXISTING);
        } else {
            source.renameTo(destination);
        }
    }

    public void exit() {
        scanner.close();
        System.exit(0);
    }

    public void application() throws Exception {
        while (true) {
            String option = scanner.nextLine();
            String[] options = option.split(" ");
            switch (options[0]) {
                case "ls":
                    listContent();
                    break;
                case "cd":
                    changeDirectory(options[1]);
                    break;
                case "mv":
                    if (options.length != 3) {
                        System.out.println("Invalid arguments");
                        break;
                    }
                    moveDirectory(options[1], options[2]);
                    break;
                case "exit":
                    exit();
                    break;
                default:
                    break;
            }
        }

    }
}
