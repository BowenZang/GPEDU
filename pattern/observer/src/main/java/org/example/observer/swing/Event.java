package org.example.observer.swing;

import java.lang.reflect.Method;

/**
 * @author 003169
 * @since Create by BowenZang on 2020-07-23 10:25:53
 */
public class Event {

    private Object source;

    private EventListener listener;

    private Method callback;

    private MouseEventTypeEnum trigger;

    private long time;

    public Event(EventListener listener, Method callback) {
        this.listener = listener;
        this.callback = callback;
    }

    public Object getSource() {
        return source;
    }

    public Event setSource(Object source) {
        this.source = source;
        return this;
    }

    public EventListener getListener() {
        return listener;
    }

    public Event setListener(EventListener listener) {
        this.listener = listener;
        return this;
    }

    public Method getCallback() {
        return callback;
    }

    public Event setCallback(Method callback) {
        this.callback = callback;
        return this;
    }

    public MouseEventTypeEnum getTrigger() {
        return trigger;
    }

    public Event setTrigger(MouseEventTypeEnum trigger) {
        this.trigger = trigger;
        return this;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Event{" +
                "source=" + source +
                ", listener=" + listener +
                ", callback=" + callback +
                ", trigger='" + trigger + '\'' +
                ", time=" + time +
                '}';
    }
}
