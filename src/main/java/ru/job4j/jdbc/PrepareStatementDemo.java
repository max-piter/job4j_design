package ru.job4j.jdbc;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class PrepareStatementDemo {

    private Connection connection;
    private Properties properties;

    public PrepareStatementDemo(Properties properties) throws Exception {
        this.properties = properties;
        initConnection();
    }

    public void initConnection() throws Exception {
        Class.forName(properties.getProperty("postgres.connection.driver_class"));
        String url = properties.getProperty("postgres.connection.url");
        String login = properties.getProperty("postgres.connection.username");
        String password = properties.getProperty("postgres.connection.password");
        connection = DriverManager.getConnection(url, login, password);
    }


    public City insert(City city) {
        try (PreparedStatement statement =
                     connection.prepareStatement("insert into cities(n_name, population) values (?, ?)",
                             Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, city.getName());
            statement.setInt(2, city.getPopulation());
            statement.execute();
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    city.setId(generatedKeys.getInt(1));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return city;
    }

    public boolean update(City city) {
        boolean result = false;
        try (PreparedStatement statement =
                connection.prepareStatement("update cities set n_name = ?, population = ? where id = ?")) {
            statement.setString(1, city.getName());
            statement.setInt(2, city.getPopulation());
            statement.setInt(3, city.getId());
            result = statement.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        System.out.println(result);
        return result;

    }

    public boolean delete(int id) {
       boolean result = false;
       try (PreparedStatement statement =
                    connection.prepareStatement("delete from cities where id = ?")) {
           statement.setInt(1, id);
           result = statement.executeUpdate() > 0;
       } catch (SQLException throwables) {
           throwables.printStackTrace();
       }
       return result;
    }

    public List<City> findAll() {
        List<City> cities = new ArrayList<>();
        try (PreparedStatement statement =
                connection.prepareStatement("select * from cities")) {
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    cities.add(new City(
                           resultSet.getInt("id"),
                           resultSet.getString("n_name"),
                            resultSet.getInt("population")
                    ));
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        for (City city : cities) {
            System.out.println(city);
        }
        return cities;
    }

    public static void main(String[] args) throws Exception {
        City seatle = new City(2, "Seatle", 3500000);
        City moscow = new City(1, "Moscow", 12_000_000);
        City spb = new City(3, "Saint - Petersburg", 6_000_000);
        City lnd = new City(6, "London", 16_000_000);
        City md = new City(2, "Madrid", 16_000_000);
        try (FileInputStream file = new FileInputStream("data/app.properties")) {
            Properties properties = new Properties();
            properties.load(file);
            try {
                PrepareStatementDemo demo = new PrepareStatementDemo(properties);
                demo.initConnection();
                demo.insert(seatle);
                demo.insert(spb);
                demo.update(moscow);
                demo.delete(2);
                demo.insert(md);
                demo.findAll();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }
}
