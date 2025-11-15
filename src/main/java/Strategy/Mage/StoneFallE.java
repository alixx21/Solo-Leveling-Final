package Strategy.Mage;

import Strategy.AttackStrategy;

public class StoneFallE implements AttackStrategy {
    @Override
    public double getMultiplier() {
        return 1.1;
    }
    @Override
    public double getHeal() {
        return 0;
    }
}
