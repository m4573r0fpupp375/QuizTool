package logic;

import java.util.LinkedList;

public class Game {

    private LinkedList<String> bannedCategories;
    private Series series;

    public Game() {
        bannedCategories = new LinkedList<>();
    }

    public void setSeries(String category) {
        series = new Series(category);
        for (Question q : series) q.print();
    }

    public LinkedList<String> getBannedCategories() {
        return bannedCategories;
    }

    public String banCategory(String category) {
        bannedCategories.add(category);
        return category;
    }
}
