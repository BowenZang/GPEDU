package org.example.observer.swing;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 003169
 * @since Create by BowenZang on 2020-07-23 10:26:17
 */
public abstract class EventContext {

    protected final Map<MouseEventTypeEnum, Event> eventMap = new HashMap<>();

    public void addListener(MouseEventTypeEnum eventTypeEnum, EventListener listener, Method callback) {
        eventMap.put(eventTypeEnum, new Event(listener, callback));
    }

    public void addListener(MouseEventTypeEnum eventTypeEnum, EventListener listener) {
        try {
            eventMap.put(eventTypeEnum, new Event(listener, listener.getClass().getMethod("on" + toUpperFirstCase(eventTypeEnum.getEventType()), Event.class)));
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    private String toUpperFirstCase(String eventType) {
        char[] chars = eventType.toCharArray();
        chars[0] -= 32;
        return String.valueOf(chars);
    }

    private void trigger(Event event) {
        event.setSource(this);
        event.setTime(System.currentTimeMillis());
        if (event.getCallback() != null) {
            try {
                event.getCallback().invoke(event.getListener(), event);
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }

    protected void trigger(MouseEventTypeEnum trigger) {
        if (!this.eventMap.containsKey(trigger)) {
            return;
        }
        trigger(this.eventMap.get(trigger).setTrigger(trigger));
    }
}
