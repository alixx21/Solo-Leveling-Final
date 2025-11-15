package Strategy.Summoner;

import Strategy.AttackStrategy;

public class MinionE implements AttackStrategy {
    @Override
    public double getMultiplier() {
        return 1.1;
    }
    @Override
    public double getHeal() {
        return 0;
    }
}
