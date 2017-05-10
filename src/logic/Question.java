package logic;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

public class Question {
    private int id;
    private int[] mask = {0, 1, 2, 3};
    private String content;
    private String category;
    private String[] answers = new String[4];
    private AnsState state = AnsState.NONE;

    public Question(ResultSet resultSet) throws SQLException {
        id = resultSet.getInt("id");
        content = resultSet.getString("content");
        category = resultSet.getString("cat");
        for (int i = 0; i < 4; i++) {
            answers[i] = resultSet.getString("ans" + i);
        }
    }

    void permute() {
        Random rand = new Random();
        int r1, r2, tmp;

        for (int i = 0; i < 21; i++) {
            r1 = rand.nextInt() % 4;
            r2 = rand.nextInt() % 4;
            if (r1 < 0) r1 = -r1;
            if (r2 < 0) r2 = -r2;

            if (r1 == r2) continue;

            tmp = mask[r1];
            mask[r1] = mask[r2];
            mask[r2] = tmp;
        }
    }

    public AnsState getState() {
        return state;
    }

    public void answer(int index) {
        if (mask[index] == 0) {
            state = AnsState.GOOD;
        } else state = AnsState.BAD;
    }

    public String getCategory() {
        return category;
    }

    public String getContent() {
        return content;
    }

    public String getAnswer(int index) {
        return answers[index];
    }

    public int getId() {
        return id;
    }

    public int getMask(int index) {
        return mask[index];
    }

    public String getMaskedAnswer(int index) {
        return getAnswer(getMask(index));
    }

    public void permuteDebug() {
        System.out.println("permute debug info:");
        for (int i=0; i<4; ++i) {
            System.out.println(i + " " + mask[i]);
        }
    }

    public void print() {
        System.out.println(getId() + ". " + getCategory());
        System.out.println(getContent());
        for (String s : answers) System.out.println(s);
    }

    public void printMasked() {
        System.out.println(getId() + ". " + getCategory());
        System.out.println(getContent());
        for (int i : mask) System.out.println(getMaskedAnswer(i));
    }
}