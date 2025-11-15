package Strategy.Summoner;

import Strategy.AttackStrategy;

public class PhoenixS implements AttackStrategy {
    @Override
    public double getMultiplier(){
        return 2.2;
    }
    @Override
    public double getHeal() {
        return 0;
    }
}
