package Collection_Set;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;

public class LinkedHashSetpgm {
    public static void main(String[] args) {
        LinkedHashSet<Integer> linkedHashSet=new LinkedHashSet<Integer>();
        linkedHashSet.add(5);
        linkedHashSet.add(10);
        linkedHashSet.addAll(List.of(2,4,6,8));
        linkedHashSet.add(-10);
        linkedHashSet.add(-8);
        System.out.println(linkedHashSet);
    }
}
