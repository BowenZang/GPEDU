package org.example.interpreter;

/**
 * @author 003169
 * @since Create by BowenZang on 2020-07-23 09:22:36
 */
public class AddInterpreter extends Interpret {

    public AddInterpreter(IArithmeticInterpreter left, IArithmeticInterpreter right) {
        super(left, right);
    }

    @Override
    public int interpret() {
        return this.left.interpret() + this.right.interpret();
    }
}
