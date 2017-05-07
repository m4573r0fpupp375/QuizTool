package logic;

import java.util.LinkedList;

public class Series extends LinkedList<Question> {

    public Series(String category) {
        QuestionsGetter getter = new QuestionsGetter();
        this.addAll(getter.get(category));;
    }

}
