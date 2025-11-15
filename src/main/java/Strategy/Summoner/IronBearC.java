package Strategy.Summoner;

import Strategy.AttackStrategy;

public class IronBearC implements AttackStrategy {
    @Override
    public double getMultiplier(){
        return 1.4 ;
    }
    @Override
    public double getHeal() {
        return 0;
    }
}
