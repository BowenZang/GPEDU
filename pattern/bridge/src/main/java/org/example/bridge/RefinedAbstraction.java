package org.example.bridge;

/**
 * @author 003169
 * @since Create by BowenZang on 2020-07-06 20:02:22
 */
public class RefinedAbstraction extends Abstraction {

    public RefinedAbstraction(IImplementor implementor) {
        super(implementor);
    }

    @Override
    public void operation() {
        super.operation();
        System.out.println("refined operation");
    }
}
