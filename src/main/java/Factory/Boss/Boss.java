package Factory.Boss;

import Factory.Hero.Hero;

import java.util.Scanner;

public abstract class Boss {
    protected String bossName;
    protected String bossType;
    public int bosshp;
    public int bossdmg;
    public int bosslevel;
    public int expvalue;
    public int requiredlvl;
    private boolean answer=false;
    private String [] mathquestions={
            "Solve: 12 * 7 = ?",
            "Solve: 45 + 27 = ?",
            "Solve: 90 / 3 = ?",
            "Solve: 14 * 14 = ?",
            "Solve: 5 + 17 * 2 = ?",
            "Solve: 120 - 47 = ?",
            "Solve: 9 * 8 = ?",
            "Solve: 144 / 12 = ?"
    };
    private int [] mathanswers={
            84,
            72,
            30,
            196,
            39,
            73,
            72,
            12
    };
    private String[] historyquestions = {
            "When did Kazakhstan declare independence? (1)1991  (2)1986  (3)1995",
            "When did Zheltoksan events happen? (1)1986  (2)1991  (3)1979",
            "When was the Constitution of Kazakhstan adopted? (1)1995  (2)1991  (3)2000",
            "Who was the first President of Kazakhstan? (1)Nazarbayev  (2)Tokayev  (3)Kunayev",
    };
    private int[] historyanswers = {
            1,
            1,
            1,
            1
    };

    protected Boss(String BossName, String BossType) {
        this.bossName = BossName;
        this.bossType = BossType;
    }

    public String getBossName() {
        return bossName;
    }
    public String getBossType() {
        return bossType;
    }
    public int getBosshhp() {
        return bosshp;
    }
    public int getBossdmg() {
        return bossdmg;
    }
    public int getBosslevel() {
        return bosslevel;
    }
    public int getExpvalue() {
        return expvalue;
    }
    public int getRequiredlvl() {
        return requiredlvl;
    }
    public void takeDamageBoss(int finaldamage){
        this.bosshp -= finaldamage;
    }

    public void bossresponce(Hero hero) {
        System.out.println("Boss attacking!!!");
        System.out.println("Choose:\n1.Block(answer for math questions)\n2.Dodge(answer for history questions)");
        Scanner choice = new Scanner(System.in);
        int choiceInt = choice.nextInt();
        if(choiceInt == 1){
            block(hero);
            if(answer==false){
                int dmg = this.bossdmg;
                hero.takeDamage(dmg);
                System.out.println(bossName + " attacked with " + dmg + " damage");
            }else{
                System.out.println("Blocked boss attack!");
            }
        }else if(choiceInt == 2){
            dodge(hero);
            if(answer==false){
                int dmg = this.bossdmg;
                hero.takeDamage(dmg);
                System.out.println(bossName + " attacked with " + dmg + " damage");
            }else{
                System.out.println("Dodged boss attack!");
            }
        }
        else {
            System.out.println("Invalid Choice");
        }
    }

    public void dodge(Hero hero) {
        int i = (int) (Math.random() * historyquestions.length);
        System.out.println(historyquestions[i]);
        Scanner sc = new Scanner(System.in);
        int ans = sc.nextInt();
        if(ans == historyanswers[i]){
            answer = true;
        }else answer = false;
    }

    public void block(Hero hero){
        int i = (int) (Math.random() * mathanswers.length);
        System.out.println(mathquestions[i]);
        Scanner sc = new Scanner(System.in);
        int ans = sc.nextInt();
        if(ans == mathanswers[i]){
            answer = true;
        }
        else answer = false;
    }
}
