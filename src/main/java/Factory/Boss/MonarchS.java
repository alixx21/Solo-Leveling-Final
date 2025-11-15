package Factory.Boss;

public class MonarchS extends Boss {
    public MonarchS(String BossName, String BossType){
        super("Antares","Monarch");

        this.bosshp=50000;
        this.bossdmg=10000;
        this.bosslevel=101;
        this.expvalue=77777;
        this.requiredlvl=100;
    }
}
