package Facade.Items;

import Builder.ArmorBuilder;

public class ArmorFacade {

    public ArmorBuilder createArmor(String type) {
        ArmorBuilder.Builder builder = new ArmorBuilder.Builder();

        return switch (type.toLowerCase()) {
            case "nightingale" -> builder
                    .setDefense(30)
                    .setName("Nightingale Armor")
                    .setRarity("Rare")
                    .setMagicResist("Weak")
                    .setValue(25)
                    .build();
            case "shadowleaf" -> builder
                    .setDefense(25)
                    .setName("Shadowleaf Vest")
                    .setRarity("Uncommon")
                    .setMagicResist("Medium")
                    .setValue(30)
                    .build();
            case "windrunner" -> builder
                    .setDefense(28)
                    .setName("Windrunner Tunic")
                    .setRarity("Rare")
                    .setMagicResist("Weak")
                    .setValue(35)
                    .build();
            case "titansteel" -> builder
                    .setDefense(60)
                    .setName("Titansteel Plate")
                    .setRarity("Epic")
                    .setMagicResist("Moderate")
                    .setValue(70)
                    .build();
            case "dragonscale" -> builder
                    .setDefense(70)
                    .setName("Dragonscale Bulwark")
                    .setRarity("Legendary")
                    .setMagicResist("Strong")
                    .setValue(80)
                    .build();
            case "ironclad" -> builder
                    .setDefense(55)
                    .setName("Ironclad Bastion Armor")
                    .setRarity("Rare")
                    .setMagicResist("Moderate")
                    .setValue(65)
                    .build();
            case "rangerset" -> builder
                    .setDefense(40)
                    .setName("Ranger’s Carapace")
                    .setRarity("Uncommon")
                    .setMagicResist("Weak")
                    .setValue(50)
                    .build();
            case "stormforge" -> builder
                    .setDefense(45)
                    .setName("Storm forge Mail")
                    .setRarity("Epic")
                    .setMagicResist("Medium")
                    .setValue(55)
                    .build();
            case "obsidian" -> builder
                    .setDefense(50)
                    .setName("Obsidian Warplate")
                    .setRarity("Rare")
                    .setMagicResist("Strong")
                    .setValue(60)
                    .build();
            default -> throw new IllegalArgumentException("Unknown armor: " + type);
        };
    }
}