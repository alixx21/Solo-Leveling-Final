import Facade.GameFacade;
import Observers.BattleLogger;
import Observers.GameAnnouncer;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        BattleLogger logger = BattleLogger.getInstance();
        GameAnnouncer announcer = new GameAnnouncer();

        new GameFacade();



    }
}