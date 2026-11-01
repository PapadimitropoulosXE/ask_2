package A21;

public class Sphere extends SolidShape {
    private double radius;

    public Sphere(double x, double y, double z, double radius) { super(x, y, z); this.radius = radius; }
    public double getRadius() { return radius; }
    public void setRadius(double radius) { this.radius = radius; }
    @Override public int getNumberOfFaces() { return 1; }
    @Override public double getVolume() { return (4.0 / 3.0) * Math.PI * Math.pow(radius, 3); }
    @Override public String toString() { return "Sphere " + super.toString() + "\nradius : " + radius; }
}