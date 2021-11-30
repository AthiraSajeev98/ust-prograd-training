package Collections_List;

import java.util.LinkedList;
import java.util.List;

public class LinkedlistPgm {
    public static void main(String[] args) {
        LinkedList<String> linkedList= new LinkedList<String>();
        LinkedList<String> linkedList1=new LinkedList<String>(List.of("10","20","30"));
        linkedList.add("apple");
        linkedList.add("mango");
        linkedList.add("grapes");
        linkedList.add("orange");
        linkedList.add("fig");
        System.out.println(linkedList);
        System.out.println(linkedList.indexOf("fig"));



    }
}

