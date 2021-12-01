package Stream;

import java.util.*;

public class package Stream;

import java.util.*;

public class StreamUsecase {
    public static void main(String[] args) {
        
        Map<Integer,String> marks = new LinkedHashMap<>();
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
        
        System.out.println("Details of Students==> "+marks);    
                
            double sum=marks.keySet().stream()
                        .mapToInt(i->i)
                        .sum();
                System.out.println("Class Average : "+sum/limit);

        marks.keySet().stream()
                .mapToInt(i->i)
                .max()
                .ifPresent(System.out::println);

        IntSummaryStatistics summaryStatistics=marks.keySet().stream().sorted()
                                                        .mapToInt(i->i)
                                                        .summaryStatistics();
        System.out.println(summaryStatistics);
    }
}
 {
    public static void main(String[] args) {
        
        Map<Integer,String> marks = new LinkedHashMap<>();
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
        
        System.out.println("Details of Students==> "+marks);    
                
            double sum=marks.keySet().stream()
                        .mapToInt(i->i)
                        .sum();
                System.out.println("Class Average : "+sum/limit);

        marks.keySet().stream()
                .mapToInt(i->i)
                .max()
                .ifPresent(System.out::println);

        IntSummaryStatistics summaryStatistics=marks.keySet().stream().sorted()
                                                        .mapToInt(i->i)
                                                        .summaryStatistics();
        System.out.println(summaryStatistics);
    }
}
