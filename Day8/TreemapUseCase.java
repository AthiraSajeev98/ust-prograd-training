package Collection_Map;

import java.util.Scanner;
import java.util.TreeMap;

public class TreemapUseCase {
    public static void main(String[] args) {
        TreeMap<Integer,String> marks = new TreeMap<Integer,String>();
        Scanner scanner=new Scanner(System.in);
        System.out.print("Enter the number of students : ");
        int limit = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= limit; i++) {
            System.out.print("Enter Total Mark obtained by Reg.No"+i+" on 100 : ");
            int k = Integer.parseInt(scanner.nextLine());
            System.out.print("Enter The Name : ");
            String v = scanner.nextLine();
            marks.put(k,v);
        }

//        System.out.println(marks);
//        System.out.println(marks.descendingKeySet());
        System.out.println("Students with low CGPA----> "+marks.headMap(44));
        System.out.println("Students with Average CGPA----> "+marks.subMap(45,69));
        System.out.println("Students Eligible for Scholarship----> "+marks.tailMap(70));
    }
}
