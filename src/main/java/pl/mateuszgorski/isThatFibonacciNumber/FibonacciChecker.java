package pl.mateuszgorski.isThatFibonacciNumber;


import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;


public class FibonacciChecker {

    public Set<BigInteger> setOfFibonacci = new HashSet<>();

    public FibonacciChecker() {
        this.constructFibonacci();
    }

    private void constructFibonacci() {
        Long maxInputLong = Long.MAX_VALUE;
        BigInteger maxInputBigInteger = BigInteger.valueOf(maxInputLong);
        BigInteger previousFib = BigInteger.valueOf(1L);
        BigInteger currentFib = BigInteger.valueOf(1L);
        BigInteger temp = currentFib;
        setOfFibonacci.add(BigInteger.valueOf(0));
        setOfFibonacci.add(previousFib);
        setOfFibonacci.add(currentFib);
        while (currentFib.compareTo(maxInputBigInteger) < 0) {
            temp = currentFib;
            currentFib = currentFib.add(previousFib);
            previousFib = temp;
            System.out.println(currentFib);
            setOfFibonacci.add(currentFib);
        }
    }

    public boolean checkIfFibonacci(long number) {
        if (number >= 0) {
            if (setOfFibonacci.contains(BigInteger.valueOf(number))) {
                System.out.println("true");
                return true;
            }
            System.out.println("false");
            return false;
        } else {
            throw new IllegalArgumentException("number has to be higher then zero");
        }
    }

    public static void main(String[] args) {
        FibonacciChecker fibonacciChecker = new FibonacciChecker();
        fibonacciChecker.checkIfFibonacci(-1);
    }
}