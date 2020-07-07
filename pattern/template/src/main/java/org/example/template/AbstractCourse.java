package org.example.template;

/**
 * @author 003169
 * @since Create by BowenZang on 2020-07-07 15:33:02
 */
public abstract class AbstractCourse {
    public final void createCourse() {
        // 1、发布预习资料
        postPreResource();

        // 2、制作课件
        createPPT();

        // 3、直播授课
        liveVideo();

        // 4、上传课后资料
        postResource();

        // 5、布置作业
        postHomework();

        if (needCheckHomework()) {
            checkHomework();
        }
    }

    protected void postPreResource() {
        System.out.println("上传预习资料");
    }

    protected void createPPT() {
        System.out.println("制作课件");
    }

    protected void liveVideo() {
        System.out.println("开始授课");
    }

    protected void postResource() {
        System.out.println("上传课后资料");
    }

    protected void postHomework() {
        System.out.println("布置作业");
    };

    protected abstract void checkHomework();

    protected boolean needCheckHomework() {return false;}

}
