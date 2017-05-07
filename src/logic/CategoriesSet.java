package logic;

import java.util.Arrays;
import java.util.LinkedList;

public class CategoriesSet {
    static LinkedList <String> cats;

    static {
        String[] categories = {
                "Geografia",
                "Polska",
                "Historia Polski",
                "Sport",
                "Muzyka",
                "Trach"
        };

        cats = new LinkedList<String>();
        cats.addAll(Arrays.asList(categories));
    }
}