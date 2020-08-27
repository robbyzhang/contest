class Solution {
    public boolean parseBoolExpr(String expression) {
        if (expression.length() == 1) return expression.equals("t");
        char op = expression.charAt(0);

        if (op == '!') return !parseBoolExpr(expression.substring(2, expression.length() - 1));

        boolean res = op == '&';

        int i = 2;
        boolean current;
        while (i < expression.length()) {
            if (expression.charAt(i) == '!' || expression.charAt(i) == '&' || expression.charAt(i) == '|') {
                int j = i + 2;
                int stack = 1;
                while (stack != 0) {
                    if (expression.charAt(j) == '(') stack++;
                    if (expression.charAt(j) == ')') stack--;
                    j++;
                }
                current = parseBoolExpr(expression.substring(i, j));
                i = j + 1;
            } else {
                current = expression.charAt(i) == 't';
                i += 2;
            }
            res = op == '&' ? res && current : res || current;
        }

        return res;
    }

}