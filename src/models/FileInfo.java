package models;

public class FileInfo {
    // Name of the file (e.g., Resume.pdf)
    private String fileName;

    // File extension (e.g., pdf, docx, jpg)
    private String extension;

    // Full path to the file
    private String path;

    // File size in bytes
    private long size;

    // File creation date (stored as String for Version 1)
    private String createdDate;

    // File last modified date
    private String modifiedDate;

    /**
     * Constructor to initialize all file details.
     */
    public FileInfo(String fileName,
                    String extension,
                    String path,
                    long size,
                    String createdDate,
                    String modifiedDate) {

        this.fileName = fileName;
        this.extension = extension;
        this.path = path;
        this.size = size;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
    }

    // ---------------- GETTERS ----------------

    public String getFileName() {
        return fileName;
    }

    public String getExtension() {
        return extension;
    }

    public String getPath() {
        return path;
    }

    public long getSize() {
        return size;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public String getModifiedDate() {
        return modifiedDate;
    }

    // --------------- toString() ----------------

    /**
     * Returns the file details in a readable format.
     */
    @Override
    public String toString() {
        return "FileInfo{" +
                "fileName='" + fileName + '\'' +
                ", extension='" + extension + '\'' +
                ", path='" + path + '\'' +
                ", size=" + size +
                ", createdDate='" + createdDate + '\'' +
                ", modifiedDate='" + modifiedDate + '\'' +
                '}';
    }
}
