package Strategy.Summoner;

import Strategy.AttackStrategy;

public class MammothA implements AttackStrategy {
    @Override
    public double getMultiplier(){
        return 1.85 ;
    }
    @Override
    public double getHeal() {
        return 0;
    }
}
