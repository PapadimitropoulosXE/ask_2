package A24;

import java.io.File;

// HY252 - A2 - Exercise 4
public class FileStats {

    public static void listFilesForFolder(File folder) {
        for (File fileEntry : folder.listFiles()) {
            if (fileEntry.isDirectory()) {
                listFilesForFolder(fileEntry);
            } else {
                System.out.println(fileEntry.getAbsolutePath());
            }
        }
    }

    public static void main(String[] args) {
        File folder = new File("C:\\temp\\");
        listFilesForFolder(folder);
    }
}
