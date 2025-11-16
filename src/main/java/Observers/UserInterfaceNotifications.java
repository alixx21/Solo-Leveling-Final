package Observers;

public class UserInterfaceNotifications {

    public static void registerAllNotifications() {
        EventManager events = EventManager.getInstance();

        events.addListener("GoldChanged", () ->
                System.out.println("    Gold amount has been updated!"));

        events.addListener("HealthChanged", () ->
                System.out.println("    Health has been updated!"));

        events.addListener("ItemPurchased", () ->
                System.out.println("    Item successfully purchased!"));

        events.addListener("ArtifactDropped", () ->
                System.out.println("    ARTIFACT DROPPED!"));

        events.addListener("DungeonCompleted", () ->
                System.out.println("    Dungeon successfully completed!"));

        events.addListener("BossDefeated", () ->
                System.out.println("    BOSS DEFEATED!"));

        events.addListener("PlayerDied", () ->
                System.out.println("    You have died..."));

        events.addListener("InventoryUpdated", () ->
                System.out.println("    Inventory has been updated!"));
    }
}