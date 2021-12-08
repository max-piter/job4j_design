package ru.job4j.serialization.json;

import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.job4j.io.UsageLog4j;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PojoJSON {
    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("student");
        list.add("Free");
        JSONArray jsonStatuses = new JSONArray(list);


        final Person person = new Person("Jack", true, 45,
                new Contact("+7(924)111-111-11-11"), new String[]{"worker", "divorsed"});

        List<JSONObject> jsonObjects = new ArrayList<>();

        JSONObject jsonContact = new JSONObject(new Contact("+7(924)111-111-11-11"));
        JSONObject jsonCarNumber = new JSONObject(new CarNumber("AB3445-45C"));
        JSONObject jsonPerson = new JSONObject(person);
        jsonObjects.add(jsonPerson);
        jsonObjects.add((jsonCarNumber));
        jsonObjects.add(jsonContact);
        System.out.println(jsonObjects);


        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", person.getName());
        jsonObject.put("sex", person.isSex());
        jsonObject.put("age", person.getAge());
        jsonObject.put("contact", jsonContact);
        jsonObject.put("statuses", jsonStatuses);

        try (FileWriter fW = new FileWriter("test2.jason")) {
            fW.write(String.valueOf(jsonObjects));
        } catch (IOException e) {
           LOG.error(("File not Found"));
        }



        System.out.println(jsonObject);
        System.out.println(new JSONObject(person));
    }
}
