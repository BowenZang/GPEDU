package org.example.interpreter;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 003169
 * @since Create by BowenZang on 2020-07-23 09:28:38
 */
public class OperatorUtils {

    private static final Map<String, Class<? extends IArithmeticInterpreter>> interpreterHashMap = new HashMap<>();

    static {
        interpreterHashMap.put("+", AddInterpreter.class);
        interpreterHashMap.put("-", SubInterpreter.class);
        interpreterHashMap.put("*", MultiInterpreter.class);
        interpreterHashMap.put("/", DivInterpreter.class);
    }

    public static boolean isOperator(String symbol) {
        return interpreterHashMap.containsKey(symbol);
    }

    public static IArithmeticInterpreter getInterpret(IArithmeticInterpreter left, IArithmeticInterpreter right, String symbol) {
        Class<? extends IArithmeticInterpreter> clazz = interpreterHashMap.get(symbol);

        if (null != clazz) {
            try {
                Constructor<? extends IArithmeticInterpreter> declaredConstructor = clazz.getDeclaredConstructor(IArithmeticInterpreter.class, IArithmeticInterpreter.class);
                return declaredConstructor.newInstance(left, right);
            } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

}
