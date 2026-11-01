package A21;

public class Cube extends SolidShape {
    private double side;

    public Cube(double x, double y, double z, double side) { super(x, y, z); this.side = side; }
    public double getSide() { return side; }
    public void setSide(double side) { this.side = side; }
    @Override public int getNumberOfFaces() { return 6; }
    @Override public int getNumberOfVertices() { return 8; }
    @Override public int getNumberOfEdges() { return 12; }
    @Override public double getVolume() { return Math.pow(side, 3); }
    @Override public String toString() { return "Cube " + super.toString() + "\nside : " + side; }
}