package Factory.Monsters.B;
import Factory.Monsters.Monster;


public class Wyvern extends Monster {
    public Wyvern(String monsterType) {
        super("Wyvern");
        this.monsterhp = 5800;
        this.monsterdmg = 2500;
        this.monsterlevel = 20;
        this.monsterexpvalue = 1800;
    }
}
