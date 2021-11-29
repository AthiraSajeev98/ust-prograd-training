interface Fruits{
    void name();
    void from();
}
class Apple implements Fruits{

    @Override
    public void name() {
        System.out.println("Apple");
    }
    @Override
    public void from() {
        System.out.println("Apple Tree");

    }
}

class Orange implements Fruits{

    @Override
    public void name() {
        System.out.println("Orange");
    }

    @Override
    public void from() {
        System.out.println("Orange Tree");
    }
}

public class Interfacepgm {
    public static void main(String[] args) {
        Fruits apple=new Apple();
        Fruits orange=new Orange();

        apple.name();
        apple.from();
        System.out.println("\n");
        orange.name();
        orange.from();
    }
}
