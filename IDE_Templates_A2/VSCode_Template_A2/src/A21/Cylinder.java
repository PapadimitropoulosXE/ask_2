package A21;

public class Cylinder extends SolidShape {
    private double radius;
    private double height;

    public Cylinder(double x, double y, double z, double radius, double height) { super(x, y, z); this.radius = radius; this.height = height; }
    public double getRadius() { return radius; }
    public void setRadius(double radius) { this.radius = radius; }
    public double getHeight() { return height; }
    public void setHeight(double height) { this.height = height; }
    @Override public int getNumberOfFaces() { return 3; }
    @Override public int getNumberOfVertices() { return 0; }
    @Override public int getNumberOfEdges() { return 2; }
    @Override public double getVolume() { return Math.PI * Math.pow(radius, 2) * height; }
    @Override public String toString() { return "Cylinder " + super.toString() + "\nradius : " + radius + "\nheight : " + height; }
}