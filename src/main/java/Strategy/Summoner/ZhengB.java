package Strategy.Summoner;

import Strategy.AttackStrategy;

public class ZhengB implements AttackStrategy {
    @Override
    public double getMultiplier(){
        return 1.6 ;
    }
    @Override
    public double getHeal() {
        return 0;
    }
}
