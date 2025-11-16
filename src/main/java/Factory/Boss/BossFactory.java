package Factory.Boss;


public class BossFactory {
    public Boss createBoss(String bossType) {
        return switch (bossType.toLowerCase()) {
            case "demon king" -> new DemonKingA("Baran" ,"Demon king");
            case "dragon" -> new DragonlingB("Kamish","Dragon");
            case "minotaur" -> new MinotaurC("Goliath","Minotaur");
            case "goblin leader" -> new GoblinLeaderE("Vrek","Goblin leader");
            case "orc captain" -> new OrcCaptainD("Brukk","Orc captain");
            case "monarch" -> new MonarchS("Antares", "Monarch");
            default -> null;
        };
    }
}
