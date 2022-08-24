package ru.job4j.ood.srp.wrong;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * условный  Singleton.
 * нарушает  srp, т.к. помимо непосредственных обязанностей,
 * занимается еще и контролированием количества своих экземпляров
 */
public class Singleton {

    public static Singleton instance;

    public static int counter = 0;
    public static String s = null;

    private Singleton(String str) {
        s =  str;
        counter++;
    }

    public static Singleton getInstance(String s) {
        if (instance == null) {
            instance = new Singleton(s);
        }
        return  instance;
    }

    public String getS() {
        return s;
    }
}

    class Realisation {

        /**
         * The entry point of application.
         * Проверка работы соединения с базой данных,
         * + проверка того,  что создаётся только один экземпляр соединения
         *
         * @param args the input arguments
         * @throws SQLException           the sql exception
         * @throws ClassNotFoundException the class not found exception
         * @throws IOException            the io exception
         */
        public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {
        System.out.println(Singleton.getInstance("txt").getS());
        System.out.println(Singleton.getInstance("txt2").getS());
        System.out.println(Singleton.getInstance("txt3").getS());

        DataBaseConection d = DataBaseConection.getInstance();
        DataBaseConection d2 = DataBaseConection.getInstance();
        DataBaseConection d3 = DataBaseConection.getInstance();

        System.out.println(d.getDatabaseName());
        System.out.println(d2.getDatabaseName());
        System.out.println(d3.getDatabaseName());

        System.out.println(d.equals(d2));
        System.out.println(d2.equals(d3));


    }
}

/**
 * The type Data base conection.
 * Демонстрация излишней логики шаблона Singleton - соединение с базой данных
 * помимо инициализации соединения класс DataBaseConection контролирует количество соих экземпляров
 */
class DataBaseConection {

    private final static String DATABASENAME = "idea_db";
    final FileInputStream file = new FileInputStream("data/app.properties");
    private final  Properties properties = new Properties();
    private static DataBaseConection instance;


    private DataBaseConection() throws SQLException, ClassNotFoundException, IOException {
        initConnection();
    }

    private void initConnection() throws SQLException, ClassNotFoundException, IOException {
        properties.load(file);
        Class.forName(properties.getProperty("postgres.connection.driver_class"));
        String url = properties.getProperty("postgres.connection.url");
        String login = properties.getProperty("postgres.connection.username");
        String password = properties.getProperty("postgres.connection.password");
        Connection connection = DriverManager.getConnection(url, login, password);
    }

    public static DataBaseConection getInstance() throws SQLException, ClassNotFoundException, IOException {
        if (instance == null) {
            instance = new DataBaseConection();
        }
        return instance;
    }

    public String getDatabaseName() {
        return DATABASENAME;
    }
}
