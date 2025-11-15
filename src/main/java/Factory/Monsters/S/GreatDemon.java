package Factory.Monsters.S;
import Factory.Monsters.Monster;


public class GreatDemon extends Monster {
    public GreatDemon(String monsterType) {
        super("GreatDemon");
        this.monsterhp = 15000;
        this.monsterdmg = 5500;
        this.monsterlevel = 45;
        this.monsterexpvalue = 7000;
    }
}
