package Factory.Hero;

import Strategy.AttackStrategy;
import Strategy.Summoner.*;
import Visitor.Visitor;

public class Summoner extends Hero {
    private AttackStrategy ironbear;
    private AttackStrategy mammoth;
    private AttackStrategy orichi;
    private AttackStrategy shadowWolf;
    private AttackStrategy zheng;
    private AttackStrategy phoenix;
    private AttackStrategy minion;

    public Summoner(String heroName){
        super(heroName,new ShadowWolfD(),"Summoner");

        this.heroTitle="None";
        this.evolveType="Spirit King";
        this.herohp= 1200;
        this.damage = 390;
        this.minion=new MinionE();
        this.shadowWolf = new ShadowWolfD();
        this.ironbear=new IronBearC();
        this.mammoth = new MammothA();
        this.orichi = new OrichiD();
        this.zheng = new ZhengB();
        this.phoenix=new PhoenixS();
        unlockedskills.add(minion);
        unlockedskills.add(phoenix);

        this.strategy=minion;
    }

    public void minion(){
        System.out.println("Minion summoned");
        this.strategy=minion;
    }

    public void shadowWolf(){
        System.out.println("Shadow wolf summoned");
        this.strategy=shadowWolf;
    }
    public void ironBear(){
        System.out.println("Iron bear summoned");
        this.strategy=ironbear;
    }
    public void mammoth(){
        System.out.println("Mammoth summoned");
        this.strategy=mammoth;
    }
    public void orichi(){
        System.out.println("Orichi summoned");
        this.strategy=orichi;
    }
    public void zheng(){
        System.out.println("Zheng summoned");
        this.strategy=zheng;
    }

    public void phoenix(){
        System.out.println("Summoning phoenix...");

        int phoenixchance = (int) (Math.random()*50);
        if (phoenixchance==7){
            System.out.println("Phoenix summoned");
            this.strategy=phoenix;
        }else System.out.println("Phoenix refused the summon");
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitSummoner(this);
    }

    @Override
    public void notifyObservers(String eventType) {

    }
}
