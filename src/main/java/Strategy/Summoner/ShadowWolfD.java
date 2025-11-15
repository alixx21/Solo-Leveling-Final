package Strategy.Summoner;

import Strategy.AttackStrategy;

public class ShadowWolfD implements AttackStrategy {
    @Override
    public double getMultiplier(){
        return 1.25 ;
    }
    @Override
    public double getHeal() {
        return 0;
    }
}
