package Factory.Monsters.D;
import Factory.Monsters.Monster;


public class GiantScorpion extends Monster {
    public GiantScorpion(String monsterType) {

        super("Giant Scorpion");

        this.monsterhp = 1500;
        this.monsterdmg = 750;
        this.monsterlevel = 7;
        this.monsterexpvalue = 450;
    }
}
