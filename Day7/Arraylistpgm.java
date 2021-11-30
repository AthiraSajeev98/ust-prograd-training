package Collections_List;

import java.util.ArrayList;
import java.util.List;

public class Arraylistpgm {
        public static void main(String[] args) {

            ArrayList<Integer> arrayList=new ArrayList<Integer>(20);
            ArrayList<Integer> arrayList1=new ArrayList<Integer>(List.of(10,20,30,40));

            arrayList.add(1);
            arrayList.add(0,0);
            arrayList.add(2);
            arrayList.add(3);
            arrayList.addAll(arrayList1);
            System.out.println(arrayList);

//        for (int i = 0; i < arrayList.size(); i++) {
//            System.out.println(arrayList.get(i));
//        }
//
//        for (Integer x:arrayList) {
//            System.out.println(x);
//        }

//        for (Iterator<Integer> it = arrayList.iterator();it.hasNext();) {
//            System.out.println(it.next());
//        }
            arrayList.forEach(n-> check(n));
        }
    static  void  check (int n){
        if (n<=60)
            System.out.print(n);
        }
    }

