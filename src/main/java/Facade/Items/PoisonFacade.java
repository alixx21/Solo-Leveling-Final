package Facade.Items;

import Builder.PoisonBuilder;

public class PoisonFacade {

    public PoisonBuilder createPoison(String type) {
        PoisonBuilder.Builder builder = new PoisonBuilder.Builder();

        return switch (type.toLowerCase()) {
            case "neurotoxin" -> builder
                    .setName("Neurotoxin")
                    .setDamage(10)
                    .setRarity("Rare")
                    .setArmorDamage(5)
                    .setValue(10)
                    .build();
            case "acid" -> builder
                    .setName("Acid Poison")
                    .setDamage(5)
                    .setArmorDamage(2)
                    .setRarity("Common")
                    .setValue(10)
                    .build();
            case "paralytic" -> builder
                    .setName("Paralytic Toxin")
                    .setDamage(4)
                    .setArmorDamage(0)
                    .setRarity("Rare")
                    .setValue(15)
                    .build();
            case "bile" -> builder
                    .setName("Corrosive Bile")
                    .setDamage(4)
                    .setArmorDamage(8)
                    .setRarity("Rare")
                    .setValue(20)
                    .build();
            default -> throw new IllegalArgumentException("Unknown poison: " + type);
        };
    }
}
