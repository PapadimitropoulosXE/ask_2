package A21;

public class Tester {
    public static void main(String[] args) {
        System.out.println(new SolidShape(2, 1, 5.12));
        System.out.println(new Sphere(2, 1, 5.12, 10.0));

        // (d.1) (i) Drawing me 50 sfaires opou i sfairea j ehei aktina j (apo 1 eos 50)
        Drawing drawing1 = new Drawing();
        for (int j = 1; j <= 50; j++) {
            drawing1.add(new Sphere(0, 0, 0, j));
        }
        System.out.println("(c-i):");
        System.out.println(drawing1);

        // (d.1) (ii) Drawing me 25 sfaires kai 25 kyvous enallaks
        Drawing drawing2 = new Drawing();
        for (int j = 1; j <= 25; j++) {
            drawing2.add(new Sphere(0, 0, 0, j));
            drawing2.add(new Cube(0, 0, 0, j));
        }
        System.out.println("\n(c-ii):");
        System.out.println(drawing2);

        // (d.2) Paradigma ektuposis toJSON gia to drawing
        // System.out.println(drawing1.toJSON());
    }
}