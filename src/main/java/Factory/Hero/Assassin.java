package Factory.Hero;

import Strategy.Assassin.*;
import Strategy.AttackStrategy;
import Visitor.*;

public class Assassin extends Hero {
    private AttackStrategy doublespike;
    private AttackStrategy handtohand;
    private AttackStrategy lunge;
    private AttackStrategy shadowhit;
    private AttackStrategy shadowstep;
    private AttackStrategy daggerrush;



    public Assassin(String heroName) {
        super(heroName,new LungeD(),"Assassin");

        this.heroTitle="None";
        this.evolveType="Phantom Slayer";
        this.herohp=1000;
        this.damage =400;
        this.lunge=new LungeD();
        this.handtohand=new HandtoHandF();
        this.doublespike = new DoubleSpikeE();
        this.shadowhit = new ShadowHitC();
        this.shadowstep = new ShadowStepB();
        this.daggerrush = new DaggerRushA();

        this.strategy= lunge;

    }

    public void lunge(){
        System.out.println("Selected Lunge attack");
        this.strategy=lunge;
    }

    public void handtohand(){
        System.out.println("Selected Handtohand");
        this.strategy=handtohand;
    }

    public void doublespike(){
        System.out.println("Selected DoubleSpike");
        this.strategy=doublespike;
    }

    public void shadowhit(){
        System.out.println("Selected ShadowHit");
        this.strategy=shadowhit;
    }

    public void shadowstep(){
        System.out.println("Selected ShadowStep");
        this.strategy=shadowstep;
    }

    public void daggerrush(){
        System.out.println("Selected Daggerrush");
        this.strategy=daggerrush;
    }

    @Override
    public int calculateDamage() {
        int dmg = super.calculateDamage();
        int critchance=(int) (Math.random()*10);

        if (critchance==0){
            return (int)(dmg*2.5);
        }
        return dmg;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitAssassin(this);
    }

}
