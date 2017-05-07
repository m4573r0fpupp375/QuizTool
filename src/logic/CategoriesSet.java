package logic;

import java.util.Arrays;
import java.util.LinkedList;

public class CategoriesSet {
    static LinkedList <String> categories;

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
}