package Builder;

import Facade.Sellable;

public class PoisonBuilder implements Sellable {
    private final String name;
    private final int damage;
    private final String rarity;
    private final int armorDamage;
    private final int value;

    public PoisonBuilder(Builder builder) {
        this.name = builder.name;
        this.damage = builder.damage;
        this.rarity = builder.rarity;
        this.armorDamage = builder.damage;
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

    public int getArmorDamage() {
        return armorDamage;
    }

    public int getDamage() {
        return damage;
    }

    public static class Builder {
        private String name;
        private int damage;
        private String effectType;
        private String rarity;
        private int armorDamage;
        private int value;

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setDamage(int damage) {
            this.damage = damage;
            return this;
        }

        public Builder setRarity(String rarity) {
            this.rarity = rarity;
            return this;
        }

        public Builder setArmorDamage(int armorDamage){
            this.armorDamage=armorDamage;
            return this;
        }

        public Builder setValue(int value){
            this.value=value;
            return this;
        }


        public PoisonBuilder build() {
            return new PoisonBuilder(this);
        }
    }
}
