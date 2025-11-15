package Visitor;

import Factory.Hero.Assassin;
import Factory.Hero.Healer;
import Factory.Hero.Mage;
import Factory.Hero.Summoner;

public class TitleVisitor implements Visitor {
    public void visitHealer(Healer healer){
        if (healer.getHeroLevel()>=55) healer.newHerotitle("Savior of the humanity");
    }
    public void visitMage(Mage mage){
        if(mage.getHeroLevel()>=55) mage.newHerotitle("Angel's blessing");
    }
    public void visitAssassin(Assassin assassin){
        if(assassin.getHeroLevel()>=55) assassin.newHerotitle("Fear of monsters");
    }
    public void visitSummoner(Summoner summoner){
        if(summoner.getHeroLevel()>=55) summoner.newHerotitle("The connector of worlds");
    }

}


