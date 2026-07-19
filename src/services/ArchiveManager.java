package services;

import datastructures.FolderTree;
import datastructures.MyQueue;
import datastructures.MyStack;
import datastructures.Trie;
import models.FileInfo;

import java.util.ArrayList;
import java.util.HashMap;

public class ArchiveManager {

    // Stores files for exact search
    private HashMap<String, FileInfo> fileMap;

    // Stores deleted files for Undo
    private MyStack<FileInfo> deletedFiles;

    // Stores files for prefix search
    private Trie trie;

    // Stores files waiting for backup
    private MyQueue<FileInfo> backupQueue;

    // Folder hierarchy
    private FolderTree folderTree;

    // Constructor
    public ArchiveManager() {

        fileMap = new HashMap<>();
        deletedFiles = new MyStack<>();
        trie = new Trie();
        backupQueue = new MyQueue<>();

        // Root folder
        folderTree = new FolderTree("Root");
    }

    /**
     * Store all scanned files.
     */
    public void storeFiles(ArrayList<FileInfo> files) {

        for (FileInfo file : files) {

            // HashMap
            fileMap.put(file.getFileName(), file);

            // Trie
            trie.insert(file.getFileName());

            // Folder Tree (Version 1)
            folderTree.getRoot().addFile(file);
        }

        System.out.println(files.size() + " files stored successfully.");
    }

    /**
     * Exact search using HashMap.
     */
    public FileInfo searchFile(String fileName) {

        return fileMap.get(fileName);

    }

    /**
     * Prefix search using Trie.
     */
    public void searchByPrefix(String prefix) {

        ArrayList<String> results = trie.searchPrefix(prefix);

        if (results.isEmpty()) {

            System.out.println("No files found.");

            return;

        }

        System.out.println("\nFiles starting with \"" + prefix + "\"");

        for (String file : results) {

            System.out.println(file);

        }

    }

    /**
     * Delete file.
     */
    public void deleteFile(String fileName) {

        FileInfo file = fileMap.get(fileName);

        if (file == null) {

            System.out.println("File not found.");

            return;

        }

        deletedFiles.push(file);

        fileMap.remove(fileName);

        // Version 1:
        // We are not deleting from Trie.
        // This will be implemented in Version 2.

        System.out.println(fileName + " deleted successfully.");

    }

    /**
     * Undo last delete.
     */
    public void undoDelete() {

        if (deletedFiles.isEmpty()) {

            System.out.println("Nothing to undo.");

            return;

        }

        FileInfo restored = deletedFiles.pop();

        fileMap.put(restored.getFileName(), restored);

        trie.insert(restored.getFileName());

        System.out.println(restored.getFileName() + " restored successfully.");

    }

    /**
     * Add file to backup queue.
     */
    public void addToBackupQueue(String fileName) {

        FileInfo file = fileMap.get(fileName);

        if (file == null) {

            System.out.println("File not found.");

            return;

        }

        backupQueue.enqueue(file);

        System.out.println(fileName + " added to backup queue.");

    }

    /**
     * Process next backup request.
     */
    public void processBackup() {

        FileInfo file = backupQueue.dequeue();

        if (file == null) {

            System.out.println("Backup queue is empty.");

            return;

        }

        System.out.println("Backing up: " + file.getFileName());

    }

    /**
     * Display folder tree.
     */
    public void displayFolderTree() {

        folderTree.displayTree(folderTree.getRoot(), "");

    }

    /**
     * Display every stored file.
     */
    public void displayAllFiles() {

        if (fileMap.isEmpty()) {

            System.out.println("No files available.");

            return;

        }

        for (FileInfo file : fileMap.values()) {

            System.out.println(file);

        }

    }

    /**
     * Total number of files.
     */
    public int totalFiles() {

        return fileMap.size();

    }

}