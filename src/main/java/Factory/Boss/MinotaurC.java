package Factory.Boss;

public class MinotaurC extends Boss {
    public MinotaurC(String BossName, String BossType){
        super("Goliath","Minotaur");

        this.bosshp=6000;
        this.bossdmg=2200;
        this.bosslevel=29;
        this.expvalue=6000;;
        this.requiredlvl=20;
    }
}
