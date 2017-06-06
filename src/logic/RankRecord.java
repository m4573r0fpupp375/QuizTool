package logic;

import java.util.LinkedList;

public class RankRecord extends LinkedList {
    String name;
    Integer result;

    public RankRecord(String name, Integer result) {
        this.name = name;
        this.result  = result;
    }

    public String getName(){
        return name;
    }
    public Integer getPoints(){
        return result;
    }
}
