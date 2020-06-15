package cn.mark.abstractfactory;

import cn.mark.abstractfactory.factory.ICourseFactory;
import cn.mark.abstractfactory.factory.JavaCourseFactory;
import cn.mark.abstractfactory.factory.PythonCourseFactory;

/**
 * @author 003169
 * @since Create by BowenZang on 2020-06-15 17:42:06
 */
public class AbstractFactoryTest {

    public static void main(String[] args) {
        ICourseFactory courseFactory1 = new JavaCourseFactory();
        courseFactory1.createNote().edit();
        courseFactory1.createVideo().record();

        ICourseFactory courseFactory2 = new PythonCourseFactory();
        courseFactory2.createNote().edit();
        courseFactory2.createVideo().record();
    }

}
