public class Player {
    private String fullName;
    private boolean isInjured;
    private String injury;
    private boolean isInContractExtensionQueue;
    private boolean isContractRenewed;
    private double points;
    private int rebounds;
    private int assists;
    private int steals;
    private int blocks;
    private double score; // Score to prioritize players

    public Player(String fullName, String injury) {
        this.fullName = fullName;
        this.injury = injury;
        this.isInjured = true;
    }

    // Getter and setter methods for points
    public double getPoints() {
        return points;
    }

    public void setPoints(double points) {
        this.points = points;
    }

    // Getter and setter methods for rebounds
    public int getRebounds() {
        return rebounds;
    }

    public void setRebounds(int rebounds) {
        this.rebounds = rebounds;
    }

    // Getter and setter methods for assists
    public int getAssists() {
        return assists;
    }

    public void setAssists(int assists) {
        this.assists = assists;
    }

    // Getter and setter methods for steals
    public int getSteals() {
        return steals;
    }

    public void setSteals(int steals) {
        this.steals = steals;
    }

    // Getter and setter methods for blocks
    public int getBlocks() {
        return blocks;
    }

    public void setBlocks(int blocks) {
        this.blocks = blocks;
    }

    // Getter and setter methods for score
    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getFullName() {
        return fullName;
    }

    public String getInjury() {
        return injury;
    }

    public boolean setInjured(boolean b) {
        return isInjured;
    }

    // All thse getter and setter methods are just temporary write
    // Later will need to replace with the database query to get each value from the player's statistics
}