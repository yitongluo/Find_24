public abstract class BinaryExpression extends Expression {

    private Expression _left;
    private Expression _right;

    protected BinaryExpression(Expression left, Expression right) {
        _left = left;
        _right = right;
    }

    @Override
    public int evaluate() {
        return evaluate(_left.evaluate(), _right.evaluate());
    }

    protected abstract int evaluate(int left, int right);

    @Override
    public String toString() {
        return "(" + _left.toString() + getOperatorString() + _right.toString() + ")";
    }

    protected abstract String getOperatorString();
}