package org.example.observer.swing;

/**
 * @author 003169
 * @since Create by BowenZang on 2020-07-23 10:28:45
 */
public class MouseEventListener implements EventListener {

    public void onClick(Event event) {
        System.out.println("onClick : " + event);
    }

    public void onDoubleClick(Event event) {
        System.out.println("onDoubleClick : " + event);
    }

    public void onUp(Event event) {
        System.out.println("onUp : " + event);
    }

    public void onDown(Event event) {
        System.out.println("onDown : " + event);
    }

    public void onMove(Event event) {
        System.out.println("onMove : " + event);
    }

    public void onWheel(Event event) {
        System.out.println("onWheel : " + event);
    }

    public void onOver(Event event) {
        System.out.println("onOver : " + event);
    }

    public void onBlur(Event event) {
        System.out.println("onBlur : " + event);
    }

    public void onFocus(Event event) {
        System.out.println("onFocus : " + event);
    }

}
