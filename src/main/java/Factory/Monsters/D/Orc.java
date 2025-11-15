package Factory.Monsters.D;

import Factory.Monsters.Monster;


public class Orc extends Monster {
    public Orc(String monsterType) {
        super("Orc");
        this.monsterhp = 1200;
        this.monsterdmg = 600;
        this.monsterlevel = 6;
        this.monsterexpvalue = 350;
    }
}
