package Factory.Monsters;

import Factory.Hero.Hero;

public abstract class Monster {
    protected String monsterType;
    public int monsterhp;
    public int monsterdmg;
    public int monsterlevel;
    public int monsterexpvalue;

    public Monster(String monsterType) {
        this.monsterType = monsterType;
    }
    public String getMonsterType() {
        return monsterType;
    }

    public void takeDamage(int finaldamage) {
        this.monsterhp -= finaldamage;
    }

    public int getMonsterhp() {
        return monsterhp;
    }

    public int getMonsterdmg() {
        return monsterdmg;
    }
    public int getMonsterlevel() {
        return monsterlevel;
    }
    public int getMonsterexpvalue() {
        return monsterexpvalue;
    }

    public void monsterresponce(Hero hero) {
        int dmg = this.monsterdmg;
        System.out.println(monsterType + " attacked with " + dmg + " damage");
        hero.takeDamage(dmg);

    }
}
