public class MultiplyExpression extends BinaryExpression {
    public MultiplyExpression(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    protected int evaluate(int left, int right) {
        return left * right;
    }

    @Override
    protected String getOperatorString() {
        return "*";
    }
}