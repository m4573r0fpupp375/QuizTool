package logic;

import java.util.LinkedList;

public class RankRecord extends LinkedList {
    String name;
    Integer result;

    RankRecord(String name, Integer result) {
        this.name = name;
        this.result  = result;
    }
}
