package cn.mark.factorymethod;

/**
 * @author 003169
 * @since Create by BowenZang on 2020-06-15 16:55:35
 */
public class FactoryMethodTest {

    public static void main(String[] args) {
        ICourseFactory courseFactory1 = new JavaCourseFactory();
        courseFactory1.create().record();

        ICourseFactory courseFactory2 = new PythonCourseFactory();
        courseFactory2.create().record();
    }

}
