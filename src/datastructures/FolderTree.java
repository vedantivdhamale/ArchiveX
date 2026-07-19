package datastructures;

import models.FileInfo;

public class FolderTree {

    private FolderNode root;

    public FolderTree(String rootFolder) {
        root = new FolderNode(rootFolder);
    }

    public FolderNode getRoot() {
        return root;
    }

    // Add a folder
    public void addFolder(FolderNode parent, String folderName) {

        FolderNode newFolder = new FolderNode(folderName);

        parent.addChild(newFolder);

    }

    // Add file to folder
    public void addFile(FolderNode folder, FileInfo file) {

        folder.addFile(file);

    }

    // Display tree
    public void displayTree(FolderNode node, String indent) {

        System.out.println(indent + node.getFolderName());

        for (FileInfo file : node.getFiles()) {

            System.out.println(indent + "   -->" + file.getFileName());

        }

        for (FolderNode child : node.getChildren()) {

            displayTree(child, indent + "   ");

        }

    }

}