/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Team;

/**
 *
 * @author user
 */
import java.sql.*;
import database.PLayer;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import model.Model_MemberProfile;

public class Team {

    public class Node<E> {
        Node<E> next;
        Node<E> previous;
        E element;

        public Node(E e) {
            this.element = e;
        }
    }

    String teamName;
    int size;
    Node<PLayer> head;
    Node<PLayer> tail;
    int sumSalary;
    private static final int MAX_PLAYERS = 15;
    String url="jdbc:mysql://127.0.0.1:3308/java_user_database";
    String user="root";
    String password="";
    
    
    public Team() {
        
    }
    
    public Team(String teamName) {
        this.teamName = teamName;
    }
    
    public List<Model_MemberProfile> generateMemberProfile(String username){
        List<Model_MemberProfile> profile = new ArrayList<>();
        this.retrieveTeamPlayerFromDB(username);
        Node<PLayer>temp=head;
        while(temp!=null){
            profile.add(new Model_MemberProfile(temp.element.getPlayer_id(),temp.element.getPlayer_Name(),temp.element.getPosition(),temp.element.getStatus()));
        }
        return profile;
    }
    
    public int getSalary(){
        return sumSalary;
    }
    
    public int getSize(){
        return size;
    }
    // Method to add a player to the team
    public void addPlayer(PLayer player) {
        if (head == null) {
            head = new Node<>(player);
            sumSalary+= player.getSalary();
            size++;
        } else {
            Node<PLayer> temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = new Node<PLayer>(player);
            sumSalary+= player.getSalary();
            size++;
        }
    }

    // Method to remove a player from the team by player ID
    public void removePlayer(int playerId) {
        if (head == null) {
            return; // If the list is empty, nothing to remove
        }

        Node<PLayer> prev = null;
        Node<PLayer> current = head;

        // Traverse the list to find the player with the given ID
        while (current != null) {
            if (current.element.getPlayer_id() == playerId) {
                // Adjust the sum of salaries
                sumSalary -= current.element.getSalary();
                // Remove the player from the team
                if (prev == null) {
                    head = current.next; // If the player is the head node
                } else {
                    prev.next = current.next;
                }
                size--;
                return; // Exit the method after removing the player
            }
            prev = current;
            current = current.next;
        }

        // If the player with the given ID is not found
        String message = "Player with ID " + playerId + " not found in the team.";
        JOptionPane.showMessageDialog(new JFrame(), message, "Dialog", JOptionPane.ERROR_MESSAGE);
          
    }

    // Check if the team is valid
    public boolean isValidTeam() {
        if (size < 10) return false;
        if (size > 15) return false;
        if (count("G") < 2 || count("F") < 2 || count("C") < 2) return false;
        if (sumSalary > 20000) return false;
        return true;
    }

    //count players of a specific position
    public int count(String position) {
        int cnt = 0;
        Node<PLayer> temp = this.head;
        for (int i = 0; i < size; i++) {
            if (temp.element.getPosition().contains(position)) {
                cnt++;
            }
            temp = temp.next;
        }
        return cnt;
    }



    @Override
    public String toString() {
        if (head == null) {
            String message = "No players in the team.";
            JOptionPane.showMessageDialog(new JFrame(), message, "Dialog", JOptionPane.ERROR_MESSAGE);
          
            return "No players in the team.";
        }

        StringBuilder result = new StringBuilder();
        Node<PLayer> temp = head;
        int cnt = 1;

        while (temp != null) {
            result.append("Player ").append(cnt++).append(":\n");
            result.append(temp.element.toString()).append("\n");
            temp = temp.next;
        }

        return result.toString();
    }



