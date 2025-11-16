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
        if(healer.getLevel()>0) healer.unlockedskills(new BlessingWaveB());
        if(healer.getLevel()>0) healer.unlockedskills(new LifeTouchD());
    }
    public void visitSummoner(Summoner summoner){
        if(summoner.getLevel()>=0) summoner.unlockedskills(new MinionE());
        if(summoner.getLevel()>=0) summoner.unlockedskills(new PhoenixS());
        if(summoner.getLevel()>=5) summoner.unlockedskills(new OrichiD());
        if(summoner.getLevel()>=5) summoner.unlockedskills(new ShadowWolfD());
        if(summoner.getLevel()>=10) summoner.unlockedskills(new IronBearC());
        if(summoner.getLevel()>=25) summoner.unlockedskills(new ZhengB());
        if(summoner.getLevel()>=50) summoner.unlockedskills(new MammothA());

    }
    public void visitMage(Mage mage){
        if(mage.getLevel()>=0) mage.unlockedskills(new StoneFallE());
        if(mage.getLevel()>=5) mage.unlockedskills(new FireBallD());
        if(mage.getLevel()>=10) mage.unlockedskills(new IceSpearsC());
        if(mage.getLevel()>=10) mage.unlockedskills(new StormC());
        if(mage.getLevel()>=25) mage.unlockedskills(new ThunderB());
        if(mage.getLevel()>=50) mage.unlockedskills(new DragonBreathA());
        if(mage.getLevel()>=70) mage.unlockedskills(new MeteorFallS());

    }
    public void visitAssassin(Assassin assassin){
        if(assassin.getLevel()>=0)  assassin.unlockedskills(new HandtoHandF());
        if(assassin.getLevel()>=0)  assassin.unlockedskills(new DoubleSpikeE());
        if(assassin.getLevel()>=5)  assassin.unlockedskills(new LungeD());
        if(assassin.getLevel()>=10)  assassin.unlockedskills(new ShadowHitC());
        if(assassin.getLevel()>=25)  assassin.unlockedskills(new ShadowStepB());
        if(assassin.getLevel()>=50)  assassin.unlockedskills(new DaggerRushA());
    }
}
