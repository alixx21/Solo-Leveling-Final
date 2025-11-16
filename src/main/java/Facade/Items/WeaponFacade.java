package Facade.Items;
import Builder.WeaponBuilder;

public class WeaponFacade {

    public WeaponBuilder createWeapon(String type) {
        WeaponBuilder.Builder builder = new WeaponBuilder.Builder();
        return switch (type) {
            case  "sword" -> builder
                    .setName("Excalibur")
                    .setDamage(25)
                    .setRarity("Legendary")
                    .setType("Holy Blade")
                    .setCritChance(0.2)
                    .setValue(100)
                    .build();
            case "spear" -> builder
                    .setName("Dragonlance")
                    .setDamage(22)
                    .setRarity("Epic")
                    .setType("Polearm")
                    .setCritChance(0.18)
                    .setValue(70)
                    .build();
            case "staff" -> builder
                    .setName("Elderbranch Staff")
                    .setDamage(10)
                    .setRarity("Rare")
                    .setType("Magic Focus")
                    .setCritChance(0.1)
                    .setValue(45)
                    .build();
            case "bow" -> builder
                    .setName("Stormpiercer")
                    .setDamage(18)
                    .setRarity("Epic")
                    .setType("Ranged Weapon")
                    .setCritChance(0.25)
                    .setValue(60)
                    .build();
            case "shuriken" -> builder
                    .setName("Venomstar")
                    .setDamage(8)
                    .setRarity("Rare")
                    .setType("Throwing Weapon")
                    .setCritChance(0.2)
                    .setValue(2)
                    .build();
            default -> throw new IllegalArgumentException("Unknown weapon: " + type);
        };
    }
}
