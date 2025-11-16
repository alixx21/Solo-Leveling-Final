package Factory.Boss;


public class DemonKingA extends Boss {
    public DemonKingA(String BossName, String BossType){
        super("Baran","DemonKing");

        this.bosshp=20000;
        this.bossdmg=5000;
        this.bosslevel=30;
        this.expvalue=19700;
        this.requiredlvl=80;
    }

}
