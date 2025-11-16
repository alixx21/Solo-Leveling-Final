package Builder;

import Facade.Sellable;

public class DungeonBuilder {
    private final String name;
    private final String description;
    private final int floors;
    private final int monsters;
    private final String boss;
    private final String reward;
    private final int exp;
    private final double artifactDropChance;
    private final Sellable artifact;

    public DungeonBuilder(Builder builder) {
        this.name = builder.name;
        this.description = builder.description;
        this.floors = builder.floors;
        this.monsters = builder.monsters;
        this.boss = builder.boss;
        this.reward = builder.reward;
        this.exp = builder.exp;
        this.artifactDropChance = builder.artifactDropChance;
        this.artifact = builder.artifact;
    }

    public String getName() { return name; }
    public String getDescription() { return description; }
    public int getFloors() { return floors; }
    public int getMonsters() { return monsters; }
    public String getBoss() { return boss; }
    public String getReward() { return reward; }
    public int getExp() { return exp; }
    public Sellable getArtifact() { return artifact; }
    public double getArtifactDropChance() { return artifactDropChance; }

    public static class Builder {
        private String name;
        private String description;
        private int floors;
        private int monsters;
        private String boss;
        private String reward;
        private int exp;
        private double artifactDropChance;
        private Sellable artifact;

        public Builder setName(String name) { this.name = name; return this; }
        public Builder setDescription(String description) { this.description = description; return this; }
        public Builder setFloors(int floors) { this.floors = floors; return this; }
        public Builder setMonsters(int monsters) { this.monsters = monsters; return this; }
        public Builder setBoss(String boss) { this.boss = boss; return this; }
        public Builder setReward(String reward) { this.reward = reward; return this; }
        public Builder setExp(int exp) { this.exp = exp; return this; }
        public Builder setArtifact(Sellable artifact) { this.artifact = artifact; return this; }
        public Builder setArtifactDropChance(double chance) { this.artifactDropChance = chance / 100.0; return this; }

        public DungeonBuilder build() { return new DungeonBuilder(this); }
    }
}