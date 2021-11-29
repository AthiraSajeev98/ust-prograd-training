import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
 Scanner scanner =new Scanner(System.in);
        try{
            int x=new Integer(scanner.nextInt());
            int y=new Integer(scanner.nextInt());
            System.out.println(x/y);
        }catch(InputMismatchException e){
            System.out.println("java.util.InputMismatchException");
        }catch(Exception e){
            System.out.println(e);
        }
    }
}