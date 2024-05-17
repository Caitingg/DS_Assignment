//import java.io.BufferedReader;
//import java.io.FileReader;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Random;
//
//public class Main {
//    public static void main(String[] args) {
//        List<Player> playerList = readPlayerListFromCSV("PlayerStats.csv");
//        InjuryReserve injuryReserve = new InjuryReserve();
//        ContractExtensionQueue contractExtensionQueue = new ContractExtensionQueue();
//
//        // Add injured players from user input
//        injuryReserve.addUserInjuredPlayer();
//
//        // Randomly select players for contract extension queue
//        Random random = new Random();
//        int numPlayersToExtendContract = 3; // Adjust this number as needed
//        for (int i = 0; i < numPlayersToExtendContract; i++) {
//            int randomIndex = random.nextInt(playerList.size());
//            Player player = playerList.get(randomIndex);
//            contractExtensionQueue.addToContractExtensionQueue(player);
//        }
//
//        // Remove players from the injury reserve and contract extension queue
//        int numPlayersToRemove = 2; // Adjust this number as needed
//        for (int i = 0; i < numPlayersToRemove; i++) {
//            // Remove player from injury reserve
//            Player removedPlayerFromInjury = injuryReserve.removeFromInjuryReserve();
//            if (removedPlayerFromInjury != null) {
//                System.out.println("--Removing Player from Injury Reserve--");
//                System.out.println("Player: " + removedPlayerFromInjury.getFullName());
//                System.out.println("Status: Cleared to play\n");
//
//                // Move player to active roster
//                injuryReserve.moveToActiveRoster(removedPlayerFromInjury);
//            }
//
//            // Remove player from contract extension queue
//            Player removedPlayerFromContract = contractExtensionQueue.removeFromContractExtensionQueue();
//            if (removedPlayerFromContract != null) {
//                System.out.println("--Removing Player from Contract Extension Queue--");
//                System.out.println("Player: " + removedPlayerFromContract.getFullName());
//                System.out.println("Status: Contract Renewed\n");
//            }
//        }
//
//        // Prioritize players in contract extension queue
//        contractExtensionQueue.prioritizePlayers();
//    }
//
//    public static List<Player> readPlayerListFromCSV(String filename) {
//        List<Player> playerList = new ArrayList<>();
//        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
//            String line;
//            while ((line = br.readLine()) != null) {
//                String[] playerInfo = line.split(",");
//                String firstName = playerInfo[0];
//                String lastName = playerInfo[1];
//                Player player = new Player(firstName + " " + lastName, "");
//                playerList.add(player);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return playerList;
//    }
//
//}

