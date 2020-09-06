public class DivideExpression extends BinaryExpression {

    public static DivideExpression Create(Expression left, Expression right) {
        int rightValue = right.evaluate();
        if (rightValue == 0)
            return null;

        int leftValue = left.evaluate();
        if (leftValue % rightValue != 0)
            return null;

        return new DivideExpression(left, right);
    }

    private DivideExpression(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    protected int evaluate(int left, int right) {
        return left / right;
    }

    @Override
    protected String getOperatorString() {
        return "/";
    }
}