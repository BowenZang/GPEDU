package org.example.template;

/**
 * @author 003169
 * @since Create by BowenZang on 2020-07-07 15:38:34
 */
public class JavaCourse extends AbstractCourse {

    private boolean needCheckHomework = false;

    public void setNeedCheckHomework(boolean needCheckHomework) {
        this.needCheckHomework = needCheckHomework;
    }

    @Override
    protected boolean needCheckHomework() {
        return this.needCheckHomework;
    }

    @Override
    protected void checkHomework() {
        System.out.println("检查Java作业");
    }

}
