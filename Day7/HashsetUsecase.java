package Collection_Set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class HashsetUsecase {
    public static void main(String[] args) {
        HashSet<String> setHash=new HashSet();
        Scanner scanner=new Scanner(System.in);
        System.out.print("Enter the limit : ");
        int limit = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < limit; i++) {
        System.out.print("Enter the numbers in words from one : ");
        String number= scanner.nextLine();
        setHash.add(number);
        }
        setHash.remove("one");
        Iterator<String> i=setHash.iterator();
        while(i.hasNext())
        {
            System.out.println(i.next());
        }
    }
}