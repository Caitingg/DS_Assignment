import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ContractExtensionQueue {
    private List<Player> players = new ArrayList<>();

    public void addToContractExtensionQueue(Player player) {
        players.add(player);
        System.out.println("--Adding Player to Contract Extension Queue--");
        System.out.println("Player: " + player.getID());
        System.out.println("Status: Added to contract extension queue\n");
    }

    public Player removeFromContractExtensionQueue() {
        if (!players.isEmpty()) {
            Player removedPlayer = players.remove(0);
            System.out.println("--Removing Player from Contract Extension Queue--");
            System.out.println("Player: " + removedPlayer.getFullName());
            System.out.println("Status: Contract Renewed\n");
            return removedPlayer;
        } else {
            System.out.println("Contract Extension Queue is empty");
            return null;
        }
    }

    public void prioritizePlayers() {
        // Retrieve player data from the database
        // Example: List<Player> players = database.getAllPlayers();

        // Calculate scores for each player
        for (Player player : players) {
            double score = calculatePlayerScore(player);
            player.setScore(score);
        }

        // Sort the players based on their calculated scores
        players.sort(Comparator.comparingDouble(Player::getScore).reversed());

        // Optionally, print or return the prioritized list of players
        System.out.println("Prioritized Players:");
        for (Player player : players) {
            System.out.println(player.getFullName() + ": " + player.getScore());
        }
    }

    private double calculatePlayerScore(Player player) {
        // Implement the logic to calculate the player score based on the data retrieved from the database
        // You'll need to access the relevant fields in the Player object or fetch additional data if needed
        // Example: return player.getPoints() * pointsWeight + player.getRebounds() * reboundsWeight + ...
        // You may need to query the database for additional player statistics if not all data is available in the Player object
        // Example: double points = database.getPlayerPoints(player.getId());
        // Example: double rebounds = database.getPlayerRebounds(player.getId());
        // Calculate score using the retrieved data

        // Dummy implementation
        return player.getPoints() * 2 + player.getAssists() * 1.5 + player.getRebounds() * 1.25 + player.getSteals() * 1.5 + player.getBlocks() * 1.5;
    }
}

// second one
import javax.swing.*;
        import java.awt.*;
        import java.awt.event.*;
        import java.util.ArrayList;
        import java.util.Comparator;
        import java.util.List;

public class ContractExtensionQueueGUI extends JFrame {
    private List<Player> players = new ArrayList<>();
    private List<Player> injuryReserve = new ArrayList<>();
    private JTextField playerNameField;
    private JTextField playerIdField;
    private JTextField injuryReasonField;

    public ContractExtensionQueueGUI() {
        super("Contract Extension Queue");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Initialize GUI components
        playerNameField = new JTextField(20);
        playerIdField = new JTextField(20);
        injuryReasonField = new JTextField(20);
        JButton addButton = new JButton("Add to Queue");
        JButton removeButton = new JButton("Remove from Queue");
        JButton prioritizeButton = new JButton("Prioritize Players");
        JButton addToInjuryButton = new JButton("Add to Injury Reserve");
        JButton removeFromInjuryButton = new JButton("Remove from Injury Reserve");

        // Add action listeners
        addButton.addActionListener(e -> {
            String playerName = playerNameField.getText();
            String playerId = playerIdField.getText();
            Player player = new Player(playerId, playerName);
            addToContractExtensionQueue(player);
        });

        removeButton.addActionListener(e -> removeFromContractExtensionQueue());

        prioritizeButton.addActionListener(e -> prioritizePlayers());

        addToInjuryButton.addActionListener(e -> addUserInjuredPlayer());

        removeFromInjuryButton.addActionListener(e -> {
            Player removedPlayer = removeFromInjuryReserve();
            if (removedPlayer != null) {
                JOptionPane.showMessageDialog(this, "Player removed from injury reserve: " + removedPlayer.getFullName());
            }
        });

        // Create layout
        JPanel panel = new JPanel(new GridLayout(6, 2));
        panel.add(new JLabel("Player Name:"));
        panel.add(playerNameField);
        panel.add(new JLabel("Player ID:"));
        panel.add(playerIdField);
        panel.add(addButton);
        panel.add(removeButton);
        panel.add(prioritizeButton);
        panel.add(new JLabel("Injury Reason:"));
        panel.add(injuryReasonField);
        panel.add(addToInjuryButton);
        panel.add(removeFromInjuryButton);

        // Add panel to the frame
        add(panel);
        setVisible(true);
    }

    public void addToContractExtensionQueue(Player player) {
        players.add(player);
        JOptionPane.showMessageDialog(this, "Player added to contract extension queue");
    }

    public void removeFromContractExtensionQueue() {
        if (!players.isEmpty()) {
            Player removedPlayer = players.remove(0);
            JOptionPane.showMessageDialog(this, "Player removed from contract extension queue: " + removedPlayer.getFullName());
        } else {
            JOptionPane.showMessageDialog(this, "Contract Extension Queue is empty");
        }
    }

    public void prioritizePlayers() {
        // Prioritize players and display the list
        // Note: Database integration and player scoring calculation need to be implemented here
        // For now, we'll just print dummy data
        players.sort(Comparator.comparingDouble(Player::getScore).reversed());
        StringBuilder prioritizedPlayers = new StringBuilder("Prioritized Players:\n");
        for (Player player : players) {
            prioritizedPlayers.append(player.getFullName()).append(": ").append(player.getScore()).append("\n");
        }
        JOptionPane.showMessageDialog(this, prioritizedPlayers.toString());
    }

    public void addToInjuryReserve(Player player) {
        injuryReserve.add(player);
        JOptionPane.showMessageDialog(this, "Player added to injury reserve");
    }

    public Player removeFromInjuryReserve() {
        if (!injuryReserve.isEmpty()) {
            return injuryReserve.remove(0);
        } else {
            JOptionPane.showMessageDialog(this, "Injury Reserve is empty");
            return null;
        }
    }

    public void addUserInjuredPlayer() {
        String playerName = playerNameField.getText();
        String injuryReason = injuryReasonField.getText();
        Player player = new Player(playerName, injuryReason);
        addToInjuryReserve(player);
    }

    public static void main(String[] args) {
        new ContractExtensionQueueGUI();
    }
}
