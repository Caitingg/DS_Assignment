import java.sql.*;
import java.util.Scanner;

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
    Node<Player> head;
    Node<Player> tail;
    int sumSalary;
    private static final int MAX_PLAYERS = 15;

    public Team(String teamName) {
        this.teamName = teamName;
    }

    // Method to add a player to the team
    public void addPlayer(Player player) {
        if (head == null) {
            head = new Node<>(player);
            size++;
        } else {
            Node<Player> temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = new Node<>(player);
            sumSalary+= player.getSalary();
            size++;
        }
    }

    // Method to remove a player from the team by player ID
    public void removePlayer(int playerId) {
        if (head == null) {
            return; // If the list is empty, nothing to remove
        }

        Node<Player> prev = null;
        Node<Player> current = head;

        // Traverse the list to find the player with the given ID
        while (current != null) {
            if (current.element.getId() == playerId) {
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
        System.out.println("Player with ID " + playerId + " not found in the team.");
    }

    // Method to check if the team is valid
    public boolean isValidTeam() {
        if (size < 10) return false;
        if (size > 15) return false;
        if (count("G") < 2 || count("F") < 2 || count("C") < 2) return false;
        if (sumSalary > 20000) return false;
        return true;
    }

    // Method to count players of a specific position
    public int count(String position) {
        int cnt = 0;
        Node<Player> temp = this.head;
        for (int i = 0; i < size; i++) {
            if (temp.element.getPosition().equals(position)) {
                cnt++;
            }
            temp = temp.next;
        }
        return cnt;
    }


    //save the team list to database and retrieve!!!!

    /*// Method to save the team to the database
    public void saveTeamToDatabase(int userId) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3308/test", "root", "")) {
            String teamSql = "INSERT INTO teams (team_name, user_id) VALUES (?, ?)";
            try (PreparedStatement teamStatement = connection.prepareStatement(teamSql, Statement.RETURN_GENERATED_KEYS)) {
                teamStatement.setString(1, teamName);
                teamStatement.setInt(2, userId);
                teamStatement.executeUpdate();

                try (ResultSet generatedKeys = teamStatement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        int teamId = generatedKeys.getInt(1);

                        String playerSql = "INSERT INTO team_players (team_id, player_id) VALUES (?, ?)";
                        try (PreparedStatement playerStatement = connection.prepareStatement(playerSql)) {
                            Node<Player> current = head;
                            while (current != null) {
                                playerStatement.setInt(1, teamId);
                                playerStatement.setInt(2, current.element.getId());
                                playerStatement.executeUpdate();
                                current = current.next;
                            }
                        }
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }*/

   /* // Method to retrieve a user's teams from the database
    public static List<Team> getTeamsByUserId(int userId) {
        List<Team> teams = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3308/test", "root", "")) {
            String teamSql = "SELECT * FROM teams WHERE user_id = ?";
            try (PreparedStatement teamStatement = connection.prepareStatement(teamSql)) {
                teamStatement.setInt(1, userId);
                try (ResultSet teamResultSet = teamStatement.executeQuery()) {
                    while (teamResultSet.next()) {
                        int teamId = teamResultSet.getInt("team_id");
                        String teamName = teamResultSet.getString("team_name");
                        Team team = new Team(teamName);

                        String playerSql = "SELECT p.* FROM players p INNER JOIN team_players tp ON p.player_id = tp.player_id WHERE tp.team_id = ?";
                        try (PreparedStatement playerStatement = connection.prepareStatement(playerSql)) {
                            playerStatement.setInt(1, teamId);
                            try (ResultSet playerResultSet = playerStatement.executeQuery()) {
                                while (playerResultSet.next()) {
                                    Player player = new Player();
                                    player.setId(playerResultSet.getInt("player_id"));
                                    player.setName(playerResultSet.getString("name"));
                                    player.setHeight(playerResultSet.getDouble("height"));
                                    player.setWeight(playerResultSet.getDouble("weight"));
                                    player.setPosition(playerResultSet.getString("position"));
                                    player.setSalary(playerResultSet.getInt("salary"));
                                    player.setPoints(playerResultSet.getInt("points"));
                                    player.setRebounds(playerResultSet.getInt("rebounds"));
                                    player.setAssists(playerResultSet.getInt("assists"));
                                    player.setSteals(playerResultSet.getInt("steals"));
                                    player.setBlocks(playerResultSet.getInt("blocks"));

                                    team.addPlayer(player);
                                }
                            }
                        }
                        teams.add(team);
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return teams;
    }
*/



    @Override
    public String toString() {
        if (head == null) {
            return "No players in the team.";
        }

        StringBuilder result = new StringBuilder();
        Node<Player> temp = head;
        int cnt = 1;

        while (temp != null) {
            result.append("Player ").append(cnt++).append(":\n");
            result.append(temp.element.toString()).append("\n");
            temp = temp.next;
        }

        return result.toString();
    }

    /*// Method to form a team
    public void formTeam(int userId) {
        Team newTeam = new Team(teamName);
        Scanner sc = new Scanner(System.in);
        int option = -1;

        while (option != 0 && newTeam.size < 15 && sumSalary <= 20000) {
            System.out.println("List of players: ");
            displayPlayer();
            System.out.println("\n\nOptions:");
            System.out.println("1. Add player");
            System.out.println("2. Remove player");
            System.out.println("3. Show list of added players");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");
            option = sc.nextInt();

            switch (option) {
                case 1:
                    System.out.print("Enter player ID to add to the team: ");
                    int idToAdd = sc.nextInt();
                    // Check if the player with the given ID is already in the team
                    boolean playerExists = false;
                    Node<Player> temp = newTeam.head;
                    while (temp != null) {
                        if (temp.element.getId() == idToAdd) {
                            playerExists = true;
                            break;
                        }
                        temp = temp.next;
                    }
                    if (playerExists) {
                        System.out.println("This player is already in the team.");
                    } else {
                        // Check if adding this player would exceed the salary cap
                        try (Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3308/test", "root", "");
                             PreparedStatement preparedStatement = connection.prepareStatement("SELECT salary FROM players WHERE player_id = ?")) {
                            preparedStatement.setInt(1, idToAdd);
                            try (ResultSet playerResultSet = preparedStatement.executeQuery()) {
                                if (playerResultSet.next()) {
                                    int playerSalary = playerResultSet.getInt("salary");
                                    if (sumSalary + playerSalary <= 20000) {
                                        newTeam.selectAndAddPlayerFromDatabase(idToAdd);
                                        if (!newTeam.isValidTeam()) {
                                            // If adding this player invalidates the team, remove them
                                            newTeam.removePlayer(idToAdd);
                                            System.out.println("Adding this player would make the team invalid. Player removed.");
                                        }
                                    } else {
                                        System.out.println("Adding this player would exceed the salary cap.");
                                    }
                                } else {
                                    System.out.println("Player not found.");
                                }
                            }
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                    break;
                case 2:
                    System.out.println("List of added players:");
                    System.out.println(newTeam.toString());
                    System.out.print("Enter player ID to remove from the team: ");
                    int idToRemove = sc.nextInt();
                    // Check if the player with the given ID is in the team and remove if found
                    Node<Player> prev = null;
                    Node<Player> current = newTeam.head;
                    boolean removed = false;
                    while (current != null) {
                        if (current.element.getId() == idToRemove) {
                            // Adjust the sum of salaries
                            newTeam.sumSalary -= current.element.getSalary();
                            // Remove the player from the team
                            if (prev == null) {
                                newTeam.head = current.next;
                            } else {
                                prev.next = current.next;
                            }
                            newTeam.size--;
                            removed = true;
                            break;
                        }
                        prev = current;
                        current = current.next;
                    }
                    if (!removed) {
                        System.out.println("Player not found in the team.");
                    } else {
                        System.out.println("Player removed from the team.");
                    }
                    break;
                case 3:
                    // Display the list of added players
                    System.out.println("List of added players:");
                    System.out.println(newTeam.toString());
                    break;
                case 0:
                    // Exit the loop
                    break;
                default:
                    System.out.println("Invalid option. Please choose again.");
                    break;
            }
        }
    }
*/

    public void formTeam(int userId) {
        Scanner sc = new Scanner(System.in);
        int option;
        System.out.println("List of players: ");
        displayPlayer();
        while (size < 15 && sumSalary <= 20000) {
            System.out.println("\n\nOptions:");
            System.out.println("1. Add player");
            System.out.println("2. Remove player");
            System.out.println("3. Show list of added players");
            System.out.println("4. Form the team");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");
            option = sc.nextInt();

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
                case 4:
                     if(isValidTeam()){return;}
                     else{
                         System.out.println(this.toString());
                         System.out.println("\nPlease review your team, \ni.your team must be 10-15 players\nii.you need at least 2 guards, 2 forward and 2 centers in your teams\nii.Total salary of player must not exceed 20000");
                     }
                     break;
                case 0:
                    return; // Exit the method

                default:
                    System.out.println("Invalid option. Please choose again.");
                    break;
            }
        }
    }


    private void addPlayerToTeam(Scanner sc) {
        System.out.print("Enter player ID to add to the team: ");
        int idToAdd = sc.nextInt();
        if (playerExists(idToAdd)) {
            System.out.println("This player is already in the team.");
            return;
        }
        Player player = getPlayerFromDatabase(idToAdd);
        if (player == null) {
            System.out.println("Player not found.");
            return;
        }
        if (sumSalary + player.getSalary() > 20000) {
            System.out.println("Adding this player would exceed the salary cap.");
            return;
        }
        addPlayer(player);
    }

    private void removePlayerFromTeam(Scanner sc) {
        System.out.println("List of added players:");
        System.out.println(this.toString()); // Use 'this' to refer to the current instance of the Team class
        System.out.print("Enter player ID to remove from the team: ");
        int idToRemove = sc.nextInt();
        if (!playerExists(idToRemove)) {
            System.out.println("Player not found in the team.");
            return;
        }
        removePlayer(idToRemove);
        System.out.println("Player removed from the team.");
    }


    public boolean playerExists(int id) {
        Node<Player> temp = head;
        while (temp != null) {
            if (temp.element.getId() == id) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }


    private Player getPlayerFromDatabase(int playerId) {
        // Retrieve player details from the database
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3308/test", "root", "");
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM players WHERE id = ?")) {
            preparedStatement.setInt(1, playerId);
            try (ResultSet playerResultSet = preparedStatement.executeQuery()) {
                if (playerResultSet.next()) {
                    Player player = new Player();
                    player.setId(playerResultSet.getInt("id"));
                    player.setPlayer_id(playerResultSet.getInt("player_id"));
                    player.setName(playerResultSet.getString("name"));
                    player.setHeight(playerResultSet.getDouble("height"));
                    player.setWeight(playerResultSet.getDouble("weight"));
                    player.setPosition(playerResultSet.getString("position"));
                    player.setSalary(playerResultSet.getInt("salary"));
                    player.setPoints(playerResultSet.getInt("points"));
                    player.setRebounds(playerResultSet.getInt("rebounds"));
                    player.setAssists(playerResultSet.getInt("assists"));
                    player.setSteals(playerResultSet.getInt("steals"));
                    player.setBlocks(playerResultSet.getInt("blocks"));
                    return player;
                }
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return null;
    }


    private void displayPlayer() {
        // Retrieve player details from the database
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3308/test","root","");
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT id,player_id, name, weight, height, position, points, salary FROM players")) {

            // Display player details in a table
            System.out.printf("%-6s%-12s%-27s%-10s%-10s%-15s%-10s%-10s\n", "ID","Player ID", "Name", "Weight", "Height", "Position", "Points", "Salary");
            while (resultSet.next()) {
                int Id = resultSet.getInt("id");
                int playerId = resultSet.getInt("player_id");
                String playerName = resultSet.getString("name");
                double playerWeight = resultSet.getDouble("weight");
                double playerHeight = resultSet.getDouble("height");
                String playerPosition = resultSet.getString("position");
                int playerPoints = resultSet.getInt("points");
                int playerSalary = resultSet.getInt("salary");
                System.out.printf("%-6s%-12d%-27s%-10.2f%-10.2f%-15s%-10d%-10d\n", Id,playerId, playerName, playerWeight, playerHeight, playerPosition, playerPoints, playerSalary);
            }
        } catch (SQLException e) {
            System.err.println("SQL Exception: " + e.getMessage());
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }


        public static void main(String[] args) {
            // Create a new team
            Team team = new Team("MyTeam");

            // Form the team
            team.formTeam(1); // Assuming userId is 1

            // Display the final team
            System.out.println("Final Team:");
            System.out.println(team.toString());

        }
}


