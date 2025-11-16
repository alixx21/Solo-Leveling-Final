package Builder;

import Facade.Sellable;

public class WeaponBuilder implements Sellable {
    private final String name;
    private final int damage;
    private final double critChance;
    private final String rarity;
    private final String type;
    private final int value;

    public WeaponBuilder(Builder builder) {
        this.name = builder.name;
        this.damage = builder.damage;
        this.critChance = builder.critChance;
        this.rarity = builder.rarity;
        this.type = builder.type;
        this.value= builder.value;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getValue() {
        return value;
    }


    public int getDamage() {
        return damage;
    }

    public static class Builder {
        private String name;
        private int damage;
        private double critChance;
        private String rarity;
        private String type;
        private int value;


        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setDamage(int damage) {
            this.damage = damage;
            return this;
        }

        public Builder setCritChance(double critChance){
            this.critChance = critChance;
            return this;
        }

        public Builder setRarity(String rarity) {
            this.rarity = rarity;
            return this;
        }

        public Builder setType(String type) {
            this.type = type;
            return this;
        }

        public Builder setValue(int value){
            this.value=value;
            return this;
        }
        public WeaponBuilder build(){
            return new WeaponBuilder(this);
        }
    }

}
