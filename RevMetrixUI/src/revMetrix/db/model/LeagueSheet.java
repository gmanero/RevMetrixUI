package revMetrix.db.model;

public class LeagueSheet {
    private String date;
    private String lge;
    private String lanes;
    private int game1;
    private int game2;
    private int game3;
    private int series;
    private int totalGames;
    private int average;
    private String strikes;
    private String strikeTotal;
    private double strikeAverage;
    private String spares;
    private String spareTotal;
    private double spareAverage;

    public LeagueSheet(String date, String lge, String lanes, int game1, int game2, int game3, int series,
                        int totalGames, int average, String strikes, String strikeTotal, double strikeAverage, String spares,
                        String spareTotal, double spareAverage) {
        this.date = date;
        this.lge = lge;
        this.lanes = lanes;
        this.game1 = game1;
        this.game2 = game2;
        this.game3 = game3;
        this.series = series;
        this.totalGames = totalGames;
        this.average = average;
        this.strikes = strikes;
        this.strikeTotal = strikeTotal;
        this.strikeAverage = strikeAverage;
        this.spares = spares;
        this.spareTotal = spareTotal;
        this.spareAverage = spareAverage;
    }

    // Getters and setters
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }

    public String getLge() {
        return lge;
    }
    public void setLge(String lge) {
        this.lge = lge;
    }

    public String getLanes() {
        return lanes;
    }
    public void setLanes(String lanes) {
        this.lanes = lanes;
    }

    public int getGame1() {
        return game1;
    }
    public void setGame1(int game1) {
        this.game1 = game1;
    }

    public int getGame2() {
        return game2;
    }
    public void setGame2(int game2) {
        this.game2 = game2;
    }

    public int getGame3() {
        return game3;
    }
    public void setGame3(int game3) {
        this.game3 = game3;
    }

    public int getSeries() {
        return series;
    }
    public void setSeries(int series) {
        this.series = series;
    }

    public int getTotalGames() {
        return totalGames;
    }
    public void setTotalGames(int totalGames) {
        this.totalGames = totalGames;
    }

    public int getAverage() {
        return average;
    }
    public void setAverage(int average) {
        this.average = average;
    }

    public String getStrikes() {
        return strikes;
    }
    public void setStrikes(String strikes) {
        this.strikes = strikes;
    }

    public String getStrikeTotal() {
        return strikeTotal;
    }
    public void setStrikeTotal(String strikeTotal) {
        this.strikeTotal = strikeTotal;
    }

    public double getStrikeAverage() {
        return strikeAverage;
    }
    public void setStrikeAverage(double strikeAverage) {
        this.strikeAverage = strikeAverage;
    }

    public String getSpares() {
        return spares;
    }
    public void setSpares(String spares) {
        this.spares = spares;
    }

    public String getSpareTotal() {
        return spareTotal;
    }
    public void setSpareTotal(String spareTotal) {
        this.spareTotal = spareTotal;
    }

    public double getSpareAverage() {
        return spareAverage;
    }
    public void setSpareAverage(double spareAverage) {
        this.spareAverage = spareAverage;
    }
}