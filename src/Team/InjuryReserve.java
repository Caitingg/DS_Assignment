package Team;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InjuryReserve {
    private List<TeamPlayer> injuredPlayers = new ArrayList<>();
    //private List<TeamPlayer> injuryReserve = new ArrayList<>();
    // private List<Player> contractExtensionQueue = new ArrayList<>();
    private Connection connection=null;
    private String userName;

    public InjuryReserve(String username){
        try {
            this.userName=username;
            connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/nba?useSSL=false","root","");
            String sql="SELECT Player_ID,Player_Name,Reason FROM injuryplayer WHERE User_ID='"+userName+"'";
            Statement st=connection.createStatement();
            ResultSet rs=st.executeQuery(sql);
            while (rs.next()) {
                int id=rs.getInt("Player_ID");
                String name=rs.getString("Player_Name");
                String reason=rs.getString("Reason");
                injuredPlayers.add(new TeamPlayer(name,id,reason));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public boolean addToInjuryReserve(int id,String reason) {
        for(TeamPlayer p:injuredPlayers){
            if(p.getPlayer_id()==id){
                return false;
            }
        }
        try {
            String name="";
            String sql="SELECT Player_Name FROM teamplayer WHERE Player_ID="+id+" AND User_ID='"+userName+"'";
            Statement st=connection.createStatement();
            ResultSet rs=st.executeQuery(sql);
            if(!rs.isBeforeFirst())return false;
            while(rs.next()){
                name=rs.getString("Player_Name");
                
                injuredPlayers.add(new TeamPlayer(name,id,reason));
            }
            String update1="UPDATE teamplayer SET Injury_Reserved= TRUE WHERE Player_ID="+id+" AND User_ID='"+userName+"'";
            st.executeUpdate(update1);
            int row=st.executeUpdate(update1);
            //if(row==0)return false;

            String update2="INSERT INTO injuryplayer (Player_ID,Player_Name,Reason,User_ID) VALUES (?,?,?,?)";
            PreparedStatement ps=connection.prepareStatement(update2);
            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setString(3, reason);
            ps.setString(4, userName);
            ps.executeUpdate();
           
        } catch (SQLException e) {
            System.out.println(e);
        }
        return true;
    }

    public boolean removeFromInjuryReserve() {
        if (!injuredPlayers.isEmpty()) {
            try {
                TeamPlayer p=injuredPlayers.get(0);
                injuredPlayers.remove(0);
                
                String sql="DELETE FROM injuryplayer WHERE Player_ID="+p.getPlayer_id()+" AND User_ID='"+userName+"'";
                Statement st=connection.createStatement();
                st.executeUpdate(sql);

                String update="UPDATE teamplayer SET Injury_Reserved=FALSE WHERE Player_ID="+p.getPlayer_id()+" AND User_ID='"+userName+"'";
                st.executeUpdate(update);
                
            } catch (SQLException e) {
                System.out.println(e);
            }
            return true;
            
        } else {
            return false;
        }
    }
    @Override
    public String toString(){
        StringBuilder a=new StringBuilder();
        for(TeamPlayer p:injuredPlayers){
            a.append(p.toInjureString());
            a.append("\n");
        }
        return a.toString();
    }

    // public void moveToActiveRoster(Player player) {
    //     player.setInjured(false);
    //     // Add logic to remove player from injury reserve and add back to active roster
    // }

    // public void addUserInjuredPlayer() {
    //     Scanner scanner = new Scanner(System.in);
    //     System.out.println("Enter the name of the injured player: ");
    //     String playerName = scanner.nextLine();
    //     System.out.println("Enter the reason for the injury: ");
    //     String injuryReason = scanner.nextLine();
    //     Player player = new Player(playerName, injuryReason);
    //     addToInjuryReserve(player);
    // }
}