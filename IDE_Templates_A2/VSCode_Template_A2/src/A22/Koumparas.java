package A22;

/**
 * An Abstract Data Type (ADT) representing a piggy bank (Koumparas).
 * 
 * <p><b>Invariants (equational axioms):</b>
 * <ul>
 *   <li>{@code getCapacity() > 0}</li>
 *   <li>{@code 0 <= getNumberOfCoins() && getNumberOfCoins() <= getCapacity()}</li>
 *   <li>If a koumparas is broken ({@code isBroken() == true}), its total money can be retrieved, 
 *       and no further coins can be added.</li>
 *   <li>If a koumparas is not broken ({@code isBroken() == false}), its total money cannot be seen.</li>
 * </ul>
 * </p>
 */
public class Koumparas {
    private int capacity;
    private double[] coins;
    private int currentCount;
    private boolean broken;

    /**
     * Constructor: Creates a new Koumparas with a specified capacity.
     * 
     * @param capacity the maximum number of coins/notes the koumparas can hold
     * @pre {@code capacity > 0}
     * @post {@code getCapacity() == capacity && getNumberOfCoins() == 0 && !isBroken() && !isFull()}
     * @throws IllegalArgumentException if capacity <= 0
     */
    public Koumparas(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be greater than 0.");
        }
        this.capacity = capacity;
        this.coins = new double[capacity];
        this.currentCount = 0;
        this.broken = false;
    }

    /**
     * Transformer: Adds money (coin or note value) to the koumparas.
     * 
     * @param amount the value of the coin or note to add
     * @pre {@code !isBroken() && !isFull() && amount > 0}
     * @post {@code getNumberOfCoins() == old(getNumberOfCoins()) + 1}
     * @throws KoumparasIsBrokenException if the koumparas is broken
     * @throws KoumparasIsFullException if the koumparas is full
     * @throws IllegalArgumentException if amount <= 0
     */
    public void add(double amount) {
        if (broken) {
            throw new KoumparasIsBrokenException("Cannot add money to a broken koumparas.");
        }
        if (isFull()) {
            throw new KoumparasIsFullException("Koumparas is full.");
        }
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be positive.");
        }
        coins[currentCount] = amount;
        currentCount++;
    }

    /**
     * Transformer: Breaks the koumparas.
     * 
     * @pre {@code !isBroken()}
     * @post {@code isBroken() == true}
     * @throws KoumparasIsBrokenException if the koumparas is already broken
     */
    public void breakKoumparas() {
        if (broken) {
            throw new KoumparasIsBrokenException("Koumparas is already broken.");
        }
        this.broken = true;
    }

    /**
     * Observer: Checks if the koumparas is full.
     * 
     * @return true if current count equals capacity, false otherwise
     * @post returns {@code (currentCount == capacity)}
     */
    public boolean isFull() {
        return currentCount >= capacity;
    }

    /**
     * Observer: Checks if the koumparas is broken.
     * 
     * @return true if broken, false otherwise
     * @post returns {@code broken}
     */
    public boolean isBroken() {
        return broken;
    }

    /**
     * Observer: Checks if the koumparas is intact (not broken).
     * 
     * @return true if not broken, false otherwise
     * @post returns {@code !broken}
     */
    public boolean isIntact() {
        return !broken;
    }

    /**
     * Accessor: Returns the total value of money inside the koumparas.
     * Can only be called if the koumparas is broken.
     * 
     * @return the sum of all coin/note values inside
     * @pre {@code isBroken()}
     * @throws KoumparasIsNotBrokenException if the koumparas is not broken
     */
    public double getTotalMoney() {
        if (!broken) {
            throw new KoumparasIsNotBrokenException("Cannot see the money unless the koumparas is broken.");
        }
        double total = 0;
        for (int i = 0; i < currentCount; i++) {
            total += coins[i];
        }
        return total;
    }

    /**
     * Accessor: Returns the capacity of the koumparas.
     * 
     * @return the maximum capacity
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * Accessor: Returns the current number of items inside.
     * 
     * @return current number of coins/notes
     */
    public int getNumberOfCoins() {
        return currentCount;
    }
}