package Factory.Monsters.D;
import Factory.Monsters.Monster;


public class Skeleton extends Monster {
    public Skeleton(String monsterType) {
        super("Skeleton");
        this.monsterhp = 950;
        this.monsterdmg = 520;
        this.monsterlevel = 5;
        this.monsterexpvalue = 300;
    }
}
