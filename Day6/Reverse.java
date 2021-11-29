package Day6;

class ReverseArray<R>{
    int length;

    void printArray(R[] arr, int length){

        for (int i = length-1; i>=0; i--) {
            System.out.print(arr[i]);
        }

    }

}

public class Reverse {

    public static void main(String[] args) {

    Integer[] intarray= new Integer[]{1,2,3,4};
    String[] strarray= new String[]{"a","b","c","d"};

    ReverseArray<Integer> arrin=new ReverseArray();
    ReverseArray<String> arrstr=new ReverseArray();

    arrin.printArray(intarray,intarray.length);
        System.out.println("\n");
    arrstr.printArray(strarray,strarray.length);

    }
}



