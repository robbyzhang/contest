import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Main {
    Map<String, Boolean> testMap = new HashMap<String, Boolean>();

    public Main(){
        testMap.put("!(f,|(&(t,f,t),!(t)))", true);
        testMap.put("|(f,t)", true);
        testMap.put("&(t,f,(f,|(&(t,f,t),!(t)))", false);
        testMap.put("|(&(t,f,t),!(t))", false);
        testMap.put("&(t,t,t)", true);
        testMap.put("|(&(t,f,t),!(t))", false);
        testMap.put("|(f,&(t,t))", true);
        testMap.put("!(&(!(t),&(f),|(f)))", true);
        testMap.put("!(&(&(!(&(f)),&(t),|(f,f,t)),&(t),&(t,t,f)))",true);
        testMap.put("!(&(!(t),!(!(&(f))),&(&(!(&(f)),&(t),|(f,f,t)),&(t),&(t,t,f))))", true);
        testMap.put("&(&(&(&(t,t,f),|(f,f,t),|(f)),!(&(t)),!(&(|(f,f,t),&(&(f),&(!(t),&(f),|(f)),&(!(&(f)),&(t),|(f,f,t))),&(t)))),&(&(f),&(!(t),&(f),|(f)),&(!(&(f)),&(t),|(f,f,t))),&(|(f,f,t),&(&(f),&(!(t),&(f),|(f)),&(!(&(f)),&(t),|(f,f,t))),&(t)))", false);
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
//            System.out.println(k + "=" + ret + "," + v);
            if(ret != v){
                throw new RuntimeException("Input:" + k + "\nExpected:" + v + "\nActual:" + ret);
            }
        });
    }

    static Random rn = new Random(System.currentTimeMillis());
    public static int getRandomInt(int i){
        return Math.abs(rn.nextInt())%i + 1;
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
