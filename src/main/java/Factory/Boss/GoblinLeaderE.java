package Factory.Boss;

public class GoblinLeaderE extends Boss {
    public GoblinLeaderE(String BossName, String BossType) {
        super("Vrek","GoblinLeader");

        this.bosshp=2000;
        this.bossdmg=1000;
        this.bosslevel=11;
        this.expvalue=2000;;
        this.requiredlvl=3;
    }
}
