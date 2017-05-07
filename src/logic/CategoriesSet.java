package logic;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;

public class CategoriesSet {

    static LinkedList<String> categories;

    static {
        String[] categories = {
                "Geografia",
                "Polska",
                "Historia Polski",
                "Sport",
                "Muzyka",
                "Trach"
        };

        CategoriesSet.categories = new LinkedList<String>();
        CategoriesSet.categories.addAll(Arrays.asList(categories));
    }

    public String getCategory(LinkedList<String> banned) {
        Random rand = new Random();
        int r;
        do {
            r = rand.nextInt() % categories.size();
            r = r < 0 ? -r : r;
        } while (banned.contains(categories.get(r)));
        return categories.get(r);
    }
}