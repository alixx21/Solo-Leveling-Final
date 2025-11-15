package Visitor;

import Factory.Hero.Assassin;
import Factory.Hero.Healer;
import Factory.Hero.Mage;
import Factory.Hero.Summoner;
import Strategy.Assassin.*;
import Strategy.Healer.BlessingWaveB;
import Strategy.Healer.LifeTouchD;
import Strategy.Mage.*;
import Strategy.Summoner.*;

public class SkillUnlockVisitor implements Visitor {
    public void visitHealer(Healer healer){
        if(healer.getHeroLevel()>0) healer.unlockedskills(new BlessingWaveB());
        if(healer.getHeroLevel()>0) healer.unlockedskills(new LifeTouchD());
    }
    public void visitSummoner(Summoner summoner){
        if(summoner.getHeroLevel()>=0) summoner.unlockedskills(new MinionE());
        if(summoner.getHeroLevel()>=5) summoner.unlockedskills(new OrichiD());
        if(summoner.getHeroLevel()>=5) summoner.unlockedskills(new ShadowWolfD());
        if(summoner.getHeroLevel()>=10) summoner.unlockedskills(new IronBearC());
        if(summoner.getHeroLevel()>=25) summoner.unlockedskills(new ZhengB());
        if(summoner.getHeroLevel()>=50) summoner.unlockedskills(new MammothA());
    }
    public void visitMage(Mage mage){
        if(mage.getHeroLevel()>=0) mage.unlockedskills(new StoneFallE());
        if(mage.getHeroLevel()>=5) mage.unlockedskills(new FireBallD());
        if(mage.getHeroLevel()>=10) mage.unlockedskills(new IceSpearsC());
        if(mage.getHeroLevel()>=10) mage.unlockedskills(new StormC());
        if(mage.getHeroLevel()>=25) mage.unlockedskills(new ThunderB());
        if(mage.getHeroLevel()>=50) mage.unlockedskills(new DragonBreathA());
        if(mage.getHeroLevel()>=70) mage.unlockedskills(new MeteorFallS());

    }
    public void visitAssassin(Assassin assassin){
        if(assassin.getHeroLevel()>=0)  assassin.unlockedskills(new HandtoHandF());
        if(assassin.getHeroLevel()>=2)  assassin.unlockedskills(new DoubleSpikeE());
        if(assassin.getHeroLevel()>=5)  assassin.unlockedskills(new LungeD());
        if(assassin.getHeroLevel()>=10)  assassin.unlockedskills(new ShadowHitC());
        if(assassin.getHeroLevel()>=25)  assassin.unlockedskills(new ShadowStepB());
        if(assassin.getHeroLevel()>=50)  assassin.unlockedskills(new DaggerRushA());
    }
}
