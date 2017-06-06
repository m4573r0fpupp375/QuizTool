package logic;

import java.util.LinkedList;

public class RankRecord extends LinkedList {
    String name;
    Integer points;

    public RankRecord(String name, Integer points) {
        this.name = name;
        this.points = points;
    }

    public String getName(){
        return name;
    }
    public Integer getPoints(){
        return points;
    }
}
