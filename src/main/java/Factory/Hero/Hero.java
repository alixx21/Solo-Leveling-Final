package Factory.Hero;

import Builder.ArmorBuilder;
import Builder.PoisonBuilder;
import Builder.WeaponBuilder;
import Facade.Sellable;
import Factory.Boss.Boss;
import Factory.Monsters.Monster;
import Strategy.AttackStrategy;
import Visitor.Visitor;
import Observers.*;
import Builder.ArtifactBuilder;
import Visitor.SkillUnlockVisitor;

import java.util.ArrayList;
import java.util.List;

public abstract class Hero implements Subject  {
    private List<Observer> observers = new ArrayList<>();
    public List<AttackStrategy> unlockedskills = new ArrayList<>();
    public List<Sellable> inventory = new ArrayList<>();

    protected String heroName;
    protected String heroTitle;
    protected String heroType;
    protected String evolveType;
    protected AttackStrategy strategy;
    protected double artifactDamageMultiplier = 1.0;
    protected int damage;
    protected int herohp;
    protected int lvl ;
    protected int exp = 0;
    private int gold = 100;
    private int armorBonusHP = 0;
    private WeaponBuilder equippedWeapon;
    private ArmorBuilder equippedArmor;
    private PoisonBuilder equippedPoison;
    private List<ArtifactBuilder> equippedArtifacts = new ArrayList<>();

    protected Hero(String heroName, AttackStrategy strategy, String heroType) {
        this.heroName = heroName;
        this.strategy = strategy;
        this.heroType = heroType;
        this.evolveType = "";
        this.heroTitle = "";
        this.armorBonusHP = 0;
    }


    public int getTotalHP() {
        return herohp + armorBonusHP;
    }


    public void attackBoss(Boss boss) {
        int finaldamage = calculateDamage();
        boss.takeDamageBoss(finaldamage);
        notifyObservers(heroName + " attacks " + boss.getBossName() + " for " + finaldamage + " damage");


        if (boss.getBosshhp() > 0) {
            boss.bossresponce(this);
        } else {
            notifyObservers(boss.getBossName() + " defeated");
            gainExp(boss.getExpvalue());
        }
    }

    public void equipWeapon(WeaponBuilder weapon) {
        this.equippedWeapon = weapon;
        System.out.println("Equipped weapon: " + weapon.getName() + " (+" + weapon.getDamage() + " damage)");
    }

    public void equipArmor(ArmorBuilder armor) {
        if (equippedArmor != null) armorBonusHP -= equippedArmor.getDefense();
        this.equippedArmor = armor;
        armorBonusHP += armor.getDefense();
        System.out.println("Equipped armor: " + armor.getName() + " (+" + armor.getDefense() + " HP)");
    }

    public void equipPoison(PoisonBuilder poison) {
        this.equippedPoison = poison;
        System.out.println("Poison applied: " + poison.getName());
    }

    public void equipArtifact(ArtifactBuilder artifact) {
        equippedArtifacts.add(artifact);
        artifactDamageMultiplier *= artifact.getEffect();
        System.out.println("Artifact activated: " + artifact.getName() + " (x" + artifact.getEffect() + " damage)");
    }

    public int calculateDamage() {
        return (int) ((damage * strategy.getMultiplier()) * artifactDamageMultiplier);

    }

    public void takeDamage(int dmg) {
        int effectiveHP = herohp + armorBonusHP;
        effectiveHP -= dmg;

        if (effectiveHP > 0) {
            herohp = effectiveHP;
        } else {
            herohp = 0;
        }
    }

    public void unlockedskills(AttackStrategy skill) {

        boolean alreadyUnlocked = unlockedskills.stream().anyMatch(s -> s.getClass().equals(skill.getClass()));

        if (!alreadyUnlocked) {
            unlockedskills.add(skill);
            notifyObservers(heroName + " unlocked skill " + skill.getClass().getSimpleName());
        }
    }


    public void gainExp(int exp) {
        System.out.println("Gained EXP: " + exp);
        this.exp += exp;
        System.out.println("Total EXP: " + this.exp);

        while (this.exp >= this.lvl * 100) {
            this.exp -= this.lvl * 100;
            this.lvl++;
            this.damage += 50;
            this.herohp += 100;
            notifyObservers(heroName + " level uped to " + this.lvl);
            this.accept(new SkillUnlockVisitor());
        }
    }


    public int heal() {
        return 20;
    }

    public void calculateHeal() {
        herohp = herohp + heal();
    }

    public void evolveto(String evolveType) {
        this.evolveType = evolveType;
        notifyObservers(heroName + " evolved to " + evolveType);
    }

    public void newHerotitle(String title) {
        this.heroTitle = title;
        notifyObservers(heroName + " got new title " + title);
    }


    public void applyArtifact(ArtifactBuilder artifact) {
        artifactDamageMultiplier *= artifact.getDamageMultiplier();
        armorBonusHP += artifact.getBonusHP();
        inventory.add(artifact);
    }

    public void tryAddArtifact(ArtifactBuilder artifact, int chance) {
        int roll = (int) (Math.random() * 100);
        if (roll <= chance) {
            inventory.add(artifact);
            applyArtifact(artifact);
            System.out.println("Artifact dropped: " + artifact.getName());
        } else {
            System.out.println("No artifact dropped");
        }
    }
    public List<AttackStrategy> getUnlockedSkills() {
        return unlockedskills;
    }

    public void setStrategy(AttackStrategy s) {
        this.strategy = s;
    }


    public void addGold(int amount) {
        gold += amount;
    }

    public boolean spendGold(int amount) {
        if (gold >= amount) {
            gold -= amount;
            return true;
        }
        return false;
    }

    public void addItem(Sellable item) {
        inventory.add(item);
    }

    public void removeItem(Sellable item) {
        inventory.remove(item);
    }

    public void showInventory() {
        for (Sellable i : inventory) {
            System.out.println(i.getName() + " (" + i.getValue() + ")");
        }
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }


    public String getHeroName() {
        return heroName;
    }

    public String getHeroType() {
        return heroType;
    }

    public int getHp() {
        return herohp;
    }

    public int getLevel() {
        return lvl;
    }

    public int getExp() {
        return exp;
    }

    public int getGold() {
        return gold;
    }
    public List<Sellable> getInventory(){
        return inventory;
    }

    public abstract void accept(Visitor visitor);

    public void attack(Monster monster) {
        int finaldamage = calculateDamage();
        monster.takeDamage(finaldamage);
        notifyObservers(heroName + " attacks " + monster.getMonsterType() + " for " + finaldamage + " damage");


        if (monster.getMonsterexpvalue() > 0) {
            monster.monsterresponce(this);
        } else {
            notifyObservers(monster.getMonsterType() + " defeated");
            gainExp(monster.getMonsterexpvalue());
        }
    }
}
