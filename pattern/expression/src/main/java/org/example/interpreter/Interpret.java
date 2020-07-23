package org.example.interpreter;

/**
 * 终结表达式角色抽象类
 * @author 003169
 * @since Create by BowenZang on 2020-07-23 09:21:11
 */
public abstract class Interpret implements IArithmeticInterpreter {
    protected IArithmeticInterpreter left;
    protected IArithmeticInterpreter right;

    public Interpret(IArithmeticInterpreter left, IArithmeticInterpreter right) {
        this.left = left;
        this.right = right;
    }
}
