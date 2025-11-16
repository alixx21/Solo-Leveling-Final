package Facade;

import Builder.*;
import Facade.Items.DungeonFacade;
import Factory.Hero.*;
import Factory.Monsters.*;
import Factory.Boss.*;
import Observers.BattleLogger;
import Observers.Subject;
import Strategy.AttackStrategy;

import java.util.List;
import java.util.Scanner;

public class GameFacade {
    private Hero hero;
    private Shop shop;
    private final DungeonFacade dungeonFacade = new DungeonFacade();
    private final MonsterFactory monsterFactory = new MonsterFactory();
    private final BossFactory bossFactory = new BossFactory();
    private final Scanner scanner = new Scanner(System.in);
    private String currentRank = "E"; // Текущий ранг охотника

    public GameFacade() {
        createHeroAndStart();
    }

    private void createHeroAndStart() {
        System.out.println("""
            ╔═══════════════════════════════════════════════════╗
            ║           SYSTEM: PLAYER AWAKENED                 ║
            ║                                                   ║
            ║       You were the weakest... but now...          ║
            ║               THE SYSTEM BELONGS TO YOU           ║
            ╚═══════════════════════════════════════════════════╝
            """);

        System.out.print("Enter your name, Hunter: ");
        String name = scanner.nextLine().trim();
        if (name.isEmpty()) name = "Sung Jin-Woo";

        HeroFactory factory = new HeroFactory();
        int roll = (int) (Math.random() * 100);
        if (roll < 5) hero = factory.createHero("healer", name);
        else if (roll < 40) hero = factory.createHero("assassin", name);
        else if (roll < 70) hero = factory.createHero("mage", name);
        else hero = factory.createHero("summoner", name);

        this.shop = new Shop(hero);

        System.out.printf("""
            Awakening complete!
            Class: %s
            Rank: E → Awakened
            HP: %d | Gold: %d
            
            Press Enter to begin your journey...
            """, hero.getClass().getSimpleName(), hero.getTotalHP(), hero.getGold());
        scanner.nextLine();

        mainMenu();
    }

