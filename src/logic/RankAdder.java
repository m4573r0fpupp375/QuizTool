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
            String sqlQuery = "select count(*) from Rank;";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            ResultSet resultSet = preparedStatement.executeQuery();

            Integer rankCnt = resultSet.getInt(1);

            if (rankCnt < 10) {
                sqlQuery = "insert into Rank (name, points) values (" + rankRecord.name + ", " + rankRecord.result + ");";
                preparedStatement = connection.prepareStatement(sqlQuery);
                preparedStatement.executeQuery();
            }
            else {
                sqlQuery = "select * from Rank order by 1 desc limit 1;";
                preparedStatement = connection.prepareStatement(sqlQuery);
                preparedStatement.executeQuery();

                if (resultSet.getInt(2) < rankRecord.result) {
                    sqlQuery = "delete from table from Rank where name like "
                            + resultSet.getString("name") + " and points = " + resultSet.getInt(2) + ";";
                    preparedStatement = connection.prepareStatement(sqlQuery);
                    preparedStatement.executeQuery();
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

    public static void main(String []args) {
        LinkedList<RankRecord> records = new RankGetter().get();
        for (RankRecord r : records) {
            System.out.println(r);
        }

        RankAdder rankAdder = new RankAdder();
        for (int i=0; i<12; ++i) {
            rankAdder.add(new RankRecord("Jan" + i, 69+i));
        }

        records = new RankGetter().get();
        for (RankRecord r : records) {
            System.out.println(r);
        }
    }
}
