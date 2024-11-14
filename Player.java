public class Player {
    private String name;
    private boolean isComputer;

    // Constructor to initialize the player's name and determine if they're a computer
    public Player(String name) {
        this.name = name;
        this.isComputer = name.toLowerCase().contains("computer");
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Check if the player is a computer
    public boolean isComputer() {
        return isComputer;
    }
}
