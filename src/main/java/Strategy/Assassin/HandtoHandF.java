package Strategy.Assassin;

import Strategy.AttackStrategy;

public class HandtoHandF implements AttackStrategy {

    @Override
    public double getMultiplier(){
        return 1.0;
    }
    @Override
    public double getHeal() {
        return 0;
    }
}
