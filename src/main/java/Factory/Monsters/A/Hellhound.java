package Factory.Monsters.A;
import Factory.Monsters.Monster;


public class Hellhound extends Monster {
    public Hellhound(String monsterType) {
        super("Hellhound");


        this.monsterhp = 8200;
        this.monsterdmg = 3500;
        this.monsterlevel = 28;
        this.monsterexpvalue = 3000;
    }
}
