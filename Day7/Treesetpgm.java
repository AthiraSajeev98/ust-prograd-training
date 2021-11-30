package Collection_Set;

import java.util.HashSet;
import java.util.List;
import java.util.TreeSet;

public class Treesetpgm { //sorted
    public static void main(String[] args) {
        TreeSet<Integer>treeSet= new TreeSet<>();
        treeSet.add(5);
        treeSet.add(10);
        treeSet.addAll(List.of(2,4,6,8));
        treeSet.add(-10);
        treeSet.add(-8);
        System.out.println(treeSet);
    }
}