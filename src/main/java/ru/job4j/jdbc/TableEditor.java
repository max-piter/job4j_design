package ru.job4j.jdbc;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.StringJoiner;


public class TableEditor implements AutoCloseable {

    private Connection connection;

    private final Properties properties;

    public TableEditor(Properties properties) throws SQLException, ClassNotFoundException {
        this.properties = properties;
        initConnection();
    }

    private void initConnection() throws SQLException, ClassNotFoundException {
        Class.forName(properties.getProperty("postgres.connection.driver_class"));
        String url = properties.getProperty("postgres.connection.url");
        String login = properties.getProperty("postgres.connection.username");
        String password = properties.getProperty("postgres.connection.password");
        connection = DriverManager.getConnection(url, login, password);
    }

    private void statement(String querySQL, String tableName) throws Exception {
        try (Statement statement = connection.createStatement()) {
            statement.execute(querySQL);
        }
        System.out.println(getTableScheme(connection, tableName));
    }

    public void createTable(String tableName) throws Exception {
        statement(String.format("CREATE TABLE if not exists %s();", tableName), tableName);
    }

    public void dropTable(String tableName) throws Exception {
        statement(String.format("DROP TABLE if exists %s;", tableName), tableName);
    }

    public void addColumn(String tableName, String columnName, String type) throws Exception {
        statement(String.format("ALTER TABLE %s ADD column if not exists %s %s;",
                tableName, columnName, type), tableName);
    }

    public void dropColumn(String tableName, String columnName) throws Exception {
        statement(String.format("ALTER TABLE %s DROP column %s;", tableName, columnName), tableName);

    }

    public void renameColumn(String tableName, String columnName, String newColumnName) throws Exception {
        statement(String.format("ALTER TABLE %s RENAME column %s to %s;", tableName, columnName, newColumnName), tableName);
    }


    public static String getTableScheme(Connection connection, String tableName) throws Exception {
        var rowSeparator = "-".repeat(30).concat(System.lineSeparator());
        var header = String.format("%-15s|%-15s%n", "NAME", "TYPE");
        var buffer = new StringJoiner(rowSeparator, rowSeparator, rowSeparator);
        buffer.add(header);
        try (var statement = connection.createStatement()) {
            var selection = statement.executeQuery(String.format(
                    "select * from %s limit 1", tableName
            ));
            var metaData = selection.getMetaData();
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                buffer.add(String.format("%-15s|%-15s%n",
                        metaData.getColumnName(i), metaData.getColumnTypeName(i))
                );
            }
        }
        return buffer.toString();
    }

    @Override
    public void close() throws Exception {
        if (connection != null) {
            connection.close();
        }
    }

    public static void main(String[] args) throws Exception {
        String tableName = "first_table";
        String columnName = "first_column";
        String dataType = "varchar(255)";
        String newColumnName = "second_column";

        try (FileInputStream file = new FileInputStream("data/app.properties")) {
            Properties properties = new Properties();
            properties.load(file);
            try (TableEditor table = new TableEditor(properties)) {
                table.createTable(tableName);
                table.dropTable(tableName);
                table.addColumn(tableName, columnName, dataType);
                table.dropColumn(tableName, columnName);
                table.renameColumn(tableName, columnName, newColumnName);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
