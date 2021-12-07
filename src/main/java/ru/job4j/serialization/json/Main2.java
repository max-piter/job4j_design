package ru.job4j.serialization.json;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.job4j.io.UsageLog4j;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;

public class Main2 {
    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) throws JAXBException {

        Car ford = new Car("Ford Explorer", true, 4.1,
                new CarNumber("AD3456-78R"),
                new Person("John",
                        false,
                        35,
                        new Contact("11-11-11-11"),
                        new String[] {"WASP", "widower"}),
                new String[]{"24.09.2009", "11.09.2014", "29.12.2020"});

        JAXBContext context = JAXBContext.newInstance(Car.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        String xml = "";
        try (StringWriter writer = new StringWriter()) {
            marshaller.marshal(ford, writer);
            xml = writer.getBuffer().toString();
            System.out.println(xml);
            try (FileOutputStream fos = new FileOutputStream("Car2.xml")) {
                fos.write(xml.getBytes());
            }
        } catch (IOException e) {
            LOG.error("Some Error");
        }

        Unmarshaller unMarsh = context.createUnmarshaller();
        Car carFord = (Car) unMarsh.unmarshal(new File("Car2.xml"));
        System.out.println(carFord);


    }
}
