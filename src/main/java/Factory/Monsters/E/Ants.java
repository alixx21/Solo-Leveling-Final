package Factory.Monsters.E;

import Factory.Monsters.Monster;

public class Ants extends Monster {
    public Ants(String monsterType) {
        super("Large Ant");

        this.monsterhp=300;
        this.monsterdmg = 205;
        this.monsterlevel=2;
        this.monsterexpvalue=80;
    }
}
