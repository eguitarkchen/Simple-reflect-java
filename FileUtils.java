import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;

public class FileUtils {
    public static void main(String[] args) {
        String outputDirectory = "/Users/murphywong/Desktop/BandVedio/";     // Replace with your output directory
        // splitFile(inputFilePath, outputDirectory, numberOfFiles);
        mergeFiles(outputDirectory,"/Users/murphywong/Desktop/BandVedio/mergedFile.mp4");
    }

    public static void mergeFiles(String inputDirectory, String outputFilePath) {
        File directory = new File(inputDirectory);

        // Get all files in the directory that match the naming pattern
        File[] files = directory.listFiles((dir, name) -> name.startsWith("part") && name.endsWith(".jpg"));
        if (files == null || files.length == 0) {
            System.out.println("No files found to merge in the directory: " + inputDirectory);
            return;
        }

        // Sort files by name to ensure correct order (e.g., part001.mp4, part002.mp4,
        // ...)
        Arrays.sort(files, Comparator.comparing(File::getName));

        try (BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(outputFilePath))) {
            byte[] buffer = new byte[1024]; // Buffer to read chunks of data
            int bytesRead;

            for (File file : files) {
                System.out.println("Merging: " + file.getName());
                try (BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(file))) {
                    while ((bytesRead = inputStream.read(buffer)) != -1) {
                        outputStream.write(buffer, 0, bytesRead);
                    }
                }
            }

            System.out.println("Files merged successfully into: " + outputFilePath);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
