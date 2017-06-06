package logic;

public class DuelGame extends Game {
    private String player1;
    private String player2;
    private Integer player1points;
    private Integer player2points;

    public DuelGame(){
        player1 = player2 = "unknow";
        player1points = player2points = 15;
    }

    public DuelGame(String nick1, Integer points1, String nick2, Integer points2){
        this.player1 = nick1;
        this.player1points = points1;
        this.player2 = nick2;
        this.player2points = points2;
    }

    public String getPlayer1() {
        return player1;
    }

    public void setPlayer1(String player1) {
        this.player1 = player1;
    }

    public String getPlayer2() {
        return player2;
    }

    public void setPlayer2(String player2) {
        this.player2 = player2;
    }

    public Integer getPlayer1points(){
        return player1points;
    }

    public void setPlayer1points(Integer points){
        this.player1points = points;
    }

    public Integer getPlayer2points(){
        return player2points;
    }

    public void setPlayer2points(Integer points){
        this.player2points = points;
    }
}
