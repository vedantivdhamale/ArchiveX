package datastructures;

import models.FileInfo;
import java.util.ArrayList;

public class FolderNode {

    private String folderName;

    private ArrayList<FolderNode> children;

    private ArrayList<FileInfo> files;

    public FolderNode(String folderName) {

        this.folderName = folderName;

        children = new ArrayList<>();

        files = new ArrayList<>();
    }

    public String getFolderName() {
        return folderName;
    }

    public ArrayList<FolderNode> getChildren() {
        return children;
    }

    public ArrayList<FileInfo> getFiles() {
        return files;
    }

    public void addChild(FolderNode child) {
        children.add(child);
    }

    public void addFile(FileInfo file) {
        files.add(file);
    }
}