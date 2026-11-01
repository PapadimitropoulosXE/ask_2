package A21;

public class SolidShape {
    private double x,y,z;

    public SolidShape(double x, double y, double z) { setX(x); setY(y); setZ(z); }

    public double getX() { return x; }
    public void setX(double x) { this.x = x; }

    public double getY() { return y; }
    public void setY(double y) { this.y = y; }

    public double getZ() { return z; }
    public void setZ(double z) { this.z = z; }

    public int getNumberOfFaces() { return 0; }

    public int getNumberOfVertices() { return 0; }

    public int getNumberOfEdges() { return 0; }
    
    public double getVolume() { return 0.0; }

    @Override
    public String toString() {
        return "Solid shape centered at (" + x + "," + y + "," + z + ") with\n"
                + "faces : " + getNumberOfFaces() + "\n"
                + "vertices: " + getNumberOfVertices() + "\n"
                + "edges : " + getNumberOfEdges() + "\n"
                + "volume : " + getVolume();
    }
}