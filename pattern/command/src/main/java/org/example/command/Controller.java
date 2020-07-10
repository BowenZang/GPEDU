package org.example.command;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 003169
 * @since Create by BowenZang on 2020-07-08 14:57:14
 */
public class Controller {

    private final List<IAction> actionList = new ArrayList<>();

    public void addAction(IAction action) {
        actionList.add(action);
    }

    public void execute(IAction action) {
        action.execute();
    }

    public void executes() {
        for (IAction each : actionList) {
            each.execute();
        }
        actionList.clear();
    }

}
