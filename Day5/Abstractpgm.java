abstract  class Flowers {
    abstract void name();

    abstract void colour();

    void from() {
        System.out.println("From plants");
    }
}

class Jasmine extends Flowers{

    void from() {
        System.out.println("From Jasmine plant");}

        void name() {
        System.out.println("Jasmine");
    }

    void colour() {
        System.out.println("White");
    }
}

class Rose extends Flowers{

    void from() {
        System.out.println("From Rose plants");}

    @Override
    void name() {
        System.out.println("Rose");
    }

    @Override
    void colour() {
        System.out.println("Red,White,Yellow etc");
    }
}

class Hibiscus extends Flowers{

        @Override
        void name() {
            System.out.println("Hibiscus");
        }

        @Override
        void colour() {
            System.out.println("Red");
        }
    }


public class Abstractpgm{
    public static void main(String[] args) {
        Flowers jasmine = new Jasmine();
        Flowers hibiscus= new Hibiscus();
        Flowers rose= new Rose();

        jasmine.from();
        jasmine.name();
        jasmine.colour();
        System.out.println("\n");
        hibiscus.from();
        hibiscus.name();
        hibiscus.colour();
        System.out.println("\n");
        rose.from();
        hibiscus.name();
        rose.colour();


    }
}
