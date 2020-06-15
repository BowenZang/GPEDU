package cn.mark.abstractfactory;

/**
 * @author 003169
 * @since Create by BowenZang on 2020-06-15 17:35:28
 */
public class JavaVideo implements IVideo {
    @Override
    public void record() {
        System.out.println("Recording java video!");
    }
}
