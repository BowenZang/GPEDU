package cn.mark.abstractfactory;

/**
 * @author 003169
 * @since Create by BowenZang on 2020-06-15 17:36:19
 */
public class PythonVideo implements IVideo {
    @Override
    public void record() {
        System.out.println("Recording python video!");
    }
}
