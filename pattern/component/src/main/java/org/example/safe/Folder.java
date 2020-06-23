package org.example.safe;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 003169
 * @since Create by BowenZang on 2020-06-23 21:32:28
 */
public class Folder extends Directory {

    private final List<Directory> directoryList = new ArrayList<>();

    private final int level;

    public Folder(String name, int level) {
        super(name);
        this.level = level;
    }

    @Override
    public void show() {
        System.out.println(name);

        for (Directory each : directoryList) {
            for (int i = 0; i < level; i++) {
                System.out.print(" ");
            }

            for (int i = 0; i < level; i++) {
                if (0 == i) {
                    System.out.print("+-");
                }
                System.out.print("-");
            }

            each.show();
        }
    }

    public void add(Directory directory) {
        directoryList.add(directory);
    }

    public void remove(Directory directory) {
        directoryList.remove(directory);
    }

    public Directory get(int index) {
        return directoryList.get(index);
    }

    public void list() {
        for (Directory each : directoryList) {
            System.out.println(each.name);
        }
    }
}
