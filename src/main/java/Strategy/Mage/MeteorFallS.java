package Strategy.Mage;

import Strategy.AttackStrategy;

public class MeteorFallS implements AttackStrategy {
    @Override
    public double getMultiplier() {
        return 2.2;
    }
    @Override
    public double getHeal() {
        return 0;
    }
}
