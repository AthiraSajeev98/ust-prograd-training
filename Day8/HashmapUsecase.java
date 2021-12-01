package Collection_Map;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HashmapUsecase {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>(10);
        Scanner scanner = new Scanner(System.in);
        while (map.size() < 5) {
            System.out.print("Enter the number of Passengers : ");
            int limit = Integer.parseInt(scanner.nextLine());

            outerloop:
            for (int i = 1; i <= limit; i++) {
                System.out.print("Enter the ID for user" + i + " : ");
                int k = Integer.parseInt(scanner.nextLine());

                for (Map.Entry<Integer, String> ky : map.entrySet()) {
                    {
                        int key = ky.getKey();
                        if (map.containsKey(k)) {
                            System.out.println("Enter unique user ID");
                            break outerloop;
                        }
                    }
                }
                System.out.print("Enter The Name : ");
                String v = scanner.nextLine();
                map.put(k, v);
            }
        }

                System.out.println("X--------Reached Maximum Limit--------X");

        System.out.println("Confirmed Passengers ==> "+map);
    }
}
