package Builder;

public class QuestBuilder {
    private final String dungeonName;
    private final String description;
    private final DungeonBuilder dungeon;

    private QuestBuilder(Builder builder) {
        this.dungeonName = builder.dungeonName;
        this.description = builder.description;
        this.dungeon = builder.dungeon;
    }

    public String getDungeonName() {
        return dungeonName;
    }
    public String getDescription() {
        return description;
    }
    public DungeonBuilder getDungeon() {
        return dungeon;
    }


    public static class Builder {
        private String dungeonName;
        private String description;
        private DungeonBuilder dungeon;


        public Builder setDungeonName(String name) {
            this.dungeonName = name;
            return this;
        }

        public Builder setDescription(String desc) {
            this.description = desc;
            return this;
        }

        public Builder setDungeon(DungeonBuilder dungeon) {
            this.dungeon = dungeon;
            return this;
        }

        public QuestBuilder build() {
            return new QuestBuilder(this);
        }
    }
}
