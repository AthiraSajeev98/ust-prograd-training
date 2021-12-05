package File;

import jdk.internal.module.ModuleInfoExtender;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Employeemanagment {

    public static void main(String[] args) throws IOException {
        File file=new File("D:\\UST-Prograds-Training\\src\\Day9\\Employee.txt");
        FileWriter writer = new FileWriter(file, true);
        FileReader reader = new FileReader(file);
        //StringBuffer stringBuffer = new StringBuffer();
        Scanner scanner = new Scanner(System.in);


        System.out.print("1.Read Details 2.Add Details 3.Update Details : ");
        int choice= Integer.parseInt(scanner.nextLine());


        switch (choice) {
            case 1 -> {
                int rd = reader.read();
                if (rd != -1) {
                    Scanner scanner1 = new Scanner(file);
                    System.out.println(scanner1.nextLine());
                    while (scanner1.hasNext()) {
                        System.out.println(scanner1.nextLine());
                    }
                } else {
                    System.out.println("File is Empty");
                }
                reader.close();
            }
            case 2 -> {
                System.out.print("Enter the name : ");
                String w = scanner.nextLine();
                writer.append(w);
                writer.append("\n");
                System.out.print("Enter the employee ID : ");
                String r = scanner.nextLine();
                writer.append(r);
                writer.append("\n");
                System.out.print("Enter the Mobile Number : ");
                String i = scanner.nextLine();
                writer.append(i);
                writer.append("\n");
                System.out.print("Enter the age : ");
                String t = scanner.nextLine();
                writer.append(t);
                writer.append("\n");
                writer.close();
            }

//             case 3 ->{
//                 System.out.println("Please enter the contents of a line you would like to edit: ");
//                 String lineToEdit = scanner.nextLine();
//
//                 System.out.println("Please enter the the replacement text: ");
//                 String textToReplace = scanner.nextLine();
//
//
//
//             }

            default -> System.out.println("Please enter the correct choice");
        }
    }
}

