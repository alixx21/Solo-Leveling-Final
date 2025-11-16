package Facade.Items;

import Builder.ArtifactBuilder;

public class ArtifactFacade {
    public ArtifactBuilder createArtifact(String type) {
        ArtifactBuilder.Builder builder = new ArtifactBuilder.Builder();
        return switch (type.toLowerCase()) {
            case "ring of strength" -> builder
                    .setName("Ring of Strength")
                    .setRarity("Epic")
                    .setEffect(1.5)
                    .setValue(40)
                    .build();
            case "amulet of speed" -> builder
                    .setName("Amulet of Speed")
                    .setRarity("Rare")
                    .setEffect(1.3)
                    .setValue(15)
                    .build();
            case "crystal of focus" -> builder
                    .setName("Crystal of Focus")
                    .setRarity("Uncommon")
                    .setEffect(1.2)
                    .setValue(10)
                    .build();
            case "shieldstone of protection" -> builder
                    .setName("Shieldstone of Protection")
                    .setRarity("Common")
                    .setEffect(1.1)
                    .setValue(30)
                    .build();
            default -> throw new IllegalArgumentException("Unknown artifact: " + type);
        };
    }
}