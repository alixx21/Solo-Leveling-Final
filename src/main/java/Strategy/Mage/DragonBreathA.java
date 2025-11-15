package Strategy.Mage;

import Strategy.AttackStrategy;

public class DragonBreathA implements AttackStrategy {
    @Override
    public double getMultiplier() {
        return 1.85;
    }
    @Override
    public double getHeal() {
        return 0;
    }
}
