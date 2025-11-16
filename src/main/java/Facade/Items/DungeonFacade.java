package Facade.Items;

import Builder.DungeonBuilder;
import Facade.Sellable;
import Factory.Boss.BossFactory;
import Factory.Hero.Hero;

public class DungeonFacade {

    private final BossFactory bossFactory = new BossFactory();
    private final ArtifactFacade artifactFacade = new ArtifactFacade();

    public DungeonBuilder createDungeon(String type) {

        DungeonBuilder.Builder builder = new DungeonBuilder.Builder();

        switch (type.toLowerCase()) {

            case "s rank dungeon" -> {
                var artifact = artifactFacade.createArtifact("ring of strength");
                return builder
                        .setName("Realm of the Monarchs")
                        .setDescription("Elite shadowborn monsters. Monarch's overwhelming aura.")
                        .setFloors(10)
                        .setMonsters(50)
                        .setBoss("monarch")                 // <<<< FIX
                        .setArtifact(artifact)
                        .setArtifactDropChance(50)
                        .setReward("Monarch Core")
                        .setExp(2000)
                        .build();
            }

            case "a rank dungeon" -> {
                var artifact = artifactFacade.createArtifact("amulet of speed");
                return builder
                        .setName("Goblin Cave")
                        .setDescription("Demonic goblins and traps.")
                        .setFloors(7)
                        .setMonsters(30)
                        .setBoss("demon king")
                        .setArtifact(artifact)
                        .setArtifactDropChance(40)
                        .setReward("Goblin Crown")
                        .setExp(600)
                        .build();
            }

            case "b rank dungeon" -> {
                var artifact = artifactFacade.createArtifact("crystal of focus");
                return builder
                        .setName("Dragon's Lair")
                        .setDescription("Volcanic cavern.")
                        .setFloors(5)
                        .setMonsters(21)
                        .setBoss("dragon")
                        .setArtifact(artifact)
                        .setArtifactDropChance(30)
                        .setReward("Dragon Heart")
                        .setExp(400)
                        .build();
            }

            case "c rank dungeon" -> {
                var artifact = artifactFacade.createArtifact("shieldstone of protection");
                return builder
                        .setName("Labyrinth of the Minotaur")
                        .setDescription("Stone labyrinth.")
                        .setFloors(4)
                        .setMonsters(15)
                        .setBoss("minotaur")
                        .setArtifact(artifact)
                        .setArtifactDropChance(20)
                        .setReward("Minotaur Axe")
                        .setExp(250)
                        .build();
            }

            case "d rank dungeon" -> {
                return builder
                        .setName("Orc Camp")
                        .setDescription("Fortified encampment.")
                        .setFloors(2)
                        .setMonsters(8)
                        .setBoss("orc captain")
                        .setReward("Orc Captain's Helmet")
                        .setExp(90)
                        .build();
            }

            case "e rank dungeon" -> {
                return builder
                        .setName("Abandoned Mine")
                        .setDescription("Goblin ambushes.")
                        .setFloors(1)
                        .setMonsters(5)
                        .setBoss("goblin leader")
                        .setReward("Rusty Pickaxe")
                        .setExp(40)
                        .build();
            }

            default -> throw new IllegalArgumentException("Unknown dungeon: " + type);
        }
    }


    public void completeDungeon(Hero hero, DungeonBuilder dungeon) {
        System.out.println("Dungeon completed: " + dungeon.getName());

        if (dungeon.getArtifact() != null) {
            if (Math.random() * 100 <= dungeon.getArtifactDropChance()) {
                hero.addItem(dungeon.getArtifact());
            }
        }

        System.out.println("Reward: " + dungeon.getReward());
        hero.addGold(dungeon.getExp());
    }
}
