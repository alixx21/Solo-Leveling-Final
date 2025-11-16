import Factory.Hero.*;
import Factory.Monsters.*;
import Factory.Boss.*;
import Facade.Items.DungeonFacade;
import Facade.GameFacade;
import Facade.Shop;
import Builder.DungeonBuilder;
import Strategy.*;

import java.util.*;

public class Menu {

    private Scanner sc = new Scanner(System.in);
    private Hero hero;
    private DungeonFacade df = new DungeonFacade();
    private MonsterFactory mf = new MonsterFactory();
    private BossFactory bf = new BossFactory();
    private HeroFactory hf = new HeroFactory();
    private GameFacade game= new GameFacade();
    private Shop shop;


    public void start() {

        System.out.println("You arrived at the Hunter Guild.");
        System.out.print("Enter your name: ");
        String name = sc.next();

        generateHero(name);

        //game = new GameFacade(hero);
        shop = new Shop(hero);

        System.out.println("Guild Notice: E-rank dungeons opened.");
        enterDungeonFlow();
    }

    private void generateHero(String name) {

        int chance = (int)(Math.random() * 100);

        if (chance < 5) {
            hero = hf.createHero("healer", name);
            System.out.println("Class: Healer");
        }
        else if (chance < 40) {
            hero = hf.createHero("assassin", name);
            System.out.println("Class: Assassin");
        }
        else if (chance < 70) {
            hero = hf.createHero("mage", name);
            System.out.println("Class: Mage");
        }
        else {
            hero = hf.createHero("summoner", name);
            System.out.println("Class: Summoner");
        }
        System.out.println();
    }

    private void enterDungeonFlow() {

        DungeonBuilder dungeon = df.createDungeon("e rank dungeon");

        System.out.println("Dungeon: " + dungeon.getName());
        System.out.println(dungeon.getDescription());
        System.out.println("NPC: Others are fighting inside.");
        System.out.println("NPC: Attack squad already went to the boss.");
        System.out.println("NPC: Decide quickly.");
        System.out.println();

        boolean inside = true;

        while (inside) {

            System.out.println("1. Clear monsters");
            System.out.println("2. Go to boss");
            System.out.println("3. Leave dungeon");
            System.out.println("4. Shop");
            System.out.println("5. Player Stats");
            System.out.print("Choose: ");

            int choice = sc.nextInt();

            if (choice == 1) {
                clearWave();
                afterWave();
            }
            else if (choice == 2) {
                fightBoss(dungeon);
            }
            else if (choice == 3) {
                System.out.println("You left the dungeon.");
                inside = false;
            }
            else if (choice == 4) {
                openShop();
            }
            else if (choice == 5) {
                displayStats();
            }
            else {
                System.out.println("Invalid choice, try again.");
            }
            System.out.println();
        }
    }

    private void clearWave() {

        System.out.println("You engage the monsters.");

        String[] Monsters = {"ants", "direwolf", "goblin"};

        for (int i = 1; i <= 5; i++) {

            int chance = (int)(Math.random() * Monsters.length);
            String type = Monsters[chance];
            Monster m = mf.createMonster(type);
            System.out.println("Monster #" + i + ": " + m.getMonsterType());
            fightMonster(m);

            if (hero.getHp() <= 0) {
                System.out.println("You were defeated.");
                System.exit(0);
            }
            System.out.println();
        }

        System.out.println("Wave cleared.");
        System.out.println();
    }

    private void afterWave() {

        System.out.println("1. Clear more monsters");
        System.out.println("2. Go to boss");
        System.out.print("Choose: ");

        int choice = sc.nextInt();

        if (choice == 1) {
            clearWave();
        }
        else if (choice == 2) {
            System.out.println("Going to boss room.");
        }
        else {
            System.out.println("Invalid choice, try again.");
        }
        System.out.println();
    }

    private void fightMonster(Monster m) {

        while (m.monsterhp > 0 && hero.getHp() > 0) {

            System.out.println(hero.getHeroName() + " HP: " + hero.getHp());
            System.out.println(m.getMonsterType() + " HP: " + m.monsterhp);

            System.out.println("Choose attack:");

            List<AttackStrategy> skills = hero.getUnlockedSkills();

            for (int i = 0; i < skills.size(); i++) {
                System.out.println((i + 1) + ". " + skills.get(i).getClass().getSimpleName());
            }
            System.out.println();

            int idx = sc.nextInt();
            idx--;

            if (idx < 0 || idx >= skills.size()) {
                System.out.println("Invalid choice, try again.");
                continue;
            }
            System.out.println();

            hero.setStrategy(skills.get(idx));
            hero.attack(m);

            if (m.monsterhp > 0) {
                m.monsterresponce(hero);
            }
            System.out.println();
        }

        System.out.println(m.getMonsterType() + " defeated.");
        System.out.println("Gained EXP: " + m.getMonsterexpvalue());
        hero.gainExp(m.getMonsterexpvalue());
        System.out.println();
    }

    private void fightBoss(DungeonBuilder dungeon) {

        System.out.println("Boss room opened.");

        Boss boss = bf.createBoss(dungeon.getBoss());
        System.out.println("Boss: " + boss.getBossName());

        while (boss.getBosshhp() > 0 && hero.getHp() > 0) {

            System.out.println(hero.getHeroName() + " HP: " + hero.getHp());
            System.out.println("Boss HP: " + boss.getBosshhp());
            System.out.println();

            System.out.println("Choose attack:");

            List<AttackStrategy> skills = hero.getUnlockedSkills();

            for (int i = 0; i < skills.size(); i++) {
                System.out.println((i + 1) + ". " + skills.get(i).getClass().getSimpleName());
            }
            System.out.println();

            int idx = sc.nextInt();
            idx--;

            if (idx < 0 || idx >= skills.size()) {
                System.out.println("Invalid choice, try again.");
                continue;
            }

            hero.setStrategy(skills.get(idx));
            hero.attackBoss(boss);
            System.out.println();
        }

        System.out.println("Boss defeated.");
        System.out.println("Reward: " + dungeon.getReward());
        hero.gainExp(dungeon.getExp());

        postBossMenu();
    }

    private void postBossMenu() {
        boolean loop = true;
        while (loop) {
            System.out.println("1. Go to Shop");
            System.out.println("2. Player Stats");
            System.out.println("3. Exit");
            System.out.print("Choose: ");

            int c = sc.nextInt();

            if (c == 1) openShop();
            else if (c == 2) displayStats();
            else if (c == 3) loop = false;
            else System.out.println("Invalid choice");
        }
    }

    private void openShop() {
        shop.displayWelcome();
        System.out.print("Enter item name to buy or 'back': ");
        String item = sc.next();

        if (!item.equalsIgnoreCase("back")) {
            shop.buy(item);
        }
    }

    private void displayStats() {
        System.out.println();
        System.out.println("Gold: " + hero.getGold());
        System.out.println("HP: " + hero.getHp());
        System.out.println("Level: " + hero.getLevel());
        System.out.println("EXP: " + hero.getExp());
        System.out.println("Items: " + hero.inventory.size());
        System.out.println();
    }
}
