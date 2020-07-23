package org.example.interpreter;

/**
 * @author 003169
 * @since Create by BowenZang on 2020-07-23 09:22:36
 */
public class NumInterpreter implements IArithmeticInterpreter {

    private final int value;

    public NumInterpreter(int value) {
        this.value = value;
    }

    @Override
    public int interpret() {
        return this.value;
    }
}
