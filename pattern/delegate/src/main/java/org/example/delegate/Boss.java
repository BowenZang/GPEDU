package org.example.delegate;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 003169
 * @since Create by BowenZang on 2020-07-07 14:24:06
 */
public class Boss {

    private final Map<String, ILeader> leaderMap = new HashMap<>();

    {
        leaderMap.put(Leader.class.getName(), new Leader());
    }

    public void askTask(Class<? extends ILeader> clazz, String task) {
        if (!leaderMap.containsKey(clazz.getName())) {
            System.out.println("I need a new leader to do this task : " + task);
            return;
        }
        leaderMap.get(clazz.getName()).doSth(task);
    }
}
