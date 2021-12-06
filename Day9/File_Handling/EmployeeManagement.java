package File;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class EmployeeManagement {

    public static void main(String[] args) throws IOException {
        File file = new File("D:\\UST-Prograds-Training\\src\\Day9\\File_Handling\\Employee.txt");
        file.createNewFile();
        FileReader reader = new FileReader(file);
        FileWriter writer = new FileWriter(file, true);
        Scanner scanner = new Scanner(System.in);


        System.out.print("1.Read Details 2.Add Details 3.Update Details : ");
        int choice = Integer.parseInt(scanner.nextLine());

        switch (choice) {
            case 1 -> {
                int rd = reader.read();
                if (rd == -1) {
                    System.out.println("File Empty");
                } else {
                    Scanner scannerFile = new Scanner(file);
                    while (scannerFile.hasNext()) {
                        System.out.println(scannerFile.nextLine());
                    }
                }
            }
            case 2 -> {
                System.out.print("Enter Employee Name : ");
                String name = scanner.nextLine();
                writer.write(name);
                writer.append("\n");
                System.out.print("Enter Employee ID : ");
                String id = scanner.nextLine();
                writer.write(id);
                writer.append("\n");
                writer.close();
            }
            case 3 -> {
                System.out.println("Please enter the contents of a line you would like to edit: ");
                String lineToEdit = scanner.nextLine();
                System.out.println("Please enter the the replacement text: ");
                String textToReplace = scanner.nextLine();
                Scanner scannerFile = new Scanner(file);
                while (scannerFile.hasNext()) {
                    String existing = scannerFile.nextLine();
                    if (existing.contains(lineToEdit)) {
                        writer.write(textToReplace);
                    }
                }
                System.out.println("Line to edit not found..!");

                writer.close();
            }
        }
    }
}
