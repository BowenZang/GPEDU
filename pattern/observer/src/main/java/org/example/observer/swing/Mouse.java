package org.example.observer.swing;

/**
 * @author 003169
 * @since Create by BowenZang on 2020-07-23 10:28:22
 */
public class Mouse extends EventContext {

    public void click() {
        System.out.println("click");
        this.trigger(MouseEventTypeEnum.ON_CLICK);
    }

    public void doubleClick() {
        System.out.println("doubleClick");
        this.trigger(MouseEventTypeEnum.ON_DOUBLE_CLICK);
    }

    public void up() {
        System.out.println("up");
        this.trigger(MouseEventTypeEnum.ON_UP);
    }

    public void down() {
        System.out.println("down");
        this.trigger(MouseEventTypeEnum.ON_DOWN);
    }

    public void move() {
        System.out.println("move");
        this.trigger(MouseEventTypeEnum.ON_MOVE);
    }

    public void wheel() {
        System.out.println("wheel");
        this.trigger(MouseEventTypeEnum.ON_WHEEL);
    }

    public void over() {
        System.out.println("over");
        this.trigger(MouseEventTypeEnum.ON_OVER);
    }

    public void blur() {
        System.out.println("blur");
        this.trigger(MouseEventTypeEnum.ON_BLUR);
    }

    public void focus() {
        System.out.println("focus");
        this.trigger(MouseEventTypeEnum.ON_FOCUS);
    }

}
