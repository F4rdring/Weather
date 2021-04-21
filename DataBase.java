package NewLesson6;

import java.sql.*;

public class DataBase {
    private static final String DB_NAME = "weather.db";
    String insertWeather = "insert into weather (name, temprecher) values (?, ?)";

    static {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void saveWeather(String city, String temp){
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:weather.db")) {
            PreparedStatement saveWeather = connection.prepareStatement(insertWeather);
            saveWeather.setString(1, city);
            saveWeather.setString(1, temp);
            saveWeather.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
