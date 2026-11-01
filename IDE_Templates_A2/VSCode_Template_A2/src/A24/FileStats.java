package A24;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JFileChooser;

public class FileStats {
    private static int folderCount = 0;
    private static int fileCount = 0;
    private static ArrayList<File> imageFiles = new ArrayList<>();

    public static void listFilesForFolder(File folder, boolean isRoot) {
        File[] entries = folder.listFiles();
        if (entries == null) {
            return;
        }
        for (File fileEntry : entries) {
            if (fileEntry.isDirectory()) {
                if (!isRoot) {
                    folderCount++;
                }
                listFilesForFolder(fileEntry, false);
            } else {
                fileCount++;
                String name = fileEntry.getName().toLowerCase();
                if (name.endsWith(".png") || name.endsWith(".jpg") || name.endsWith(".jpeg") || name.endsWith(".gif")) {
                    imageFiles.add(fileEntry);
                }
            }
        }
    }

    public static void main(String[] args) {
        String selectedPath = Utils.selectAFolderDialog(JFileChooser.DIRECTORIES_ONLY);
        if (selectedPath == null || selectedPath.isEmpty()) {
            System.out.println("Program terminated: No folder selected.");
            return;
        }

        File folder = new File(selectedPath);
        listFilesForFolder(folder, true);

        System.out.println("Plithos fakelon: " + folderCount);
        System.out.println("Plithos archeion: " + fileCount);

        try {
            FileWriter writer = new FileWriter("images.html");
            writer.write("<html><body>\n");
            for (File img : imageFiles) {
                writer.write("<img src=\"" + img.toURI().toString() + "\" alt=\"aa\" height=\"100\">\n");
            }
            writer.write("</body></html>");
            writer.close();
            System.out.println("images.html created successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new GUIskeleton(imageFiles);
            }
        });
    }
}