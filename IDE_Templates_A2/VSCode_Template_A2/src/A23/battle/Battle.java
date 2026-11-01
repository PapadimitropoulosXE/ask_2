package A23.battle;

import A23.armor.HandGun;
import A23.armor.Rifle;
import A23.exception.DeadCharacterException;
import A23.person.HeistMastermind;
import A23.person.HeistMember;
import A23.person.PoliceOfficer;
import A23.person.Member;

public class Battle {
    public static void main(String[] args) {
        System.out.println("=== Ekkinisi Test Maxis ==/n");

        // Dimiourgia omadas liston
        Group robbers = new Group("The Robbers");
        robbers.addMember(new HeistMastermind("The Professor", new HandGun(), 90, 50));
        robbers.addMember(new HeistMember("Berlin", new Rifle(), true, 80, 70));

        // Dimiourgia omadas astynomikon
        Group police = new Group("The Police");
        police.addMember(new PoliceOfficer("Angel", new HandGun(), true, 60, 60));

        System.out.println("Arithmos melwn liston: " + robbers.getSize());
        System.out.println("Arithmos melwn astynomias: " + police.getSize());

        // Dokimi maxis metaksi melwn
        Member r1 = robbers.pickRandomAliveMember();
        Member p1 = police.pickRandomAliveMember();

        if (r1 != null && p1 != null) {
            try {
                System.out.println(r1.getName() + " epitithetai ston " + p1.getName());
                r1.fight(p1);
                System.out.println("Ygeia police meta tin epithesi: " + p1.getHealth());
            } catch (DeadCharacterException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        System.out.println("\n=== Ta test oloklirothikan ===");
    }
}