    // ГЛАВНОЕ МЕНЮ
    private void mainMenu() {
        while (true) {
            System.out.println("\n╔══════════════════════════════════════════╗");
            System.out.println("║         HUNTER ASSOCIATION               ║");
            System.out.println("║ Hunter: " + hero.getHeroName() + " ".repeat(25 - hero.getHeroName().length()) + "║");
            System.out.println("║ Rank: " + currentRank + "-Rank" + " ".repeat(30) + "║");
            System.out.println("╠══════════════════════════════════════════╣");
            System.out.println("║ 1. Enter Gate                            ║");
            System.out.println("║ 2. Shop                                  ║");
            System.out.println("║ 3. Inventory & Equip                     ║");
            System.out.println("║ 4. Stats                                 ║");
            System.out.println("║ 5. Exit                                  ║");
            System.out.println("╚══════════════════════════════════════════╝");
            System.out.print("Choose: ");

            int choice = readInt();
            switch (choice) {
                case 1 -> chooseDungeon();
                case 2 -> openShop();
                case 3 -> showInventoryAndEquip();
                case 4 -> displayPlayerStats();
                case 5 -> {
                    System.out.println("See you in the next Gate, Shadow Monarch.");
                    return;
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    // ВЫБОР ДАНЖА
    private void chooseDungeon() {
        System.out.println("\nAvailable Gates:");
        if (currentRank.compareTo("E") >= 0) System.out.println("  1. E-rank → Abandoned Mine");
        if (currentRank.compareTo("D") >= 0) System.out.println("  2. D-rank → Orc Camp");
        if (currentRank.compareTo("C") >= 0) System.out.println("  3. C-rank → Labyrinth of the Minotaur");
        if (currentRank.compareTo("B") >= 0) System.out.println("  4. B-rank → Dragon's Lair");
        if (currentRank.compareTo("A") >= 0) System.out.println("  5. A-rank → Goblin Cave");
        if (currentRank.equals("S")) System.out.println("  6. S-rank → Realm of the Monarchs");

        System.out.print("\nEnter number (0 to cancel): ");
        int choice = readInt();

        String dungeonType = switch (choice) {
            case 1 -> "e rank dungeon";
            case 2 -> "d rank dungeon";
            case 3 -> "c rank dungeon";
            case 4 -> "b rank dungeon";
            case 5 -> "a rank dungeon";
            case 6 -> "s rank dungeon";
            default -> null;
        };

        if (dungeonType == null) return;

        DungeonBuilder dungeon = dungeonFacade.createDungeon(dungeonType);
        enterDungeon(dungeon);

        // Повышаем ранг
        currentRank = switch (dungeonType) {
            case "e rank dungeon" -> "D";
            case "d rank dungeon" -> "C";
            case "c rank dungeon" -> "B";
            case "b rank dungeon" -> "A";
            case "a rank dungeon", "s rank dungeon" -> "S";
            default -> currentRank;
        };
    }

    // ВХОД В ДАНЖ
    private void enterDungeon(DungeonBuilder dungeon) {
        System.out.printf("\nGate opened: %s\n", dungeon.getName());
        System.out.println(dungeon.getDescription() + "\n");

        // Монстры
        for (int i = 0; i < dungeon.getMonsters(); i++) {
            String[] types = {"goblin", "direwolf", "orc", "demon", "skeleton"};
            Monster m = monsterFactory.createMonster(types[(int)(Math.random() * types.length)]);
            System.out.println("Monster appeared: " + m.getMonsterType());
            fightMonster(m);
            if (hero.getHp() <= 0) {
                System.out.println("\nYou have been defeated... Game Over.");
                System.exit(0);
            }
        }

        // Босс
        Boss boss = bossFactory.createBoss(dungeon.getBoss());
        System.out.println("\nBOSS ROOM OPENED: " + boss.getBossName());
        fightBoss(boss);

        if (hero.getHp() > 0) {
            System.out.println("\nGate cleared!");
            hero.gainExp(dungeon.getExp());
            hero.addGold(200 + dungeon.getExp());

            if (dungeon.getArtifact() != null && Math.random() * 100 < dungeon.getArtifactDropChance()) {
                Sellable artifact = dungeon.getArtifact();
                hero.addItem(artifact);
                System.out.println("LEGENDARY DROP: " + artifact.getName() + "!");
            }
        }
    }

    // БОЙ С МОНСТРОМ
    private void fightMonster(Monster monster) {
        while (monster.getMonsterhp() > 0 && hero.getHp() > 0) {
            System.out.printf("\n%s [HP: %d]  vs  %s [HP: %d]\n",
                    hero.getHeroName(), hero.getHp(), monster.getMonsterType(), monster.getMonsterhp());

            System.out.println("Choose skill:");
            List<AttackStrategy> skills = hero.getUnlockedSkills();
            for (int i = 0; i < skills.size(); i++) {
                System.out.println((i + 1) + ". " + skills.get(i).getClass().getSimpleName());
            }

            int idx = readInt() - 1;
            if (idx >= 0 && idx < skills.size()) {
                hero.setStrategy(skills.get(idx));
                hero.attack(monster);

                if (monster.getMonsterhp() > 0) {
                    monster.monsterresponce(hero);
                }
            } else {
                System.out.println("Invalid skill!");
            }
        }
        if (hero.getHp() > 0) {
            System.out.println(monster.getMonsterType() + " defeated! +" + monster.getMonsterexpvalue() + " EXP");
            hero.gainExp(monster.getMonsterexpvalue());
        }
    }

    // БОЙ С БОССОМ
    private void fightBoss(Boss boss) {
        while (boss.getBosshhp() > 0 && hero.getHp() > 0) {
            System.out.printf("\n%s [HP: %d]  vs  %s [HP: %d]\n",
                    hero.getHeroName(), hero.getHp(), boss.getBossName(), boss.getBosshhp());

            List<AttackStrategy> skills = hero.getUnlockedSkills();
            for (int i = 0; i < skills.size(); i++) {
                System.out.println((i + 1) + ". " + skills.get(i).getClass().getSimpleName());
            }

            int idx = readInt() - 1;
            if (idx >= 0 && idx < skills.size()) {
                hero.setStrategy(skills.get(idx));
                hero.attackBoss(boss);
            }
        }
    }

    // ИНВЕНТАРЬ И ЭКИПИРОВКА
    private void showInventoryAndEquip() {
        if (hero.getInventory().isEmpty()) {
            System.out.println("Inventory is empty.");
            return;
        }

        System.out.println("\nInventory:");
        for (int i = 0; i < hero.getInventory().size(); i++) {
            Sellable item = hero.getInventory().get(i);
            System.out.println((i + 1) + ". " + item.getName());
        }

        System.out.print("Equip (number) or 0 to exit: ");
        int idx = readInt() - 1;
        if (idx >= 0 && idx < hero.getInventory().size()) {
            Sellable item = hero.getInventory().get(idx);
            if (item instanceof WeaponBuilder w) hero.equipWeapon(w);
            else if (item instanceof ArmorBuilder a) hero.equipArmor(a);
            else if (item instanceof PoisonBuilder p) hero.equipPoison(p);
            else if (item instanceof ArtifactBuilder a) hero.equipArtifact(a);
        }
    }

    private void openShop() {
        shop.displayWelcome();
        System.out.print("Buy (item name) or 'back': ");
        String input = scanner.nextLine().trim();
        if (!input.equalsIgnoreCase("back")) {
            shop.buy(input);
        }
    }

    private void displayPlayerStats() {
        System.out.printf("""
            ╔═══════════════════════════════════════════╗
            ║               HUNTER STATUS               ║
            ║ Name: %-33s ║
            ║ Rank: %-3s       Level: %-3d   EXP: %-6d ║
            ║ HP: %-4d/%-4d           Gold: %-6d     ║
            ║ Inventory: %-2d items                     ║
            ╚═══════════════════════════════════════════╝
            """, hero.getHeroName(), currentRank, hero.getLevel(), hero.getExp(),
                hero.getHp(), hero.getTotalHP(), hero.getGold(), hero.getInventory().size());
    }

    // Безопасное чтение int
    private int readInt() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (Exception e) {
                System.out.print("Enter a number: ");
            }
        }
    }
}