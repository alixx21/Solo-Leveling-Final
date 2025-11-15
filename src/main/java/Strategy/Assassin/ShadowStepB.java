package Strategy.Assassin;

import Strategy.AttackStrategy;

public class ShadowStepB implements AttackStrategy {
    @Override
    public double getMultiplier() {
        return 1.6;
    }
    @Override
    public double getHeal() {
        return 0;
    }
}
