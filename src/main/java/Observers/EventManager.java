package Observers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventManager {
    private static final EventManager instance = new EventManager();
    private final Map<String, List<Runnable>> listeners = new HashMap<>();

    private EventManager() { }
    public static EventManager getInstance() {
        return instance;
    }

    public void addListener(String eventName, Runnable action) {
        listeners.computeIfAbsent(eventName, k -> new ArrayList<>()).add(action);
    }

    public void notifyObservers(String eventName) {
        notifyObservers(eventName, null);
    }

    public void notifyObservers(String eventName, Object data) {
        System.out.println("\n[EVENT] " + eventName +
                (data != null ? " → " + data : ""));

        List<Runnable> actions = listeners.getOrDefault(eventName, new ArrayList<>());
        for (Runnable action : actions) {
            try {
                action.run();
            } catch (Exception e) {
                System.err.println("Error while handling event: " + eventName);
            }
        }
    }
}