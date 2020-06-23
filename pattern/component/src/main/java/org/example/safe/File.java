package org.example.safe;

/**
 * @author 003169
 * @since Create by BowenZang on 2020-06-23 21:31:37
 */
public class File extends Directory {

    public File(String name) {
        super(name);
    }

    @Override
    public void show() {
        System.out.println(this.name);
    }
}
