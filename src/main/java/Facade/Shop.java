package Facade;

import Facade.Items.*;
import Factory.Hero.Hero;
import Observers.BattleLogger;
import Observers.GameAnnouncer;
import Observers.Observer;
import Observers.Subject;

import static Observers.Subject.*;

public class Shop {

    private final WeaponFacade weaponFacade = new WeaponFacade();
    private final ArmorFacade armorFacade = new ArmorFacade();
    private final PoisonFacade poisonFacade = new PoisonFacade();
    private final ArtifactFacade artifactFacade = new ArtifactFacade();

    private final Hero hero;

    public Shop(Hero hero) {
        this.hero = hero;
    }

    public boolean buy(String itemType) {
        if (itemType == null || itemType.trim().isEmpty()) {
            System.out.println("Invalid item name.");
            return false;
        }

        Sellable item = createItem(itemType.trim());
        if (item == null) {
            System.out.println("Item not found in shop: " + itemType);
            return false;
        }

        int price = item.getValue();

        if (hero.spendGold(price)) {
            hero.addItem(item);
            System.out.println("Purchased: " + item.getName() + " for " + price + " gold");

            hero.notifyObservers("ItemPurchased");
            return true;
        } else {
            System.out.println("Not enough gold! Required: " + price + " gold, you have: " + hero.getGold());
            return false;
        }
    }

    public void sell(Sellable item) {
        if (item == null) {
            System.out.println("Cannot sell nothing.");
            return;
        }

        int sellPrice = Math.max(1, item.getValue() / 2);

        hero.addGold(sellPrice);
        hero.removeItem(item);

        System.out.println("Sold " + item.getName() + " for " + sellPrice + " gold");

        hero.notifyObservers("GoldChanged");
    }

    public void displayWelcome() {
        System.out.println("""
                ╔══════════════════════════════════════════════════╗
                ║               WELCOME TO THE SHOP!               ║
                ║                                                  ║
                ║  Weapons • Armor • Poisons • Legendary Artifacts ║
                ║                                                  ║
                ╚══════════════════════════════════════════════════╝
                Available items:
                Weapons: sword, spear, staff, bow, shuriken.
                Armor: nightingale, dragonscale, titansteel, obsidian, shadowleaf, windrunner,ironclad, rangerset, stormforge.
                Poisons: acid, neurotoxin, bile, paralytic.
                Artifacts: ring of strength, amulet of speed, crystal of focus.
                
                Type "back" to leave.
                """);
    }

    private Sellable createItem(String type) {
        String lowerType = type.toLowerCase().trim();

        return switch (lowerType) {

            case "sword"    -> weaponFacade.createWeapon("sword");
            case "spear"    -> weaponFacade.createWeapon("spear");
            case "staff"    -> weaponFacade.createWeapon("staff");
            case "bow"      -> weaponFacade.createWeapon("bow");
            case "shuriken" -> weaponFacade.createWeapon("shuriken");

            case "nightingale" -> armorFacade.createArmor("nightingale");
            case "shadowleaf"  -> armorFacade.createArmor("shadowleaf");
            case "windrunner"  -> armorFacade.createArmor("windrunner");
            case "titansteel"  -> armorFacade.createArmor("titansteel");
            case "dragonscale" -> armorFacade.createArmor("dragonscale");
            case "ironclad"    -> armorFacade.createArmor("ironclad");
            case "rangerset"   -> armorFacade.createArmor("rangerset");
            case "stormforge"  -> armorFacade.createArmor("stormforge");
            case "obsidian"    -> armorFacade.createArmor("obsidian");

            case "acid"       -> poisonFacade.createPoison("acid");
            case "bile"       -> poisonFacade.createPoison("bile");
            case "neurotoxin" -> poisonFacade.createPoison("neurotoxin");
            case "paralytic"  -> poisonFacade.createPoison("paralytic");

            case "ring of strength"          -> artifactFacade.createArtifact("ring of strength");
            case "amulet of speed"           -> artifactFacade.createArtifact("amulet of speed");
            case "crystal of focus"          -> artifactFacade.createArtifact("crystal of focus");
            case "shieldstone of protection" -> artifactFacade.createArtifact("shieldstone of protection");

            default -> {
                System.out.println("No such item: " + type + ". Try again.");
                yield null;
            }
        };
    }
}
