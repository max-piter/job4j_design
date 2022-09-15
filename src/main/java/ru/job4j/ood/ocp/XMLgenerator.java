package ru.job4j.ood.ocp;

import ru.job4j.ood.srp.Employee;
import ru.job4j.ood.srp.Report;
import ru.job4j.ood.srp.Store;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.IOException;
import java.io.StringWriter;
import java.util.List;
import java.util.function.Predicate;

public class XMLgenerator implements Report {

    private Store store;
    private JAXBContext context;
    private Marshaller marshaller;

    public XMLgenerator(Store store) throws JAXBException {
        this.store = store;
        context = JAXBContext.newInstance(EmployeeList.class);
        marshaller = context.createMarshaller();
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        String xml = "";
        try {
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            try (StringWriter writer = new StringWriter()) {
                marshaller.marshal(new EmployeeList(store.findBy(filter)), writer);
                xml = writer.getBuffer().toString();
            }
        } catch (IOException | JAXBException e) {
            e.printStackTrace();
        }
        return xml;
    }

    @XmlRootElement(name = "employees")
    private static class EmployeeList {
        @XmlElement(name = "employee")
        List<Employee> employees;

        public EmployeeList() {
        }

        public EmployeeList(List<Employee> employees) {
            this.employees = employees;
        }
    }

}
