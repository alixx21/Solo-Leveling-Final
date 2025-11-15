package Strategy.Mage;

import Strategy.AttackStrategy;

public class FireBallD implements AttackStrategy {
    @Override
    public double getMultiplier() {
        return 1.25;
    }
    @Override
    public double getHeal() {
        return 0;
    }
}
