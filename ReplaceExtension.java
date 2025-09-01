import java.io.File;

public class ReplaceExtension {
    public static void main(String[] args) {
        String folderPath = "/Users/murphywong/Desktop/BandVedio/"; // Replace with the path to your folder
        replaceTxtWithJpg(folderPath);
    }

    public static void replaceTxtWithJpg(String folderPath) {
        File folder = new File(folderPath);

        // Check if the folder exists and is a directory
        if (!folder.exists() || !folder.isDirectory()) {
            System.out.println("Invalid folder path: " + folderPath);
            return;
        }

        // Get all files in the folder
        File[] files = folder.listFiles((dir, name) -> name.endsWith(".txt"));
        if (files == null || files.length == 0) {
            System.out.println("No .txt files found in the folder: " + folderPath);
            return;
        }

        // Rename each .txt file to .jpg
        for (File file : files) {
            String fileName = file.getName();
            String newFileName = fileName.replace(".txt", ".jpg");
            File newFile = new File(folder, newFileName);

            if (file.renameTo(newFile)) {
                System.out.println("Renamed: " + fileName + " -> " + newFileName);
            } else {
                System.out.println("Failed to rename: " + fileName);
            }
        }

        System.out.println("File extension replacement completed.");
    }
}
