package Factory.Monsters.S;
import Factory.Monsters.Monster;


public class MonarchGuard extends Monster {
    public MonarchGuard(String monsterType) {
        super("MonarchGuard");
        this.monsterhp = 20000;
        this.monsterdmg = 7000;
        this.monsterlevel = 50;
        this.monsterexpvalue = 9000;
    }
}
