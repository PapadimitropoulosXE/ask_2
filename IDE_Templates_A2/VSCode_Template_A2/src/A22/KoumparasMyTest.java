package A22;

public class KoumparasMyTest {
    public static void main(String[] args) {
        System.out.println("Running Koumparas tests...");

        // Dokimi 1: Prosthiki xrimaton kai elegxos oti den mporeis na deis ta xrima an den ton spaseis
        Koumparas k = new Koumparas(5);
        k.add(1.0);
        k.add(2.0);
        System.out.println(k.isIntact()); // true

        try {
            k.getTotalMoney();
        } catch (KoumparasIsNotBrokenException e) {
            System.out.println("Caught expected exception: " + e.getMessage());
        }

        // Dokimi 2: Spasimo koumpara kai emfanisi xrimaton
        k.breakKoumparas();
        System.out.println("Total money after breaking: " + k.getTotalMoney()); // 3.0

        // Dokimi 3: Prosthiki xrimaton se spasmeno koumpara (prepei na apotyxei)
        try {
            k.add(5.0);
        } catch (KoumparasIsBrokenException e) {
            System.out.println("Caught expected exception: " + e.getMessage());
        }

        // Dokimi 4: Gemisma koumpara kai KoumparasIsFullException
        Koumparas kFull = new Koumparas(2);
        kFull.add(0.50);
        kFull.add(1.00);
        try {
            kFull.add(2.00);
        } catch (KoumparasIsFullException e) {
            System.out.println("Caught expected exception: " + e.getMessage());
        }

        System.out.println("All basic tests completed successfully.");
    }
}