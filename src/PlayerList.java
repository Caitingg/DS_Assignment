//import com.google.gson.Gson;
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.net.HttpURLConnection;
//import java.net.URL;
//import java.util.ArrayList;
//
//public class PlayerList {
//    private ArrayList<Player> players = new ArrayList<>();
//    private ApiResponse response = new ApiResponse();
//    private HttpURLConnection conn;
//    private static final String BASE_URL = "https://api.balldontlie.io/v1/players";
//    private static final String API_KEY = "18b3bb72-3fba-4739-bcd5-602bc9278cf3"; // Replace with your API key
//    private static final int RATE_LIMIT = 30; // Rate limit per minute
//    private static final int RATE_LIMIT_WINDOW = 60000; // Rate limit window in milliseconds
//    private static final int MAX_RETRIES = 250; // Maximum number of retry attempts
//
//    private int requestCount = 0;
//    private long lastRequestTime = System.currentTimeMillis();
//
//    public PlayerList() {
//        accessConnection();
//    }
//
//    public void accessConnection() {
//        int retryCount = 0;
//        while (retryCount < MAX_RETRIES) {
//            try {
//                // Make API request
//                // Check rate limit and wait if necessary
//                enforceRateLimit();
//
//                StringBuilder urlBuilder = new StringBuilder(BASE_URL);
//                urlBuilder.append("?per_page=").append(response.meta != null ? response.meta.per_page : 25); // Set per_page parameter dynamically with a default of 25
//
//                // Check if there is a next_cursor available
//                if (response != null && response.meta != null && response.meta.next_cursor > 0) {
//                    urlBuilder.append("&cursor=").append(response.meta.next_cursor);
//                }
//
//                URL url = new URL(urlBuilder.toString());
//                conn = (HttpURLConnection) url.openConnection();
//
//                conn.setRequestMethod("GET");
//                conn.setRequestProperty("Authorization", API_KEY);
//
//                if (conn.getResponseCode() != 200) {
//                    throw new IOException("Failed to fetch data from API. Response code: " + conn.getResponseCode());
//                }
//
//                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
//
//                String inputLine;
//                StringBuilder raw = new StringBuilder();
//                while ((inputLine = in.readLine()) != null) {
//                    raw.append(inputLine);
//                }
//                in.close();
//                parseJson(raw.toString());
//
//                // Check if there are more pages and fetch them
//                if (response != null && response.meta != null && response.meta.next_cursor > 0) {
//                    // Update the cursor for the next page
//                    response.meta.next_cursor++;
//                } else {
//                    break; // No more pages, exit loop
//                }
//            } catch (IOException ex) {
//                System.out.println("IO error: " + ex.getMessage());
//                if (retryCount < MAX_RETRIES - 1) {
//                    // Exponential backoff before retrying
//                    long delay = RATE_LIMIT_WINDOW;
//                    System.out.println("Waiting for " + delay + " milliseconds before retrying...");
//                    try {
//                        Thread.sleep(delay);
//                    } catch (InterruptedException e) {
//                        System.out.println("Retry delay interrupted");
//                    }
//                    retryCount++;
//                } else {
//                    System.out.println("Maximum number of retries exceeded. Unable to fetch data.");
//                    break;
//                }
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        }
//    }
//
//    public void parseJson(String s) {
//        Gson gson = new Gson();
//        this.response = gson.fromJson(s, ApiResponse.class);
//        if (response != null && response.data != null) {
//            this.players.addAll(response.data);
//        }
//    }
//
//    public ArrayList<Player> getPlayerList() {
//        return this.players;
//    }
//
//    private synchronized void enforceRateLimit() throws InterruptedException {
//        long currentTime = System.currentTimeMillis();
//        long elapsedTime = currentTime - lastRequestTime;
//
//        if (elapsedTime >= RATE_LIMIT_WINDOW) {
//            // Reset request count if rate limit window has passed
//            requestCount = 0;
//            lastRequestTime = currentTime;
//        }
//
//        if (requestCount >= RATE_LIMIT) {
//            // If rate limit reached, wait until the rate limit window resets
//            long delay = RATE_LIMIT_WINDOW - elapsedTime;
//            System.out.println("Waiting for " + delay + " milliseconds before retrying...");
//            Thread.sleep(delay);
//        }
//
//        // Update request count and time
//        requestCount++;
//        lastRequestTime = System.currentTimeMillis();
//    }
//}
//
//class Player {
//    int id;
//    String first_name;
//    String last_name;
//    String position;
//    String height;
//    String weight;
//    String jersey_number;
//    String college;
//    String country;
//    int draft_year;
//    int draft_round;
//    int draft_number;
//    Team team;
//
//    public String[] toArray() {
//        String[] array = {
//                String.valueOf(id),
//                first_name,
//                last_name,
//                position,
//                height,
//                weight,
//                jersey_number,
//                college,
//                country,
//                String.valueOf(draft_year),
//                String.valueOf(draft_round),
//                String.valueOf(draft_number),
//                String.valueOf(team.id),
//                team.conference,
//                team.division,
//                team.city,
//                team.name,
//                team.full_name,
//                team.abbreviation
//        };
//        return array;
//    }
//}
//
//class Team {
//    int id;
//    String conference;
//    String division;
//    String city;
//    String name;
//    String full_name;
//    String abbreviation;
//}
//
//class Meta {
//    int next_cursor;
//    int per_page;
//}
//
//class ApiResponse {
//    ArrayList<Player> data;
//    Meta meta;
//}


