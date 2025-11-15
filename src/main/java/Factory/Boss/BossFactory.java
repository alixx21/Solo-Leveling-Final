package Factory.Boss;


public class BossFactory {
    public Boss createBoss(String bossType,String bossName) {
        switch (bossType.toLowerCase()){
            case "demonking":
                return new DemonKingA(bossName,bossType);
            case "dragon":
                return new DragonlingB(bossName,bossType);
            case "minotaur":
                return new MinotaurC(bossName,bossType);
            case "monarch":
                return new MonarchS(bossName,bossType);
            default:
                return null;
        }
    }
}
