import java.math.BigInteger;

class Spiral {
    public static BigInteger sum(BigInteger size) {
        size = size.add(BigInteger.ONE);
        size = size.multiply(size);
        size = size.divide(BigInteger.TWO);
        size = size.subtract(BigInteger.ONE);
        return size;
    }
}