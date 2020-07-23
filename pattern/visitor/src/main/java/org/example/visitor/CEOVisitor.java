package org.example.visitor;

/**
 * @author 003169
 * @since Create by BowenZang on 2020-07-23 11:25:15
 */
public class CEOVisitor implements IVisitor {
    @Override
    public void visit(Engineer engineer) {
        System.out.println("Engineer : " + engineer.name + ", KPI : " + engineer.kpi);
    }

    @Override
    public void visit(Manager manager) {
        System.out.println("Manager : " + manager.name + ", KPI : " + manager.kpi + ", products : " + manager.getProducts());
    }
}
