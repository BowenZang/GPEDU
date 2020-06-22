package org.example.simple;

/**
 * @author 003169
 * @since Create by BowenZang on 2020-06-22 17:28:55
 */
public class Facade {

    private final SubSystemA subSystemA = new SubSystemA();
    private final SubSystemB subSystemB = new SubSystemB();
    private final SubSystemC subSystemC = new SubSystemC();

    // External interface
    public void doA() {
        subSystemA.doA();
    }
    public void doB() {
        subSystemB.doB();
    }
    public void doC() {
        subSystemC.doC();
    }

}
