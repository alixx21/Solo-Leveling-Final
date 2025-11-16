package Observers;

public class BattleLogger implements Observer {
    private static BattleLogger instance;
    private BattleLogger() {
    }
    public static BattleLogger getInstance() {
        if (instance == null) {
            instance = new BattleLogger();
        }
        return instance;
    }

    @Override
    public void update(String message) {
        System.out.println("[LOG] " + message);
    }
}