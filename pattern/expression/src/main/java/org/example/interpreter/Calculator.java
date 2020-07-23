package org.example.interpreter;

import java.util.Stack;

/**
 * @author 003169
 * @since Create by BowenZang on 2020-07-23 09:25:38
 */
public class Calculator {

    private final Stack<IArithmeticInterpreter> stack = new Stack<>();

    public Calculator(String expression) {
        this.parse(expression);
    }

    private void parse(String expression) {

        String[] elements = expression.split(" ");
        IArithmeticInterpreter left, right;

        for (int i = 0; i < elements.length; i++) {
            String operator = elements[i];
            if (OperatorUtils.isOperator(elements[i])) {
                left = this.stack.pop();
                right = new NumInterpreter(Integer.parseInt(elements[++i]));
                System.out.println("出栈：" + left.interpret() + "和" + right.interpret());
                this.stack.push(OperatorUtils.getInterpret(left, right, operator));
                System.out.println("运用运算符： " + operator);
            } else {
                NumInterpreter numInterpreter = new NumInterpreter(Integer.parseInt(elements[i]));
                this.stack.push(numInterpreter);
                System.out.println("入栈：" + numInterpreter.interpret());
            }
        }

    }

    public int calculate() {
        return this.stack.pop().interpret();
    }

}
