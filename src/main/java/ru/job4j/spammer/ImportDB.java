package ru.job4j.spammer;

import ru.job4j.jdbc.TableEditor;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ImportDB {

    private final Properties cfg;
    private final String dump;

    public ImportDB(Properties cfg, String dump) {
        this.cfg = cfg;
        this.dump = dump;
    }

    public List<User> load()  {
        List<User> users = new ArrayList<>();
        try (BufferedReader rd = new BufferedReader(new FileReader(dump))) {
             rd.lines()
                     .filter(l -> l.split(";").length > 1 && l.split(";")[1].contains("@"))
                     .forEach(l -> users.add(new User(l.split(";")[0], l.split(";")[1])));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return users;
    }

    public void save(List<User> users) throws ClassNotFoundException, SQLException {
        Class.forName(cfg.getProperty("jdbc.driver"));
        try (Connection cnt = DriverManager.getConnection(
                cfg.getProperty("jdbc.url"),
                cfg.getProperty("jdbc.username"),
                cfg.getProperty("jdbc.password")
        )) {
            for (User user : users) {
                try (PreparedStatement ps = cnt.prepareStatement("insert into users (name, email) values (?, ?);")) {
                    ps.setString(1, user.name);
                    ps.setString(2, user.email);
                    ps.execute();
                }
            }
        }
    }

    private static class User {
        String name;
        String email;

        public User(String name, String email) {
            this.name = name;
            this.email = email;
        }

        @Override
        public String toString() {
            return "User{"
                 +  "name='" + name + '\''
                 +  ", email='" + email + '\''
                  + '}';
        }
    }


    public static void main(String[] args) throws Exception {

        Properties cfg = new Properties();
        try (FileInputStream in = new FileInputStream("data/app_spammer.properties")) {
            cfg.load(in);
        }

        TableEditor table = new TableEditor(cfg);
        table.createTable("users");
        table.addColumn("users", "id", "serial primary key");
        table.addColumn("users", "name", "varchar(255)");
        table.addColumn("users", "email", "varchar(255)");

        ImportDB db = new ImportDB(cfg, "src/main/java/ru/job4j/spammer/dump.txt");
        db.save(db.load());


    }
}
