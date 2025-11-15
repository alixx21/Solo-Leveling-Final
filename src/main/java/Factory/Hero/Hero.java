package Factory.Hero;

import Factory.Boss.Boss;
import Factory.Monsters.Monster;
import Strategy.*;
import Visitor.*;
import Observers.*;
import java.util.ArrayList;
import java.util.List;

public abstract class Hero implements Subject {
    private List<Observer> observers =  new ArrayList<>();
    protected List<AttackStrategy> unlockedskills = new ArrayList<>();

    protected String heroName;
    protected String heroTitle;
    protected String heroType;
    protected String evolveType;
    protected AttackStrategy strategy;
    protected int damage ;
    protected int herohp ;
    protected int lvl = 1;
    protected int exp = 0;

    protected Hero(String heroName,AttackStrategy strategy,String heroType){
        this.heroName = heroName;
        this.strategy = strategy;
        this.heroType = heroType;
        this.evolveType = "";
        this.heroTitle = "";
    }

    public void attack(Monster monster){

        if (strategy == null) {
            System.out.println("No strategy selected!");
            return;
        }
        int finaldamage = calculateDamage();
        monster.takeDamage(finaldamage);

        notifyObservers(heroName + " attacks " + monster.getMonsterType() + " with " + strategy.getClass().getSimpleName());

        if(monster.monsterhp > 0){
            monster.monsterresponce(this);
        }else{
            notifyObservers(monster.getMonsterType() + " has been defeated!");
            gainExp(monster.getMonsterexpvalue());
        }
    }


    public void attackBoss(Boss boss){
        if (strategy == null) {
            System.out.println("No strategy selected!");
            return;
        }
        int finaldamage = calculateDamage();
        boss.takeDamageBoss(finaldamage);

        notifyObservers("Used:"+strategy);
        if(boss.getBosshhp() > 0){
            boss.bossresponce(this);
        }else{
            notifyObservers(boss.getBossName() + " has been defeated!");
            gainExp(boss.getExpvalue());
        }
    }

    public void takeDamage(int dmg){
        this.herohp -= dmg;
    }

    public void unlockedskills(AttackStrategy skills){
        unlockedskills.add(skills);
        notifyObservers(heroName + " unlocked skills:" + skills.getClass().getSimpleName());
    }


    public void gainExp(int exp){
        this.exp += exp;
        while(this.exp>=lvl *100){
            this.exp -= lvl *100;
            lvl++;
            damage+=50;
            herohp+=100;
            notifyObservers(heroName + "leveled up!" + lvl);
        }
    }
    public int calculateDamage(){
        return (int)(damage*strategy.getMultiplier());
    }

    public int heal(){
        return 20;
    }

    public void calculateHeal(){
        herohp = herohp + heal();
    }

    public void evolveto(String evolveType){
        this.evolveType = evolveType;
        notifyObservers(heroName + " evolved to " + evolveType);
    }

    public void newHerotitle(String title){
        this.heroTitle = title;
        notifyObservers(heroName + " got new title:" + heroTitle);
    }


    public String getHeroName() {
        return heroName;
    }

    public int getHeroLevel(){
        return lvl;
    }
    public String getHeroType() {
        return heroType;
    }
    public int getHp() {
        return herohp;
    }
    public int getLevel() {
        return lvl;
    }
    public int getExp() {
        return exp;
    }

    public void addObserver(Observer observer){
        observers.add(observer);
    }

    public void removeObserver(Observer observer){
        observers.remove(observer);
    }

    public void notifyObservers(String message){
        for (Observer observer : observers) {
            observer.update(message);
        }
    }

    public abstract void accept(Visitor visitor);

}
