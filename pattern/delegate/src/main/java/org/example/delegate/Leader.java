package org.example.delegate;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 003169
 * @since Create by BowenZang on 2020-07-07 14:20:27
 */
public class Leader implements ILeader {

    private final Map<String, IEmployee> employeeMap = new HashMap<>();

    {
        employeeMap.put("cleaner", new EmployeeA());
        employeeMap.put("programmer", new EmployeeB());
    }

    @Override
    public void doSth(String task) {
        if (!employeeMap.containsKey(task)) {
            System.out.println("This task " + task + " is not my job!");
            return;
        }
        employeeMap.get(task).doSth(task);
    }
}
