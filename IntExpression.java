public class IntExpression extends Expression {
    private int _value;

    public IntExpression(int value) {
        _value = value;
    }

    @Override
    public int evaluate() {
        return _value;
    }

    @Override
    public String toString() {
        return String.valueOf(_value);
    }
}