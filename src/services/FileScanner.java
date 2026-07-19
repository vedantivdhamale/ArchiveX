package services;

import models.FileInfo;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class FileScanner {

    /**
     * Scans the given folder and returns a list of FileInfo objects.
     */
    public ArrayList<FileInfo> scanFolder(String folderPath) {

        ArrayList<FileInfo> filesList = new ArrayList<>();

        File folder = new File(folderPath);

        // Check if the path exists and is a directory
        if (!folder.exists() || !folder.isDirectory()) {
            System.out.println("Invalid folder path.");
            return filesList;
        }

        File[] files = folder.listFiles();

        if (files == null) {
            return filesList;
        }

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

        for (File file : files) {

            // Skip folders for Version 1
            if (file.isFile()) {

                String fileName = file.getName();

                String extension = "";

                int dotIndex = fileName.lastIndexOf('.');

                if (dotIndex != -1) {
                    extension = fileName.substring(dotIndex + 1);
                }

                String path = file.getAbsolutePath();

                long size = file.length();

                String createdDate = formatter.format(file.lastModified());

                String modifiedDate = formatter.format(file.lastModified());

                FileInfo fileInfo = new FileInfo(
                        fileName,
                        extension,
                        path,
                        size,
                        createdDate,
                        modifiedDate
                );

                filesList.add(fileInfo);
            }
        }

        return filesList;
    }
}