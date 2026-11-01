package A23.person;

import A23.armor.Gun;
import A23.exception.DeadCharacterException;
import A23.utilities.Utilities;

public abstract class Member extends GunCarrier implements Character {
    private final String name;
    private int health;
    private final boolean bodyArmor;
    private final int iq;
    private final int physicalStrength;

    public Member(String name, int health, Gun gun, boolean bodyArmor, int iq, int physicalStrength) {
        super(gun);
        this.name = name;
        this.health = health;
        this.bodyArmor = bodyArmor;
        this.iq = iq;
        this.physicalStrength = physicalStrength;
    }

    @Override
    public int getHealth() {
        return health;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean isAlive() {
        return health > 0;
    }

    public boolean hasBodyArmor() {
        return bodyArmor;
    }

    @Override
    public void damageHealth(int damage) {
        this.health -= damage;
        if (this.health < 0) {
            this.health = 0;
        }
    }

    @Override
    public int calculateAtomicPower() {
        return iq + physicalStrength;
    }

    public int handleHostage() {
        return Utilities.getRandomVal(-2, 2);
    }

    public void fight(Character adversary) throws DeadCharacterException {
        if (!isAlive()) {
            throw new DeadCharacterException("Member is dead and cannot fight.");
        }

        double gunPower = (getGun() != null) ? getGun().getPower() : 0;

        if (!(adversary instanceof Member)) {
            throw new IllegalArgumentException("Adversary is not an instance of Member.");
        }

        Member advMember = (Member) adversary;
        int damage;

        if (advMember instanceof Insider) {
            damage = 2;
        } else {
            if (advMember.hasBodyArmor()) {
                gunPower = gunPower / 2.0;
            }
            double calculatedDamage = gunPower + calculateAtomicPower() + handleHostage();
            damage = (int) calculatedDamage;
        }

        advMember.damageHealth(damage);
    }
}