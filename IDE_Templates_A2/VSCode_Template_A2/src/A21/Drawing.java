package A21;

public class Drawing {
    private SolidShape[] shapes;
    private int activeCapacity;

    public Drawing() { shapes = new SolidShape[1000]; }
    public void add(SolidShape s) { if (activeCapacity < shapes.length) shapes[activeCapacity++] = s; }
    public int getNumberOfShapes() { return activeCapacity; }
    public int getTotalFaces() { int total = 0; for (int i = 0; i < activeCapacity; i++) total += shapes[i].getNumberOfFaces(); return total; }
    public int getTotalVertices() { int total = 0; for (int i = 0; i < activeCapacity; i++) total += shapes[i].getNumberOfVertices(); return total; }
    public int getTotalEdges() { int total = 0; for (int i = 0; i < activeCapacity; i++) total += shapes[i].getNumberOfEdges(); return total; }
    public double getTotalVolume() { double total = 0; for (int i = 0; i < activeCapacity; i++) total += shapes[i].getVolume(); return total; }

    @Override
    public String toString() {
        return "Number of shapes: " + activeCapacity + "\n"
                + "Total faces: " + getTotalFaces() + "\n"
                + "Total vertices: " + getTotalVertices() + "\n"
                + "Total edges: " + getTotalEdges() + "\n"
                + "Total volume: " + getTotalVolume();
    }

    public String toJSON() {
        StringBuilder sb = new StringBuilder("{\n  \"drawing\": [\n");
        for (int i = 0; i < activeCapacity; i++) {
            SolidShape s = shapes[i];
            sb.append("    {\n      \"x\":").append(s.getX()).append(",\n      \"y\":").append(s.getY()).append(",\n");
            if (s instanceof Sphere) {
                Sphere sp = (Sphere) s;
                sb.append("      \"type\": \"sphere\",\n      \"radius\":").append(sp.getRadius()).append("\n");
            } else if (s instanceof Cube) {
                Cube c = (Cube) s;
                sb.append("      \"type\": \"cube\",\n      \"side\":").append(c.getSide()).append("\n");
            } else if (s instanceof Cylinder) {
                Cylinder cyl = (Cylinder) s;
                sb.append("      \"type\": \"cylinder\",\n      \"radius\":").append(cyl.getRadius())
                        .append(",\n      \"height\":").append(cyl.getHeight()).append("\n");
            }
            sb.append(i < activeCapacity - 1 ? "    },\n" : "    }\n");
        }
        return sb.append("  ]\n}").toString();
    }
}