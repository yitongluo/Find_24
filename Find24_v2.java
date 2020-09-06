public class Find24_v2 {

    private static String[] operators = new String[] { "+", "-", "*", "/" };

    public static void search(int value1, int value2, int value3, int value4) {
        search(new Expression[] { new IntExpression(value1), new IntExpression(value2), new IntExpression(value3),
                new IntExpression(value4) });
    }

    private static void search(Expression[] current) {
        if (current.length == 1) {
            Expression expression = current[0];
            if (expression.evaluate() == 24)
                System.out.println(expression);
            return;
        }

        Expression[] next = new Expression[current.length - 1];
        for (int left = 0; left < current.length; left++) {
            for (int right = 0; right < current.length; right++) {
                if (right == left)
                    continue;

                filter(current, left, right, next);

                for (int i = 0; i < operators.length; i++) {
                    Expression newExpression = CreateExpression(current[left], current[right], operators[i]);
                    if (newExpression == null)
                        continue;

                    next[next.length - 1] = newExpression;
                    search(next);
                }
            }
        }
    }

    private static void filter(Expression[] current, int left, int right, Expression[] next) {
        int count = 0;
        for (int i = 0; i < current.length; i++) {
            if (i == left || i == right)
                continue;
            next[count++] = current[i];
        }
    }

    private static Expression CreateExpression(Expression left, Expression right, String operator) {
        if (operator.equals("+"))
            return new AddExpression(left, right);
        else if (operator.equals("-"))
            return new SubstractExpression(left, right);
        else if (operator.equals("*"))
            return new MultiplyExpression(left, right);
        else if (operator.equals("/"))
            return DivideExpression.Create(left, right);
        else
            return null;
    }
}