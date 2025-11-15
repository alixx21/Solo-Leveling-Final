package Factory.Monsters.C;
import Factory.Monsters.Monster;


public class Elf extends Monster {
    public Elf(String monsterType) {

        super("Elf");

        this.monsterhp = 2100;
        this.monsterdmg = 1400;
        this.monsterlevel = 10;
        this.monsterexpvalue = 700;
    }
}
