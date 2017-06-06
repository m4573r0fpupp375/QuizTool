package logic;

import controllers.SoloSummaryController;

public class SoloGame extends Game {
    private String player;
    private Integer points;

    public SoloGame(){
        this.player = "unknow";
        this.points = 0;
    }

    public SoloGame(String nick, Integer points){
        this.player = nick;
        this.points = points;
    }

    public String getPlayer() {
        return player;
    }

    public void setPlayer(String player) {
        this.player = player;
    }

    public Integer getPlayerpoints(){
        return points;
    }

    public void setPlayerpoints(Integer points){
        this.points = points;
    }
}
