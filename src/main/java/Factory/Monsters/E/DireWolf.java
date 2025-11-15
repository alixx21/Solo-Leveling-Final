package Factory.Monsters.E;

import Factory.Monsters.Monster;

public class DireWolf extends Monster {
    public DireWolf(String monsterType) {
        super("DireWolf");

        this.monsterhp=550;
        this.monsterdmg = 350;
        this.monsterlevel=3;
        this.monsterexpvalue=200;
    }
}
