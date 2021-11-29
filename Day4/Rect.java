package Day4;

class Rectangle{
    public double length;
    public double breadth;

    public Rectangle() {
        length=breadth=1;
    }


    public Rectangle(double length, double breadth) {
        this.length = length;
        this.breadth = breadth;
    }



    public double area(){
        return length*breadth;
    }

    public double perimeter(){
        return 2*(length+breadth);
    }
}

class Cuboid extends Rectangle{
    double height;

    public Cuboid() {
        height=1;
    }


    public Cuboid(double length, double breadth, double height) {      //super()
        super(length, breadth);
        this.height = height;
    }

    public double volume(){
        return area()*height;
    }

}

public class Rect {
    public static void main(String[] args){
        Cuboid cuboid=new Cuboid(5,5,5);
        System.out.println("Length = "+cuboid.length);
        System.out.println("Breadth = "+cuboid.breadth);
        System.out.println("Height = "+cuboid.height);
        System.out.println("Area = "+cuboid.area());
        System.out.println("Perimeter = "+cuboid.perimeter());
        System.out.println("Volume = "+cuboid.volume());
    }
}
