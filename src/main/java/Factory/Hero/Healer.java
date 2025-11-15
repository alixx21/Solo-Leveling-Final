package Factory.Hero;


import Strategy.AttackStrategy;
import Strategy.Healer.BlessingWaveB;
import Strategy.Healer.LifeTouchD;
import Visitor.*;

public class Healer extends Hero {
    private AttackStrategy lifetouch;
    private AttackStrategy blessingwave;


    public Healer(String heroName) {
        super(heroName,new LifeTouchD(),"Healer");

        this.heroTitle="None";
        this.herohp=1200;
        this.evolveType="Celestial Healer";

        this.blessingwave=new BlessingWaveB();
        this.lifetouch=new LifeTouchD();

        this.strategy=lifetouch;

    }

    public void blessingwave(){
        System.out.println("Blessing wave is healing everyone");
        this.strategy=blessingwave;
    }

    public void lifetouch(){
        System.out.println("Lifetouch is healing Hero");
        this.strategy=lifetouch;
    }



    @Override
    public void accept(Visitor visitor) {
        visitor.visitHealer(this);
    }
}
