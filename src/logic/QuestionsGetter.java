package logic;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class QuestionsGetter {

    public LinkedList<Question> get(String category) {
        Connection connection = null;
        LinkedList<Question> result = new LinkedList<>();
        ArrayList<Integer> QuestionId = new ArrayList<>();
        ArrayList<Boolean> taken = new ArrayList<>();

        final int QuestionsNumber = 5;

        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:questions.sqlite");
            connection.setAutoCommit(false);

            //id, cat, content, ans0, ans1, ans2, ans3
            Statement statement = connection.createStatement();
            String sqlQuery = "select * from Questions where cat like '" + category + "';";
            ResultSet resultSet = statement.executeQuery(sqlQuery);

            while (resultSet.next()) {
                QuestionId.add(resultSet.getInt("id"));
                taken.add(false);
            }

            Random rand = new Random();

            for (int i = 0; i < QuestionsNumber; i++) {
                int r;
                do {
                    r = rand.nextInt() % QuestionId.size();
                    if (r < 0) r = -r;
                } while (taken.get(r));

                taken.set(r, true);

                String idQuery = "select  * from Questions where id = " + QuestionId.get(r) + " ;";
                ResultSet tmp = statement.executeQuery(idQuery);

                result.add(new Question(tmp));
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

        return result;
    }
}
