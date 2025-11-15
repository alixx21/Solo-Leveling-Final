package Factory.Boss;

public class DragonlingB extends Boss {
    public DragonlingB(String BossName, String BossType){
        super("Kamish","Dragon");

        this.bosshp=12000;
        this.bossdmg=3900;
        this.bosslevel=34;
        this.expvalue=11700;
        this.requiredlvl=60;

    }
}
