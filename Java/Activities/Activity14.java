package activities;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class Activity14 {
    public static void main(String[] args) throws IOException {
        try {
            String filePath = "src/main/java/activities/Activity14NewFile.txt";
            File file = new File(filePath);
            boolean fStatus = file.createNewFile();
            if (fStatus) {
                System.out.println("File created successfully!");
            } else {
                System.out.println("File already exists at this path.");
            }
            File fileUtil = FileUtils.getFile(filePath);

            //Read file
            System.out.println("Data in file: " + FileUtils.readFileToString(fileUtil, "UTF8"));
            //Create directory
            File destDir = new File("resources");
            //Copy file to directory
            FileUtils.copyFileToDirectory(file, destDir);
            //Get file from new directory
            File newFile = FileUtils.getFile(destDir, "Activity14NewFile.txt");
            String newFileData = FileUtils.readFileToString(newFile, "UTF8");
            System.out.println("Data in new file: " + newFileData);
        } catch (IOException errMessage) {
            System.out.println(errMessage);
        }

    }
}
