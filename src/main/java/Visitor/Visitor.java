package Visitor;

import Factory.Hero.*;

public interface Visitor {
    void visitHealer(Healer healer);
    void visitSummoner(Summoner summoner);
    void visitMage(Mage mage);
    void visitAssassin(Assassin assassin);

}
