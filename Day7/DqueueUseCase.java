package Collection_Queue;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DqueueUseCase {
    public static void main(String[] args) {

        ArrayDeque<Integer> age = new ArrayDeque<Integer>(10);
        ArrayDeque<Integer> age1 = new ArrayDeque<Integer>(10);
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter no of users : ");
        int n = Integer.parseInt(scanner.nextLine());
        if(n<=10) {
            for (int i = 0; i < n; i++) {
                System.out.print("Enter the Age : ");
                int userage = Integer.parseInt(scanner.nextLine());
                age.add(userage);
            }
            for (Integer x : age) {

                if (x >= 18) {
                   age1.add(x);
               }
           }
            System.out.println("NotAllowed : "+age.removeAll(age1));
            System.out.println("NotAllowed : "+age);
            System.out.println("Allowed: "+ age1);
        }
        else {System.out.println("X----Number of users cannot be more than 10----X");}
    }
}

