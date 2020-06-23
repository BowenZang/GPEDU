package org.example.safe;

/**
 * @author 003169
 * @since Create by BowenZang on 2020-06-23 21:30:14
 */
public abstract class Directory {

    protected String name;

    public Directory(String name) {
        this.name = name;
    }

    public abstract void show();
}