package Observers;

public class GameAnnouncer implements Observer {

    @Override
    public void update(String message) {
        System.out.println("[EVENT]: " + message + "\n");
    }
}
