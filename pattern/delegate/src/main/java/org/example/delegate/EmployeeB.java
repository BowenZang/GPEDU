package org.example.delegate;

/**
 * @author 003169
 * @since Create by BowenZang on 2020-07-07 14:11:04
 */
public class EmployeeB implements IEmployee {

    private final String goodAt = "program";

    @Override
    public void doSth(String task) {
        System.out.println("I'm mark, I can do " + goodAt + ", I begin do "+ task + " at now");
    }
}