//import com.opencsv.CSVWriter;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//
//public class test {
//    public static void main(String[] args) {
//        PlayerStatsList playerStatsList = new PlayerStatsList();
//        ArrayList<PlayerStats> players = playerStatsList.getPlayerStatsList();
//        for (PlayerStats p : players) {
//           System.out.println("Player: " + stats.player.first_name + " " + stats.player.last_name);
//                System.out.println("Points: " + stats.pts);
//                System.out.println("Assists: " + stats.ast);
//                System.out.println("Rebounds: " + stats.reb);
//                System.out.println("Steals: " + stats.stl);
//                System.out.println("Blocks: " + stats.blk);
//                System.out.println("Team: " + stats.team.full_name);
//                System.out.println("Game Date: " + stats.game.date);
//                System.out.println("----------------------------------");
//        }
//
//        try {
//            writePlayersToCSV(players, "PlayerStats.csv");
//        } catch (IOException ex) {
//            Logger.getLogger(test.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//    }
//
//    private static void writePlayersToCSV(ArrayList<Player> players, String fileName) throws IOException {
//        CSVWriter writer = new CSVWriter(new FileWriter(fileName));
//        String[] array = {
//                String.valueOf(id),
//                min,
//                String.valueOf(fgm),
//                String.valueOf(fga),
//                String.valueOf(fg_pct),
//                String.valueOf(fg3m),
//                String.valueOf(fg3a),
//                String.valueOf(fg3_pct),
//                String.valueOf(ftm),
//                String.valueOf(fta),
//                String.valueOf(ft_pct),
//                String.valueOf(oreb),
//                String.valueOf(dreb),
//                String.valueOf(reb),
//                String.valueOf(ast),
//                String.valueOf(stl),
//                String.valueOf(blk),
//                String.valueOf(turnover),
//                String.valueOf(pf),
//                String.valueOf(pts),
//                String.valueOf(player.id),
//                player.first_name,
//                player.last_name,
//                player.position,
//                player.height,
//                player.weight,
//                player.jersey_number,
//                player.college,
//                player.country,
//                String.valueOf(player.draft_year),
//                String.valueOf(player.draft_round),
//                String.valueOf(player.draft_number),
//                String.valueOf(player.team_id),
//                String.valueOf(team.id),
//                team.conference,
//                team.division,
//                team.city,
//                team.name,
//                team.full_name,
//                team.abbreviation,
//                String.valueOf(game.id),
//                game.date,
//                String.valueOf(game.season),
//                game.status,
//                String.valueOf(game.period),
//                game.time,
//                String.valueOf(game.postseason),
//                String.valueOf(game.home_team_score),
//                String.valueOf(game.visitor_team_score),
//                String.valueOf(game.home_team_id),
//                String.valueOf(game.visitor_team_id)
//        };
//        writer.writeNext(header);
//        for (PlayerStats p : players) {
//            writer.writeNext(p.toArray());
//        }
//        writer.close();
//    }
//}