package logic;

import java.sql.*;
import java.util.LinkedList;

public class RankGetter {

    public LinkedList<RankRecord> get() {
        Connection connection = null;
        LinkedList<RankRecord> result = new LinkedList<>();

        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:questions.sqlite");
            connection.setAutoCommit(false);

            //name, result
            String sqlQuery = "select * from Rank order by 2 limit 10;";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                result.add(new RankRecord(resultSet.getString("name"), resultSet.getInt("points")));

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
