package logic;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class SpecifiedSeries extends LinkedList <Question> {
    public SpecifiedSeries(String category) {
        Connection connection = null;
        ResultSet resultSet, ChoosenSet;
        Statement statement;
        ArrayList<Integer> QuestionId = new ArrayList<Integer>();
        ArrayList<Boolean> was_or_not = new ArrayList<Boolean>();
        Random rand = new Random();
        final int QuestionsNumber = 5;

        try {
            Class.forName("org.sqlite.JDBC");
            String dir = "jdbc:sqlite:" + System.getProperty("user.dir") + "/questions.sqlite";
            connection = DriverManager.getConnection(dir);
            connection.setAutoCommit(false);

            //id, cat, content, ans0, ans1, ans2, ans3
            statement = connection.createStatement();
            String sql = "select * from Questions where cat like '" + category + "';";
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                QuestionId.add(resultSet.getInt("id"));
                was_or_not.add(false);
            }

            for(int i = 0; i < QuestionsNumber; i++) {
                int r;
                do {
                    r = rand.nextInt() % QuestionId.size();
                    if (r < 0) r = -r;
                } while (was_or_not.get(r));
                was_or_not.set(r, true);

                String sql1 = "select  * from Questions where id = " + QuestionId.get(r) + " ;";
                ChoosenSet = statement.executeQuery(sql1);

                Question Q = new Question(ChoosenSet);
                Q.permute();

                System.out.println("Pytanie " + (i + 1) + ": " + Q.getContent());
                System.out.println("A: " + Q.getMaskedAnswer(0));
                System.out.println("B: " + Q.getMaskedAnswer(1));
                System.out.println("C: " + Q.getMaskedAnswer(2));
                System.out.println("D: " + Q.getMaskedAnswer(3));
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        } finally {
            if (connection != null) try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
                System.exit(0);
            }
        }
    }
}
