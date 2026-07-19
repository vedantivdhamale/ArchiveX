import models.FileInfo;
import services.ArchiveManager;
import services.FileScanner;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        ArchiveManager manager = new ArchiveManager();

        FileScanner scanner = new FileScanner();

        System.out.print("Enter folder path: ");

        String folderPath = input.nextLine();

        ArrayList<FileInfo> files = scanner.scanFolder(folderPath);

        manager.storeFiles(files);

        while (true) {

            System.out.println("\n========== ArchiveX ==========");
            System.out.println("1. Display All Files");
            System.out.println("2. Search File");
            System.out.println("3. Prefix Search");
            System.out.println("4. Delete File");
            System.out.println("5. Undo Delete");
            System.out.println("6. Add File to Backup Queue");
            System.out.println("7. Process Backup");
            System.out.println("8. Display Folder Tree");
            System.out.println("9. Total Files");
            System.out.println("10. Exit");

            System.out.print("\nEnter choice: ");

            int choice = input.nextInt();
            input.nextLine();

            switch (choice) {

                case 1:

                    manager.displayAllFiles();

                    break;

                case 2:

                    System.out.print("Enter filename: ");

                    String fileName = input.nextLine();

                    FileInfo found = manager.searchFile(fileName);

                    if (found != null)

                        System.out.println(found);

                    else

                        System.out.println("File not found.");

                    break;

                case 3:

                    System.out.print("Enter prefix: ");

                    manager.searchByPrefix(input.nextLine());

                    break;

                case 4:

                    System.out.print("Enter filename: ");

                    manager.deleteFile(input.nextLine());

                    break;

                case 5:

                    manager.undoDelete();

                    break;

                case 6:

                    System.out.print("Enter filename: ");

                    manager.addToBackupQueue(input.nextLine());

                    break;

                case 7:

                    manager.processBackup();

                    break;

                case 8:

                    manager.displayFolderTree();

                    break;

                case 9:

                    System.out.println("Total Files : " + manager.totalFiles());

                    break;

                case 10:

                    System.out.println("Thank you for using ArchiveX!");

                    input.close();

                    return;

                default:

                    System.out.println("Invalid choice.");

            }

        }

    }

}