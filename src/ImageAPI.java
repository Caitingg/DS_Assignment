//import com.google.gson.Gson;
//import org.jsoup.Jsoup;
//import org.jsoup.nodes.Document;
//import org.jsoup.nodes.Element;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.Calendar;
//
//public class ImageAPI {
//    private static final String API_KEY = "18b3bb72-3fba-4739-bcd5-602bc9278cf3"; // Replace with your API key
//    private static final int CURRENT_SEASON = getCurrentSeason();
//    private static final String BASE_URL = "https://api.balldontlie.io/v1/stats";
//    private static final String NBA_PLAYER_PROFILE_URL = "https://www.nba.com/player/";
//
//    private ArrayList<PlayerStats> playerStatsList = new ArrayList<>();
//
//    public ImageAPI() {
//        accessConnection();
//    }
//
//    private void accessConnection() {
//        try {
//            StringBuilder urlBuilder = new StringBuilder(BASE_URL);
//            urlBuilder.append("?per_page=100"); // Default per_page parameter
//
//            String apiUrl = urlBuilder.toString() + "&seasons[]=" + CURRENT_SEASON;
//
//            Document doc = Jsoup.connect(apiUrl)
//                    .header("Authorization", API_KEY)
//                    .ignoreContentType(true)
//                    .get();
//
//            parseJson(doc.text());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    private static int getCurrentSeason() {
//        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
//        return Calendar.getInstance().get(Calendar.MONTH) < 6 ? currentYear - 1 : currentYear;
//    }
//
//    private void parseJson(String json) {
//        Gson gson = new Gson();
//        ApiResponse response = gson.fromJson(json, ApiResponse.class);
//        if (response != null && response.data != null) {
//            playerStatsList.addAll(response.data);
//            fetchPlayerImages();
//        }
//    }
//
//    private void fetchPlayerImages() {
//        for (PlayerStats playerStats : playerStatsList) {
//            int playerId = playerStats.player.id;
//            String imageUrl = fetchPlayerImageFromNBA(playerId);
//            playerStats.player.imageUrl = imageUrl != null ? imageUrl : "default_image_url.png";
//        }
//    }
//
//    private String fetchPlayerImageFromNBA(int playerId) {
//        try {
//            Document playerDoc = Jsoup.connect(NBA_PLAYER_PROFILE_URL + playerId).get();
//            Element imgTag = playerDoc.selectFirst("img.player-image");
//            if (imgTag != null) {
//                return imgTag.attr("src");
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    public ArrayList<PlayerStats> getPlayerStatsList() {
//        return playerStatsList;
//    }
//}
//
//class PlayerStats {
//    int id;
//    String min;
//    int reb;
//    int ast;
//    int stl;
//    int blk;
//    int pts;
//    Player player;
//    Team team;
//    Game game;
//}
//
//class Player {
//    int id;
//    String first_name;
//    String last_name;
//    String position;
//    String height;
//    String weight;
//    int draft_year;
//    int draft_round;
//    int draft_number;
//    int team_id;
//    String imageUrl; // Add this field to store image URL
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
//class Game {
//    int id;
//    String date;
//    int season;
//    String status;
//    int period;
//    String time;
//    boolean postseason;
//}
//
//class ApiResponse {
//    ArrayList<PlayerStats> data;
//}
