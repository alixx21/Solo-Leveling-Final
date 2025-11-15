package Strategy.Assassin;

import Strategy.AttackStrategy;

public class ShadowHitC implements AttackStrategy {
    @Override
    public double getMultiplier() {
        return 1.4;
    }
    @Override
    public double getHeal() {
        return 0;
    }
}
