package Factory.Monsters.B;
import Factory.Monsters.Monster;


public class Cerber extends Monster {
    public Cerber(String monsterType) {
        super("Cerber");

        this.monsterhp = 5000;
        this.monsterdmg = 2100;

        this.monsterlevel = 18;
        this.monsterexpvalue = 1500;
    }
}
