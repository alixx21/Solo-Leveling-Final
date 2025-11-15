package Strategy.Summoner;

import Strategy.AttackStrategy;

public class OrichiD implements AttackStrategy {
    @Override
    public double getMultiplier(){
        return 1.25 ;
    }
    @Override
    public double getHeal() {
        return 0;
    }
}
