package Collections_List;

import java.util.Vector;

public class Vectorpgm {
    public static void main(String[] args) {
        Vector<String> vector=new Vector<String>(8);
        vector.add("Rose");
        vector.add("Jasmine");
        vector.add("Lilly");
        vector.addElement("Dalia");
//        System.out.println(vector);
//        System.out.println(vector.capacity());
//        System.out.println(vector.size());
//        System.out.println(vector.firstElement());
//        System.out.println(vector.lastElement());
//        System.out.println(vector.contains("potato"));
//        System.out.println(vector.removeElement("Dalia"));
        vector.forEach(y -> System.out.println(y));
    }
}
