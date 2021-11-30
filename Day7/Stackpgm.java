package Collections_List;

import java.util.Stack;

public class Stackpgm {
    public static void main(String[] args) {
        Stack<String> stack=new Stack<String>();
        stack.push("Apple");
        stack.push("Orange");
        stack.push("Grapes");
        stack.push("Banana");
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        System.out.println(stack.isEmpty());
        System.out.println(stack.indexOf("Grapes"));


    }
}
