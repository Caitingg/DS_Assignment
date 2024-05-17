//import com.opencsv.CSVWriter;
//
//import java.io.FileWriter;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//
//
//public class test {
//    public static void main(String[] args) {
//        fetchAndDisplayPlayerStats();
//    }
//
//    private static void fetchAndDisplayPlayerStats() {
//        PlayerStatsList playerStatsList = new PlayerStatsList();
//        ArrayList<PlayerStats> playerStats = playerStatsList.getPlayerStatsList();
//
//        for (PlayerStats stats : playerStats) {
//            System.out.println("Player: " + stats.player.first_name + " " + stats.player.last_name);
//            System.out.println("Points: " + stats.pts);
//            System.out.println("Assists: " + stats.ast);
//            System.out.println("Rebounds: " + stats.reb);
//            System.out.println("Steals: " + stats.stl);
//            System.out.println("Blocks: " + stats.blk);
//            System.out.println("Team: " + stats.team.full_name);
//            System.out.println("Game Date: " + stats.game.date);
//            System.out.println("----------------------------------");
//        }
//
//        try {
//            writePlayerStatsToCSV(playerStats, "PlayerStats.csv");
//        } catch (IOException ex) {
//            Logger.getLogger(test.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//
//    private static void writePlayerStatsToCSV(ArrayList<PlayerStats> playerStats, String fileName) throws IOException {
//        try (CSVWriter writer = new CSVWriter(new FileWriter(fileName))) {
//            // Define the header
//            String[] header = {"ID", "Minutes", "Total Rebounds", "Assists", "Steals", "Blocks",  "Points",
//                    "Player ID", "First Name", "Last Name", "Position", "Height", "Weight", "Draft Year", "Draft Round", "Draft Number", "Team ID", "Team Conference",
//                    "Team Division", "Team City", "Team Name", "Team Full Name", "Team Abbreviation",
//                    "Game ID", "Game Date", "Game Season", "Game Status", "Game Period", "Game Time",
//                    "Game Postseason", "Home Team Score", "Visitor Team Score", "Home Team ID", "Visitor Team ID"};
//
//            writer.writeNext(header);
//
//            // Write player statistics
//            for (PlayerStats stats : playerStats) {
//                String[] data = {
//                        String.valueOf(stats.id),
//                        stats.min,
//                        String.valueOf(stats.reb),
//                        String.valueOf(stats.ast),
//                        String.valueOf(stats.stl),
//                        String.valueOf(stats.blk),
//                        String.valueOf(stats.pts),
//                        String.valueOf(stats.player.id),
//                        stats.player.first_name,
//                        stats.player.last_name,
//                        stats.player.position,
//                        stats.player.height,
//                        stats.player.weight,
//                        String.valueOf(stats.player.draft_year),
//                        String.valueOf(stats.player.draft_round),
//                        String.valueOf(stats.player.draft_number),
//                        String.valueOf(stats.team.id),
//                        stats.team.conference,
//                        stats.team.division,
//                        stats.team.city,
//                        stats.team.name,
//                        stats.team.full_name,
//                        stats.team.abbreviation,
//                        String.valueOf(stats.game.id),
//                        stats.game.date,
//                        String.valueOf(stats.game.season),
//                        stats.game.status,
//                        String.valueOf(stats.game.period),
//                        stats.game.time,
//                        String.valueOf(stats.game.postseason),
//                        String.valueOf(stats.game.home_team_score),
//                        String.valueOf(stats.game.visitor_team_score),
//                        String.valueOf(stats.game.home_team_id),
//                        String.valueOf(stats.game.visitor_team_id)
//                };
//                writer.writeNext(data);
//            }
//        }
//    }
//}
//
