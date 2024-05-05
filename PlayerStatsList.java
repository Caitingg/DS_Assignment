import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;

public class PlayerStatsList {
    private static final String API_KEY = "18cc7487-a230-4bb9-b945-7d0ca7327145";
    private static final int CURRENT_SEASON = getCurrentSeason();
    private static final String BASE_URL = "https://api.balldontlie.io/v1/stats";

    private ArrayList<PlayerStats> playerStatsList = new ArrayList<>();
    private ApiResponse response = new ApiResponse();
    private HttpURLConnection conn;
    private static final int RATE_LIMIT = 30; // Rate limit per minute
    private static final int RATE_LIMIT_WINDOW = 60000; // Rate limit window in milliseconds
    private static final int MAX_RETRIES = 250; // Maximum number of retry attempts

    private int requestCount = 0;
    private long lastRequestTime = System.currentTimeMillis();

    public PlayerStatsList() {
        accessConnection();
    }

    public void accessConnection() {
        int retryCount = 0;
        while (retryCount < MAX_RETRIES) {
            try {
                enforceRateLimit(); // Check rate limit and wait if necessary

                StringBuilder urlBuilder = new StringBuilder(BASE_URL);
                urlBuilder.append("?per_page=").append(response.meta != null ? response.meta.per_page : Integer.MAX_VALUE); // Set per_page parameter dynamically with a default of 25

                // Check if there is a next_cursor available
                if (response != null && response.meta != null && response.meta.next_cursor > 0) {
                    urlBuilder.append("&cursor=").append(response.meta.next_cursor);
                }
                // Construct the API URL with the current season query parameter
                String apiUrl = urlBuilder.toString() + "&seasons[]=" + CURRENT_SEASON;

                URL url = new URL(apiUrl);
                conn = (HttpURLConnection) url.openConnection();

                // Set request headers
                conn.setRequestMethod("GET");
                conn.setRequestProperty("Authorization", API_KEY);

                // Read the response
                if (conn.getResponseCode() != 200) {
                    throw new IOException("Failed to fetch data from API. Response code: " + conn.getResponseCode());
                }

                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));

                String inputLine;
                StringBuilder raw = new StringBuilder();
                while ((inputLine = in.readLine()) != null) {
                    raw.append(inputLine);
                }
                in.close();
                parseJson(raw.toString());

                // Check if there are more pages and fetch them
                if (response != null && response.meta != null && response.meta.next_cursor > 0) {
                    // Update the cursor for the next page
                    response.meta.next_cursor++;
                } else {
                    break; // No more pages, exit loop
                }
            } catch (IOException ex) {
                System.out.println("IO error: " + ex.getMessage());
                // Handle retries
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private static int getCurrentSeason() {
        // Get the current year
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);

        // Determine the NBA season based on the current month
        // If the current month is before July, it's part of the previous year's season
        // Otherwise, it's part of the current year's season
        int currentMonth = Calendar.getInstance().get(Calendar.MONTH) + 1; // Month is zero-based
        int season = (currentMonth < 7) ? currentYear - 1 : currentYear;

        return season;
    }


    public void parseJson(String s) {
        Gson gson = new Gson();
        this.response = gson.fromJson(s, ApiResponse.class);
        if (response != null && response.data != null) {
            for (PlayerStats stats : response.data) {
                PlayerStats simplifiedStats = new PlayerStats();
                simplifiedStats.player_id = stats.player.id; // Assign player_id here
                simplifiedStats.player = stats.player;
                simplifiedStats.pts = stats.pts;
                simplifiedStats.reb = stats.reb;
                simplifiedStats.ast = stats.ast;
                simplifiedStats.stl = stats.stl;
                simplifiedStats.blk = stats.blk;
                this.playerStatsList.add(simplifiedStats);
            }
        }
    }


    public ArrayList<PlayerStats> getPlayerStatsList() {
        return this.playerStatsList;
    }

    private synchronized void enforceRateLimit() throws InterruptedException {
        long currentTime = System.currentTimeMillis();
        long elapsedTime = currentTime - lastRequestTime;

        if (elapsedTime >= RATE_LIMIT_WINDOW) {
            // Reset request count if rate limit window has passed
            requestCount = 0;
            lastRequestTime = currentTime;
        }

        if (requestCount >= RATE_LIMIT) {
            // If rate limit reached, wait until the rate limit window resets
            long delay = RATE_LIMIT_WINDOW - elapsedTime;
            System.out.println("Waiting for " + delay + " milliseconds before retrying...");
            Thread.sleep(delay);
        }

        // Update request count and time
        requestCount++;
        lastRequestTime = System.currentTimeMillis();
    }
}

class PlayerStats {
    int id;
    int player_id;
    int pts;
    int reb;
    int ast;
    int stl;
    int blk;
    Player player;
}

class Player {
    int id;
    String first_name;
    String last_name;
    String position;
    String height;
    String weight;
}

class ApiResponse {
    ArrayList<PlayerStats> data;
    Meta meta;
}

class Meta {
    int next_cursor;
    int per_page;
}


