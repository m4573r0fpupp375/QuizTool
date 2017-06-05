package logic;

import java.sql.*;
import java.util.LinkedList;

public class RankAdder {

    public void add(RankRecord rankRecord) {
        Connection connection = null;
        if (rankRecord.name == null || rankRecord.name.equals("")) rankRecord.name = "'unknown'";

        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:questions.sqlite");
            connection.setAutoCommit(false);

            //name, result
            String sqlQuery = "SELECT COUNT(*) FROM Rank";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            ResultSet resultSet = preparedStatement.executeQuery();

            Integer rankCnt = resultSet.getInt(1);

            if (rankCnt < 10) {
                sqlQuery = "INSERT INTO Rank(name, points) VALUES (?, ?)";
                preparedStatement = connection.prepareStatement(sqlQuery);
                preparedStatement.setString(1, rankRecord.name);
                preparedStatement.setInt(2, rankRecord.result);
                System.out.println(preparedStatement);
                preparedStatement.executeUpdate();
                connection.commit();
            } else {
                sqlQuery = "SELECT * FROM Rank ORDER BY 2 LIMIT 1";
                preparedStatement = connection.prepareStatement(sqlQuery);
                resultSet = preparedStatement.executeQuery();

                String prevName = resultSet.getString("name");
                Integer prevResult = resultSet.getInt("points");

                if (prevResult < rankRecord.result) {
                    sqlQuery = "DELETE FROM Rank WHERE name LIKE ? AND points = ?";
                    preparedStatement = connection.prepareStatement(sqlQuery);
                    preparedStatement.setString(1, prevName);
                    preparedStatement.setInt(2, prevResult);
                    preparedStatement.executeUpdate();
                    connection.commit();


                    sqlQuery = "INSERT INTO Rank VALUES (?, ?);";
                    preparedStatement = connection.prepareStatement(sqlQuery);
                    preparedStatement.setString(1, rankRecord.name);
                    preparedStatement.setInt(2, rankRecord.result);
                    preparedStatement.executeUpdate();
                    connection.commit();
                }
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
