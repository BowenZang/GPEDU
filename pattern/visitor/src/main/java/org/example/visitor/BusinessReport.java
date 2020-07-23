package org.example.visitor;

import java.util.LinkedList;
import java.util.List;

/**
 * @author 003169
 * @since Create by BowenZang on 2020-07-23 11:18:43
 */
public class BusinessReport {

    private final List<Employee> employeeList = new LinkedList<>();

    public BusinessReport() {
        employeeList.add(new Manager("Manger-A"));
        employeeList.add(new Manager("Manger-B"));
        employeeList.add(new Engineer("engineer-A"));
        employeeList.add(new Engineer("engineer-B"));
        employeeList.add(new Engineer("engineer-C"));
        employeeList.add(new Engineer("engineer-D"));
    }

    public void showReport(IVisitor visitor) {
        for (Employee each : employeeList) {
            each.accept(visitor);
        }
    }
}
