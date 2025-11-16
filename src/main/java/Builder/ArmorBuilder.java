package Builder;

import Facade.Sellable;

public class ArmorBuilder implements Sellable {
    private final String name;
    private final int defense;
    private final String magicResist;
    private final String rarity;
    private final int value;

    public ArmorBuilder(Builder builder) {
        this.name = builder.name;
        this.defense = builder.defense;
        this.magicResist = builder.magicResist;
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


    public int getDefense() {
        return defense;
    }


    public static class Builder {
        private String name;
        private int defense;
        private String magicResist;
        private String rarity;
        private int value;

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setDefense(int defense) {
            this.defense = defense;
            return this;
        }

        public Builder setMagicResist(String magicResist) {
            this.magicResist = magicResist;
            return this;
        }

        public Builder setRarity(String rarity) {
            this.rarity = rarity;
            return this;
        }

        public Builder setValue(int value) {
            this.value = value;
            return this;
        }

        public ArmorBuilder build() {
            return new ArmorBuilder(this);
        }
    }
}