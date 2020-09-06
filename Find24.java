public class Find24 {

    public static double calculate(Double left, int op, int right) {
        if (op == 1)
            return left + right;
        else if (op == 2)
            return left - right;
        else if (op == 3)
            return left * right;
        else
            return left / right;
    }

    public static String operatorInString(int op) {
        if (op == 1)
            return "+";
        else if (op == 2)
            return "-";
        else if (op == 3)
            return "*";
        else if (op == 4)
            return "/";
        else
            return "Error";
    }

    public static double calculate(int n1, int n2, int n3, int n4, int op1, int op2, int op3) {
        double result = n1;
        result = calculate(result, op1, n2);
        result = calculate(result, op2, n3);
        result = calculate(result, op3, n4);
        return result;
    }

    public static void calculate(int n1, int n2, int n3, int n4) {
        for (int op1 = 1; op1 <= 4; op1++) {
            for (int op2 = 1; op2 <= 4; op2++) {
                for (int op3 = 1; op3 <= 4; op3++) {
                    if (calculate(n1, n2, n3, n4, op1, op2, op3) == 24) {
                        System.out.println("((" + n1 + operatorInString(op1) + n2 + ")" + operatorInString(op2) + n3 + ")"
                                + operatorInString(op3) + n4);
                    }
                }
            }
        }

    }

    public static void search(int n1, int n2, int n3, int n4) {
        int[] input = { n1, n2, n3, n4 };

        for (int a = 0; a < 4; a++) {
            for (int b = 0; b < 4; b++) {
                if (b == a)
                    continue;
                for (int c = 0; c < 4; c++) {
                    if (c == a || c == b)
                        continue;
                    for (int d = 0; d < 4; d++) {
                        if (d == a || d == b || d == c)
                            continue;
                        calculate(input[a], input[b], input[c], input[d]);
                    }
                }
            }
        }
    }
}
