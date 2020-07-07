package org.example.delegate;

/**
 * @author 003169
 * @since Create by BowenZang on 2020-07-07 14:11:04
 */
public class EmployeeA implements IEmployee {

    private final String goodAt = "clean";

    @Override
    public void doSth(String task) {
        System.out.println("I'm marry, I can do " + goodAt + ", I begin do "+ task + " at now");
    }
}
