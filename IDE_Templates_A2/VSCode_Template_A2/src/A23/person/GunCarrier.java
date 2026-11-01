package A23.person;

import A23.armor.Gun;

public class GunCarrier {
    private Gun gun;

    public GunCarrier(Gun gun) {
        this.gun = gun;
    }

    public Gun getGun() {
        return gun;
    }

    public void setGun(Gun gun) {
        this.gun = gun;
    }
}