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
        series.permuteAll();
        //for (Question q : series) q.printMasked();
    }

    public LinkedList<String> getBannedCategories() {
        return bannedCategories;
    }

    public String banCategory(String category) {
        bannedCategories.add(category);
        return category;
    }

    public Series getSeries() { return series; }
}
