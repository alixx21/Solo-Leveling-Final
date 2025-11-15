package Factory.Monsters;

import Factory.Monsters.S.*;
import Factory.Monsters.A.*;
import Factory.Monsters.B.*;
import Factory.Monsters.C.*;
import Factory.Monsters.D.*;
import Factory.Monsters.E.*;


public class MonsterFactory {

    public Monster createMonster(String monsterType) {
        switch (monsterType.toLowerCase()) {

            case "darkelf":
                return new DarkElf(monsterType);
            case "hellhound":
                return new Hellhound(monsterType);

            case "cerber":
                return new Cerber(monsterType);
            case "wyvern":
                return new Wyvern(monsterType);

            case "elf":
                return new Elf(monsterType);
            case "stonegolem":
                return new StoneGolem(monsterType);

            case "giantscorpion":
                return new GiantScorpion(monsterType);
            case "orc":
                return new Orc(monsterType);
            case "skeleton":
                return new Skeleton(monsterType);

            case "ants":
                return new Ants(monsterType);
            case "direwolf":
                return new DireWolf(monsterType);
            case "goblin":
                return new Goblin(monsterType);

            case "greatdemon":
                return new GreatDemon(monsterType);
            case "monarchguard":
                return new MonarchGuard(monsterType);

            default:
                return null;
        }
    }
}