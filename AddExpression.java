public class AddExpression extends BinaryExpression {

    public AddExpression(Expression left, Expression right) {
        super(left, right);
    }

    protected int evaluate(int left, int right) {
        return left + right;
    }

    @Override
    protected String getOperatorString() {
        return "+";
    }
}