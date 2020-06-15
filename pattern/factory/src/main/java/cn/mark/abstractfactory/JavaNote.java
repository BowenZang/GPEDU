package cn.mark.abstractfactory;

/**
 * @author 003169
 * @since Create by BowenZang on 2020-06-15 17:37:03
 */
public class JavaNote implements INote {
    @Override
    public void edit() {
        System.out.println("Editing java note");
    }
}
