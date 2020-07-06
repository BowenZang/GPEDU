package org.example.gp;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 003169
 * @since Create by BowenZang on 2020-06-24 10:37:20
 */
public class Tree extends AbstractTree {

    private final List<AbstractTree> treeList = new ArrayList<>();
    private final int level;

    public Tree(String nodeName, int level) {
        super(nodeName);
        this.level = level;
    }

    @Override
    public void print() {
        System.out.println(nodeName);
        for (AbstractTree each : treeList) {
            for (int i = 0; i < this.level; i++) {
                System.out.print("../");
            }
            each.print();
        }
    }

    public void addNode(AbstractTree tree) {
        treeList.add(tree);
    }

    public void rmNode(AbstractTree tree) {
        treeList.remove(tree);
    }

}
