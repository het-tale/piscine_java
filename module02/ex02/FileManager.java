package module02.ex02;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

public class FileManager {
    private File currentDir;
    private Scanner scanner = new Scanner(System.in);

    public FileManager(String path) throws FileNotFoundException {
        this.currentDir = new File(path);
        if (!this.currentDir.exists()) {
            throw new FileNotFoundException("Directory does not exist: " + path);
        }
        System.out.println(path);
    }

    public long getFolderSize(File dir) {
        File[] files = dir.listFiles();
        long length = 0;
        for (File file : files) {
            if (file.isFile()) {
                length += file.length();
            } else {
                length += getFolderSize(file);
            }
        }
        return length;
    }

    public void listContent() throws Exception {
        File[] files = currentDir.listFiles();
        for (File file : files) {
            System.out.print(file.getName());
            System.out.print(" ");
            double size;
            if (file.isFile()) {
                size = (double) file.length() / 1024;
            } else {
                size = (double) getFolderSize(file) / 1024;
            }
            System.out.print(Math.floor(size * 100) / 100);
            System.out.println(" KB");
        }
    }

    public void changeDirectory(String path) throws Exception {
        File newDir;
        if (path.startsWith("/")) {

            newDir = new File(path);
        } else {

            newDir = new File(this.currentDir, path);
        }

        if (newDir.exists() && newDir.isDirectory()) {
            this.currentDir = newDir;
            System.out.println(this.currentDir.getCanonicalPath());
        } else {
            System.err.println("Directory does not exist: " + path);
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
                    if (options.length != 2) {
                        System.out.println("Invalid arguments");
                        break;
                    }
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
                    System.out.println("Please type a valid option");
                    break;
            }
        }

    }
}
