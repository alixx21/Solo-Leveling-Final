package Strategy.Mage;

import Strategy.AttackStrategy;

public class ThunderB implements AttackStrategy {
    @Override
    public double getMultiplier() {
        return 1.6;
    }
    @Override
    public double getHeal() {
        return 0;
    }
}
