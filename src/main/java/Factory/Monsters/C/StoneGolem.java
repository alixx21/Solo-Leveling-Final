package Factory.Monsters.C;
import Factory.Monsters.Monster;


public class StoneGolem extends Monster {
    public StoneGolem(String monsterType) {
        super("StoneGolem");
        this.monsterhp = 3500;
        this.monsterdmg = 1000;
        this.monsterlevel = 12;
        this.monsterexpvalue = 900;
    }
}
