package Factory.Hero;

public class HeroFactory {
    public Hero createHero(String type,String heroName) {
        switch (type.toLowerCase()) {
            case "assassin":
                return new Assassin(heroName);
            case "healer":
                return new Healer(heroName);
            case "mage":
                return new Mage(heroName);
            case "summoner":
                return new Summoner(heroName);
            default:
                System.out.println("Invalid hero");
                return null;
        }

    }
}
