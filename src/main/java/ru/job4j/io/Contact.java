package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

public class Contact implements Serializable {
    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());
    private static final long serialVersionUID = 1L;
    private final int zipCode;
    private final String phone;

    public Contact(int zipCode, String phone) {
        this.zipCode = zipCode;
        this.phone = phone;
    }

    public int getZipCode() {
        return zipCode;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public String toString() {
        return "Contact{"
               +  "zipCode=" + zipCode
                + ", phone='" + phone + '\''
                + '}';
    }

    public static void main(String[] args) throws IOException {
       final Contact contact = new Contact(123456, "+7 (111) 111-11-11");
        File tempFile = new File("contact.txt");
        try (FileOutputStream fos = new FileOutputStream(tempFile);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(contact);
        }
         try (FileInputStream fis = new FileInputStream(tempFile);
         ObjectInputStream ois = new ObjectInputStream(fis)) {
             final Contact contactFromFile = (Contact) ois.readObject();
             System.out.println(contactFromFile);
        } catch (ClassNotFoundException e) {
             LOG.debug("Class not found");
         }
    }
}
