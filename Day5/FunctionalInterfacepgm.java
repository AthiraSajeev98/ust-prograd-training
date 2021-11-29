interface Addable {
    public  int addition(int a,int b);
}
public class FunctionalInterfacepgm {
    public static void main(String[] args) {

        Addable add=(int a,int b)->{
            return (a+b);
        };

        int x=10;
        int y=20;

        int sum = add.addition(x,y);
        System.out.println(sum);
    }
}

