package org.example.observer.swing;

/**
 * @author 003169
 * @since Create by BowenZang on 2020-07-23 10:26:43
 */
public enum MouseEventTypeEnum {

    ON_CLICK("click"),
    ON_DOUBLE_CLICK("doubleClick"),
    ON_UP("up"),
    ON_DOWN("down"),
    ON_MOVE("move"),
    ON_WHEEL("wheel"),
    ON_OVER("over"),
    ON_BLUR("blur"),
    ON_FOCUS("focus");

    private final String eventType;

    MouseEventTypeEnum(String eventType) {
        this.eventType = eventType;
    }

    public String getEventType() {
        return eventType;
    }
}
