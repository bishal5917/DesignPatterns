package Behavioral.InterpreterMethod;

// This pattern is used to define a grammar for a simple language and provide an interpreter
// to evaluate sentences in that language

// Lets build an example where we interpret simple expressions like 1+2

interface Expression {
    int interpret();
}

class NumberExpression implements Expression {

    private final int number;

    public NumberExpression(int number) {
        this.number = number;
    }

    @Override
    public int interpret() {
        return number;
    }

}

class AddExpression implements Expression {

    private final Expression leftPart;
    private final Expression rightPart;

    public AddExpression(Expression leftPart, Expression rightPart) {
        this.leftPart = leftPart;
        this.rightPart = rightPart;
    }

    @Override
    public int interpret() {
        return leftPart.interpret() + rightPart.interpret();
    }
}

class SubtractExpression implements Expression {

    private final Expression leftPart;
    private final Expression rightPart;

    public SubtractExpression(Expression leftPart, Expression rightPart) {
        this.leftPart = leftPart;
        this.rightPart = rightPart;
    }

    @Override
    public int interpret() {
        return leftPart.interpret() - rightPart.interpret();
    }
}

public class Solution {
    // Client code
    public static void main(String[] args) {
        // construct the expression (1+2)-3
        Expression ex1 = new NumberExpression(1);
        Expression ex2 = new NumberExpression(2);
        Expression ex3 = new NumberExpression(3);

        Expression addition = new AddExpression(ex1, ex2);
        Expression subtraction = new SubtractExpression(addition, ex3);

        System.out.println(subtraction.interpret());
    }
}
