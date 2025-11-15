package Factory.Boss;

public class OrcCaptainD extends Boss {
    public OrcCaptainD(String BossName, String BossType){
        super("Brukk","Orc captain");

        this.bosshp=3500;
        this.bossdmg=1300;
        this.bosslevel=29;
        this.expvalue=3500;;
        this.requiredlvl=10;
    }
}
