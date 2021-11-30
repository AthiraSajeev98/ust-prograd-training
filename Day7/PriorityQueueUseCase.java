package Collection_Queue;

import java.util.ArrayDeque;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class PriorityQueueUseCase {
    public static void main(String[] args) {
        PriorityQueue<Integer> tno = new PriorityQueue<Integer>(10);
        Scanner scanner = new Scanner(System.in);
            for (int i = 0; i < 10; i++) {
                System.out.print("Enter the token number : ");
                int usertno = Integer.parseInt(scanner.nextLine());
                tno.add(usertno);
            }

        for(int i=1;i<=10;i++) {
            if(i<10){
            int n=tno.poll();
            System.out.println(n+" IN");
            System.out.println(tno+" Waiting...");}
            else{
                int n=tno.poll();
                System.out.println(n+" IN");
                System.out.println("Next consultation tomorrow.");}
            }
    }
}
