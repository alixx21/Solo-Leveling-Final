package Factory.Monsters.A;
import Factory.Monsters.Monster;


public class DarkElf extends Monster {
    public DarkElf(String monsterType) {
        super("DarkElf");
        this.monsterhp = 7500;
        this.monsterdmg = 3200;
        this.monsterlevel = 25;
        this.monsterexpvalue = 2500;
    }
}