    //Form team (either add or remove player)
    public void formTeam(int option,int sc) {
//        System.out.println("List of players: ");
//        displayPlayer();
        
//            System.out.println("\n\nOptions:");
//            System.out.println("1. Add player");
//            System.out.println("2. Remove player");
//            System.out.println("3. Show list of added players");
//            System.out.println("4. Form the team");
//            System.out.println("0. Exit");
//            System.out.print("Choose an option: ");

            switch (option) {
                case 1:
                    addPlayerToTeam(sc);
                    break;
                case 2:
                    removePlayerFromTeam(sc);
                    break;
                case 3:
                    System.out.println("List of added players:");
                    System.out.println(this.toString()); // Use 'this' to refer to the current instance of the Team class
                    break;
                
                default:
                    //System.out.println("Invalid option. Please choose again.");
                    break;
            }
        
    }

    //add player
    private void addPlayerToTeam(int idToAdd) {
        if (playerExists(idToAdd)) {
            String message = "This player is already in the team.";
            JOptionPane.showMessageDialog(new JFrame(), message, "Dialog", JOptionPane.ERROR_MESSAGE);
          
            return;
        }
        PLayer player = getPlayerFromDatabase(idToAdd);
        if (player == null) {
            String message = "Player not found.";
            JOptionPane.showMessageDialog(new JFrame(), message, "Dialog", JOptionPane.ERROR_MESSAGE);
          
            return;
        }
        if (sumSalary + player.getSalary() > 20000) {
            String message = "Adding this player would exceed the salary cap.";
            JOptionPane.showMessageDialog(new JFrame(), message, "Dialog", JOptionPane.ERROR_MESSAGE);
          
            return;
        }
        if(size>15){
            String message="Exceed maximum number of player in a team";
            JOptionPane.showMessageDialog(new JFrame(), message, "Dialog", JOptionPane.ERROR_MESSAGE);
          
        }
        addPlayer(player);
    }

    //remove player from team
    private void removePlayerFromTeam(int idToRemove) {
        System.out.println("List of added players:");
        System.out.println(this.toString()); // Use 'this' to refer to the current instance of the Team class
        if (!playerExists(idToRemove)) {
            String message = "Player not found in the team.";
            JOptionPane.showMessageDialog(new JFrame(), message, "Dialog", JOptionPane.ERROR_MESSAGE);
            
            return;
        }
        removePlayer(idToRemove);
        String message = "Player removed from the team.";
        JOptionPane.showMessageDialog(new JFrame(), message, "Dialog", JOptionPane.INFORMATION_MESSAGE);
            
    }


