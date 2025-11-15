package Strategy.Assassin;

import Strategy.AttackStrategy;

public class DoubleSpikeE implements AttackStrategy {
    @Override
    public double getMultiplier(){
        return 1.1 ;
    }
    @Override
    public double getHeal() {
        return 0;
    }
}

