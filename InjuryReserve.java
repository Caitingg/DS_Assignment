import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InjuryReserve {
    private List<Player> players = new ArrayList<>();
    private List<Player> injuryReserve = new ArrayList<>();
    private List<Player> contractExtensionQueue = new ArrayList<>();

    public void addToInjuryReserve(Player player) {
        injuryReserve.add(player);
        System.out.println("--Adding Player to Injury Reserve--");
        System.out.println("Player: " + player.getFullName());
        System.out.println("Injury: " + player.getInjury());
        System.out.println("Status: Added to Injury Reserve\n");
    }

    public Player removeFromInjuryReserve() {
        if (!injuryReserve.isEmpty()) {
            Player removedPlayer = injuryReserve.remove(0);
            return removedPlayer;
        } else {
            System.out.println("Injury Reserve is empty");
            return null;
        }
    }

    public void moveToActiveRoster(Player player) {
        player.setInjured(false);
        // Add logic to remove player from injury reserve and add back to active roster
    }

    public void addUserInjuredPlayer() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name of the injured player: ");
        String playerName = scanner.nextLine();
        System.out.println("Enter the reason for the injury: ");
        String injuryReason = scanner.nextLine();
        Player player = new Player(playerName, injuryReason);
        addToInjuryReserve(player);
    }
}