package pl.mateuszgorski.figures;

public class Trapezoid implements Figure {
    private double sideA;
    private double sideB;
    private double height;

    public Trapezoid(double sideA, double sideB, double height) {
        if (sideA <= 0 || sideB <= 0 || height <= 0) {
            throw new IllegalArgumentException("Sides and height must be positive Integers");
        }
        this.sideA = sideA;
        this.sideB = sideB;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return 0.5 * (sideA + sideB) * height;
    }
}
