package Strategy.Mage;

import Strategy.AttackStrategy;

public class IceSpearsC implements AttackStrategy {
    @Override
    public double getMultiplier() {
        return 1.4;
    }
    @Override
    public double getHeal() {
        return 0;
    }
}
