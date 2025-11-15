package Factory.Monsters.E;

import Factory.Monsters.Monster;

public class Goblin extends Monster {
    public Goblin(String monsterType) {
        super("Goblin");

        this.monsterhp = 420;
        this.monsterdmg = 250;
        this.monsterlevel = 2;
        this.monsterexpvalue = 120;
    }
}
