package Visitor;

import Factory.Hero.Assassin;
import Factory.Hero.Healer;
import Factory.Hero.Mage;
import Factory.Hero.Summoner;

public class EvolutionVisitor implements Visitor {
    public void visitHealer(Healer healer){
        if(healer.getHeroLevel()>=40) healer.evolveto("Celestial Healer");
    }
    public void visitMage(Mage mage){
        if (mage.getHeroLevel()>=40) mage.evolveto("Archmage");

    }
    public void visitAssassin(Assassin assassin){
        if(assassin.getHeroLevel()>=40)assassin.evolveto("Phantom Slayer");
    }
    public void visitSummoner(Summoner summoner){
        if(summoner.getHeroLevel()>=40) summoner.evolveto("Spirit King");
    }

}
