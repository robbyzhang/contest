import java.util.HashMap;
import java.util.Map;

public class Main {
    Map<String, Boolean> testMap = new HashMap<String, Boolean>();

    public Main(){
        testMap.put("!(f)", true);
        testMap.put("|(f,t)", true);
        testMap.put("&(t,f)", false);
        testMap.put("|(&(t,f,t),!(t))", false);
    }


    public static void main(String[] args) {
        try {
            Main main = new Main();
            main.test();
        }catch (Exception ex){
            System.out.println(ex.getMessage());
            System.exit(-1);
        }
    }

    private void test() {
        Solution solution = new Solution();
        testMap.forEach( (k,v) ->{
            boolean ret = solution.parseBoolExpr(k);
            if(ret != v){
                throw new RuntimeException("Input:" + k + "\nExpected:" + v + "\nActual:" + ret);
            }
        });
    }

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
