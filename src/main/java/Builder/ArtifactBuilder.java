package Builder;

import Facade.Sellable;
import Strategy.AttackStrategy;

public class ArtifactBuilder implements Sellable {
    private final String name;
    private final double effect;
    private final String rarity;
    private final int value;
    private double damageMultiplier;
    private int bonusHP;

    public ArtifactBuilder(Builder builder) {
        this.name = builder.name;
        this.effect = builder.effect;
        this.rarity = builder.rarity;
        this.value = builder.value;

    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getValue() {
        return value;
    }

    public double getDamageMultiplier() {
        return damageMultiplier;
    }



    public int getBonusHP() {
        return bonusHP;
    }

    public double getEffect(){
        return effect;
    }



    public static class Builder {
        private String name;
        private double effect;
        private String rarity;
        private int value;

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setEffect(double effect) {
            this.effect = effect;
            return this;
        }

        public Builder setRarity(String rarity) {
            this.rarity = rarity;
            return this;
        }

        public Builder setValue(int value){
            this.value=value;
            return this;
        }

        public ArtifactBuilder build() {
            return new ArtifactBuilder(this);
        }
    }
}
