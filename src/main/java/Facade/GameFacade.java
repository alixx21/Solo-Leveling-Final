package Facade;

import Builder.DungeonBuilder;
import Facade.Items.DungeonFacade;
import Observers.UserInterfaceNotifications;
import Factory.Hero.*;
import Factory.Monsters.*;
import Factory.Boss.*;
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

//    public GameFacade(Hero hero) {
//        this.hero = hero;
//        this.shop = new Shop(hero);
//        UserInterfaceNotifications.registerAllNotifications();
//    }

    public GameFacade() {
        UserInterfaceNotifications.registerAllNotifications();
        this.shop = new Shop(null); // будет переприсвоен после создания героя
        createHeroAndStart();
    }

    // ЕДИНСТВЕННЫЙ ПУБЛИЧНЫЙ МЕТОД — запускает всю игру
    public void start() {
        // Main вызывает только этот метод — и всё работает
    }
    public void createHeroAndStart() {
        System.out.print("Enter your name, Hunter: ");
        String name = scanner.nextLine().trim();
        if (name.isEmpty()) name = "Sung Jin-Woo";
        HeroFactory factory = new HeroFactory();
        int roll = (int)(Math.random() * 100);
        if (roll < 5)      hero = factory.createHero("healer", name);
        else if (roll < 40) hero = factory.createHero("assassin", name);
        else if (roll < 70) hero = factory.createHero("mage", name);
        else               hero = factory.createHero("summoner", name);

        System.out.printf("""
                ╔══════════════════════════════════════════════╗
                ║           Welcome to Solo Leveling!          ║
                ║                                              ║
                ║    The adventure begins... Good luck, hero!  ║
                ╚══════════════════════════════════════════════╝
                
                Initial Stats:
                Health: %d
                Gold: %d
                Inventory: %d items
                
                """,hero.getHp(),hero.getGold(), hero.getInventory().size());



        this.shop = new Shop(hero);
        System.out.println("\nAwakening complete. Rank: E → ???");
        System.out.println("Class: " + hero.getClass().getSimpleName() + "\n");
        enterDungeonFlow();
    }

    private void enterDungeonFlow() {
        DungeonBuilder dungeon = dungeonFacade.createDungeon("e rank dungeon");
        System.out.println("Dungeon: " + dungeon.getName());
        System.out.println(dungeon.getDescription());
        System.out.println("NPC: Others are fighting inside.");
        System.out.println("NPC: Attack squad already went to the boss.");
        System.out.println("NPC: Decide quickly.\n");

        boolean inside = true;
        while (inside) {
            displayDungeonMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1 -> clearWave();
                case 2 -> fightBoss(dungeon);
                case 3 -> {
                    System.out.println("You left the dungeon.");
                    inside = false;
                }
                case 4 -> openShop();
                case 5 -> displayPlayerStats();
                default -> System.out.println("Invalid choice, try again.");
            }
            System.out.println();
        }
    }

    private void displayDungeonMenu() {
        System.out.println("╔════════════════════════════════════╗");
        System.out.println("║           DUNGEON MENU             ║");
        System.out.println("╠════════════════════════════════════╣");
        System.out.println("║ 1. Clear monsters                  ║");
        System.out.println("║ 2. Go to boss                      ║");
        System.out.println("║ 3. Leave dungeon                   ║");
        System.out.println("║ 4. Shop                            ║");
        System.out.println("║ 5. Player Stats                    ║");
        System.out.println("╚════════════════════════════════════╝");
        System.out.print("Choose: ");
    }

    private void clearWave() {
        System.out.println("You engage the monsters.");
        String[] monsterTypes = {"ants", "direwolf", "goblin"};

        for (int i = 1; i <= 5; i++) {
            String type = monsterTypes[(int)(Math.random() * monsterTypes.length)];
            Monster monster = monsterFactory.createMonster(type);
            System.out.println("Monster #" + i + ": " + monster.getMonsterType());

            fightMonster(monster);

            if (hero.getHp() <= 0) {
                System.out.println("You were defeated. Game Over.");
                System.exit(0);
            }
            System.out.println();
        }
        System.out.println("Wave cleared!");
        afterWave();
    }

    private void afterWave() {
        System.out.println("1. Clear more monsters");
        System.out.println("2. Go to boss");
        System.out.print("Choose: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice == 1) {
            clearWave();
        } else if (choice == 2) {
            System.out.println("Going to boss room.");
        }
    }

    private void fightMonster(Monster monster) {
        while (monster.getMonsterhp() > 0 && hero.getHp() > 0) {
            System.out.println(hero.getHeroName() + " HP: " + hero.getHp());
            System.out.println(monster.getMonsterType() + " HP: " + monster.getMonsterhp());

            System.out.println("Choose attack:");
            List<AttackStrategy> skills = hero.getUnlockedSkills();
            for (int i = 0; i < skills.size(); i++) {
                System.out.println((i + 1) + ". " + skills.get(i).getClass().getSimpleName());
            }

            int idx = scanner.nextInt() - 1;
            scanner.nextLine();

            if (idx >= 0 && idx < skills.size()) {
                hero.setStrategy(skills.get(idx));
                hero.attack(monster);

                if (monster.getMonsterhp() > 0) {
                    monster.monsterresponce(hero);
                }
            } else {
                System.out.println("Invalid choice!");
            }
        }
        if (hero.getHp() > 0) {
            System.out.println(monster.getMonsterType() + " defeated!");
            hero.gainExp(monster.getMonsterexpvalue());
        }
    }

    private void fightBoss(DungeonBuilder dungeon) {
        System.out.println("Boss room opened.");
        Boss boss = bossFactory.createBoss(dungeon.getBoss());
        System.out.println("Boss: " + boss.getBossName());

        while (boss.getBosshhp() > 0 && hero.getHp() > 0) {
            System.out.println(hero.getHeroName() + " HP: " + hero.getHp());
            System.out.println("Boss HP: " + boss.getBosshhp());

            System.out.println("Choose attack:");
            List<AttackStrategy> skills = hero.getUnlockedSkills();
            for (int i = 0; i < skills.size(); i++) {
                System.out.println((i + 1) + ". " + skills.get(i).getClass().getSimpleName());
            }

            int idx = scanner.nextInt() - 1;
            scanner.nextLine();

            if (idx >= 0 && idx < skills.size()) {
                hero.setStrategy(skills.get(idx));
                hero.attackBoss(boss);
            } else {
                System.out.println("Invalid choice!");
            }
        }

        if (hero.getHp() > 0) {
            System.out.println("Boss defeated!");
            System.out.println("Reward: " + dungeon.getReward());
            hero.gainExp(dungeon.getExp());
            postBossMenu();
        }
    }

    private void postBossMenu() {
        boolean loop = true;
        while (loop) {
            System.out.println("1. Go to Shop");
            System.out.println("2. Player Stats");
            System.out.println("3. Exit");
            System.out.print("Choose: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> openShop();
                case 2 -> displayPlayerStats();
                case 3 -> loop = false;
                default -> System.out.println("Invalid choice");
            }
        }
    }

    private void openShop() {
        shop.displayWelcome();
        System.out.print("Enter item name to buy or 'back': ");
        String item = scanner.nextLine().trim();

        if (!item.equalsIgnoreCase("back")) {
            shop.buy(item);
        }
    }

    public void displayPlayerStats() {
        System.out.printf("""
                ╔════════════════════════════════════╗
                ║    Gold: %6d       HP: %3d/%3d     ║
                ║    Items: %2d                      ║
                ║    Level: %2d      EXP: %3d        ║
                ╚════════════════════════════════════╝
                """,
                hero.getGold(),
                hero.getHp(),
                hero.getTotalHP(),
                hero.getInventory().size(),
                hero.getLevel(),
                hero.getExp());
    }


    public void createRandomHero(String playerName) {
        HeroFactory heroFactory = new HeroFactory();
        int chance = (int)(Math.random() * 100);

        if (chance < 5) {
            hero = heroFactory.createHero("healer", playerName);
            System.out.println("Class: Healer");
        } else if (chance < 40) {
            hero = heroFactory.createHero("assassin", playerName);
            System.out.println("Class: Assassin");
        } else if (chance < 70) {
            hero = heroFactory.createHero("mage", playerName);
            System.out.println("Class: Mage");
        } else {
            hero = heroFactory.createHero("summoner", playerName);
            System.out.println("Class: Summoner");
        }
        this.shop = new Shop(hero);
    }
}