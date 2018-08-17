package pl.mateuszgorski.figures;

public class Triangle implements Figure {

    private double base;
    private double height;

    public Triangle(double base, double height) {
        if (base <= 0 || height <= 0) {
            throw new IllegalArgumentException("Height and base must be positive Integers");
        }
        this.base = base;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return 0.5 * base * height;
    }
}