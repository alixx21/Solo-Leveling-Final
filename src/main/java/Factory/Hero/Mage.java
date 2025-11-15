package Factory.Hero;

import Strategy.AttackStrategy;
import Strategy.Mage.*;
import Visitor.Visitor;

public class Mage extends Hero {
    private AttackStrategy dragonbreath;
    private AttackStrategy fireball;
    private AttackStrategy icespears;
    private AttackStrategy meteorfall;
    private AttackStrategy storm;
    private AttackStrategy thunder;
    private AttackStrategy stone;

    public Mage(String heroName) {
        super(heroName,new FireBallD(),"Mage");

        this.heroTitle="None";
        this.evolveType="Archmage";

        this.herohp=900;
        this.damage = 500;

        this.dragonbreath = new DragonBreathA();
        this.fireball = new FireBallD();
        this.icespears = new IceSpearsC();
        this.meteorfall = new MeteorFallS();
        this.storm = new StormC();
        this.thunder =  new ThunderB();
        this.stone = new StoneFallE();
        this.strategy= fireball;
    }

    public void stone(){
        System.out.println("Selected stonefall");
        this.strategy=stone;
    }
    public void dragonBreath() {
        System.out.println("Selected dragon-breath");
        this.strategy= dragonbreath;
    }
    public void fireball() {
        System.out.println("Selected fireball");
        this.strategy= fireball;
    }
    public void iceSpears() {
        System.out.println("Selected ice-spears");
        this.strategy= icespears;
    }
    public void meteorFall() {
        System.out.println("Selected meteor-fall");
        this.strategy= meteorfall;
    }
    public void storm() {
        System.out.println("Selected storm");
        this.strategy= storm;
    }
    public void thunder() {
        System.out.println("Selected thunder");
        this.strategy= thunder;
    }

    @Override
    public void accept(Visitor visitor){
        visitor.visitMage(this);
    }




}
