package Strategy.Healer;

import Strategy.AttackStrategy;

public class LifeTouchD  implements AttackStrategy {
    @Override
    public double getMultiplier() {
        return 0;
    }
    @Override
    public double getHeal() {
        return 1.15;
    }
}
