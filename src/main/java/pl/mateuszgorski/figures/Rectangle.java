package pl.mateuszgorski.figures;

public class Rectangle implements Figure {
    private double sideA;
    private double sideB;

    public Rectangle(double sideA, double sideB) {
        if (sideA <= 0 || sideB <= 0) {
            throw new IllegalArgumentException("Sides must be positive Integers");
        }
        this.sideA = sideA;
        this.sideB = sideB;
    }

    @Override
    public double calculateArea() {
        return sideB * sideA;
    }
}