    //check if the player in the database
    public boolean playerExists(int id) {
        Node<PLayer> temp = head;
        while (temp != null) {
            if (temp.element.getPlayer_id() == id) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }
    
    
   public void saveTeam(Team team, String userId) {
    Node<PLayer> temp = team.head; // Assuming head is the head of your player list
    String sql = "INSERT INTO teamplayer (Player_ID, Player_Name, Start_Date, End_Date, Status, User_ID, Position,Injury_Reserved) " +
                 "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

    try (Connection conn = DriverManager.getConnection(url, user, password);
         PreparedStatement st = conn.prepareStatement(sql)) {

        conn.setAutoCommit(false); // Disable auto-commit

        while (temp != null) {
            PLayer player = temp.element;
            int playerId = player.getPlayer_id();
            String playerName = player.getPlayer_Name();
            String position = player.getPosition();
            String status = "Bond";
            Date startDate = new Date(System.currentTimeMillis());
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(startDate);
            calendar.add(Calendar.DAY_OF_MONTH, 10);
            Date endDate = new Date(calendar.getTimeInMillis());

            st.setInt(1, playerId);
            st.setString(2, playerName);
            st.setDate(3, startDate);
            st.setDate(4, endDate);
            st.setString(5, status);
            st.setString(6, userId); // User ID
            st.setString(7, position);
            st.setBoolean(8,false);
           

            st.addBatch(); // Add the statement to the batch
            temp = temp.next; // Move to the next player
        }

        // Execute the batch insert
        int[] batchResult = st.executeBatch();

        // Commit the transaction
        conn.commit();
        
        // Print success message
        System.out.println("Team saved to database successfully!");

    } catch (SQLException e) {
        e.printStackTrace();
        System.out.println("An error occurred while saving the team to the database.");
    }
}
    
    
    //Save new player into players table
    public void savePlayerToInfo(int id, String name, double height,double weight,String position,int salary,int points,int rebound,int assists, int steal,int block,String status){
        String sql="INSERT INTO agentmarket (Player_ID,Player_Name,Height,Weight,Position,Salary,Points,TotalRebounds,Assists,Steals,Blocks,status)"+"VALUES ((?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)";
        
        try(Connection conn=DriverManager.getConnection(url,user,password);
            PreparedStatement st=conn.prepareStatement(sql)){
            
            st.setInt(1, id);
            st.setString(2, name);
            st.setDouble(3, height);
            st.setDouble(4, weight);
            st.setString(5, position);
            st.setInt(6, salary);
            st.setInt(7, points);
            st.setInt(8, rebound);
            st.setInt(9, assists);
            st.setInt(10, steal);
            st.setInt(11, block);
            st.setString(12, status);
            
            st.executeUpdate();
            String mss="Player information updated";
            JOptionPane.showMessageDialog(new JFrame(), mss, "Dialog", JOptionPane.INFORMATION_MESSAGE);
          
        }catch(SQLException e){
            e.printStackTrace();
        }
        
    }
    
    public void updatePlayerInfo(int id, String name,double weight,double height, String position, int salary,int points, int rebound,int assist, int steals,int block,String status){
        String sql = "UPDATE agentmarket SET Weight=?,Height=?,Position=?,Salary=?,Points=?,TotalRebounts=?,Assists=?,Steals=?,Blocks=?,Status=? WHERE Player_ID = ? AND Player_Name=?_";
        
        try(Connection conn=DriverManager.getConnection(url,user,password);
            PreparedStatement pst=conn.prepareStatement(sql)){
            
            pst.setDouble(1, weight);
        pst.setDouble(2, height);
        pst.setString(3, position);
        pst.setInt(4, salary);
        pst.setInt(5, points);
        pst.setInt(6, rebound);
        pst.setInt(7, assist);
        pst.setInt(8, steals);
        pst.setInt(9, block);
        pst.setString(10, status);
        pst.setInt(11, id);
        pst.setString(12, name);
            
        
        int rowsAffected=pst.executeUpdate();
        
        if (rowsAffected > 0) {
            System.out.println("Player info updated successfully.");
        } else {
            System.out.println("No player found with the given ID and name.");
        }
        
        }catch(SQLException e){
            e.printStackTrace();;
        }
        
    
    }


    //Create a player object using player id
    private PLayer getPlayerFromDatabase(int playerId) {
        // Retrieve player details from the database
        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM agentmarket WHERE PLayer_ID = ?")) {
            preparedStatement.setInt(1, playerId);
            try (ResultSet playerResultSet = preparedStatement.executeQuery()) {
                if (playerResultSet.next()) {
                    PLayer player = new PLayer();
                    player.setPlayer_id(playerResultSet.getInt("PLayer_ID"));
                    player.setPlayer_Name(playerResultSet.getString("Player_Name"));
                    player.setHeight(playerResultSet.getDouble("Height"));
                    player.setWeight(playerResultSet.getDouble("Weight"));
                    player.setPosition(playerResultSet.getString("Position"));
                    player.setSalary(playerResultSet.getInt("Salary"));
                    player.setPoints(playerResultSet.getInt("Points"));
                    player.setRebounds(playerResultSet.getInt("TotalRebounts"));
                    player.setAssists(playerResultSet.getInt("Assists"));
                    player.setSteals(playerResultSet.getInt("Steals"));
                    player.setBlocks(playerResultSet.getInt("Blocks"));
                    return player;
                }
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return null;
    }
    
    //Get User team
  public void retrieveTeamPlayerFromDB(String userId) {
    try (Connection conn = DriverManager.getConnection(url, user, password)) {
        if (conn != null) {
            // Prepare the statement for querying the teams table with the user ID
            String queryTeams = "SELECT Player_ID, Player_Name FROM teamplayer WHERE User_ID = ?";
            PreparedStatement pstTeams = conn.prepareStatement(queryTeams);
            pstTeams.setString(1, userId);
            ResultSet rsTeams = pstTeams.executeQuery();

            // Prepare the statement for querying the players table
            String queryPlayers = "SELECT * FROM agentmarket WHERE Player_ID = ? AND Player_Name = ?";
            PreparedStatement pstPlayers = conn.prepareStatement(queryPlayers);

            // Process the result set from the teams table
            while (rsTeams.next()) {
                int player_id = rsTeams.getInt("Player_ID");
                String playerName = rsTeams.getString("Player_Name");

                System.out.println("Retrieved from teams: Player_ID=" + player_id + ", Player_Name=" + playerName);

                // Set parameters for the players query
                pstPlayers.setInt(1, player_id);
                pstPlayers.setString(2, playerName);
                ResultSet rsPlayers = pstPlayers.executeQuery();

                // Check if the players query returns any result
                if (!rsPlayers.isBeforeFirst()) {
                    System.out.println("No player found with Player_ID=" + player_id + " and Player_Name=" + playerName);
                }

                // Process the result set from the players table
                while (rsPlayers.next()) {
                    double height = rsPlayers.getDouble("Height");
                    double weight = rsPlayers.getDouble("Weight");
                    String position = rsPlayers.getString("Position");
                    int salary = rsPlayers.getInt("Salary");
                    int points = rsPlayers.getInt("Points");
                    int totalRebounds = rsPlayers.getInt("TotalRebounts");
                    int assists = rsPlayers.getInt("Assists");
                    int steals = rsPlayers.getInt("Steals");
                    int blocks = rsPlayers.getInt("Blocks");
                    String status=rsPlayers.getString("Status");

                    // Create a Player instance and add it to the list
                    PLayer play = new PLayer(player_id, playerName, height, weight, position, salary, points, totalRebounds, assists, steals, blocks,status);
                    this.addPlayer(play);
                }
            }

        }
    } catch (SQLException e) {
        e.printStackTrace();
        System.out.println("An error occurred while fetching the team players from the database.");
    }
}
  
  public boolean isBond(PLayer player){
      
      if(player.getStatus().equalsIgnoreCase("Bond")){
          return true;
          
      }
      
      return false;
  }



    //Display All Player
    private void displayAllPlayerFromDB() {
        
        // Retrieve player details from the database
        try (Connection connection = DriverManager.getConnection(url,user,password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT PLayer_ID, Player_Name, Weight, Height, Position, Points, Salary FROM teamplayer")) {

            // Display player details in a table
            System.out.printf("%-12s%-27s%-10s%-10s%-15s%-10s%-10s\n", "Player ID", "Name", "Weight", "Height", "Position", "Points", "Salary");
            while (resultSet.next()) {
                int playerId = resultSet.getInt("PLayer_ID");
                String playerName = resultSet.getString("Player_Name");
                double playerWeight = resultSet.getDouble("Weight");
                double playerHeight = resultSet.getDouble("Height");
                String playerPosition = resultSet.getString("Position");
                int playerPoints = resultSet.getInt("Points");
                int playerSalary = resultSet.getInt("Salary");
                System.out.printf("%-12d%-27s%-10.2f%-10.2f%-15s%-10d%-10d\n", playerId, playerName, playerWeight, playerHeight, playerPosition, playerPoints, playerSalary);
            }
        } catch (SQLException e) {
            System.err.println("SQL Exception: " + e.getMessage());
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

//        public static void main(String[] args) {
//            // Create a new team
//            Team team = new Team("MyTeam");
//
//            // Form the team
//            team.formTeam(1); // Assuming userId is 1
//
//            // Display the final team
//            System.out.println("Final Team:");
//            System.out.println(team.toString());
//
//        }
    
}
