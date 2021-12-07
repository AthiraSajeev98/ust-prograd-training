public class Rectangle {
    double length;
    double breadth;

    Rectangle(double length, double breadth) {
        this.length = length;
        this.breadth = breadth;
    }

    public double area() {
        if (this.length == 0 || this.breadth == 0) {
            throw new ArithmeticException("Any value cant be 0 ");
        }
        return this.length * this.breadth;
    }

    public double area(double length, double breadth) {
        if (length == 0 || breadth == 0) {
            throw new ArithmeticException("Any value cant be 0 ");
        }
        return length * breadth;
    }

    public double perimeter() {
        if (this.length == 0 || this.breadth == 0) {
            throw new ArithmeticException("Any value cant be 0 ");
        }
        return 2 * (this.length + this.breadth);
    }

    public double perimeter(double length, double breadth) {
        if (length == 0 || breadth == 0) {
            throw new ArithmeticException("Any value cant be 0 ");
        }
        return 2 * (length + breadth);
    }
}


