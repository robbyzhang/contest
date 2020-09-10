import java.util.LinkedList;
import java.util.Random;

public class Main {
    static Random rn = new Random(System.currentTimeMillis());
    public static int getRandomInt(int i){
        return Math.abs(rn.nextInt())%i + 1;
    }

    final int maxLen = 1000;

    public String getNumber(){
        int len = getRandomInt(maxLen) + 50;
        String ret = "";
        for(int i=0; i<len; i++){
            ret += getRandomInt(9);
        }

        return ret;
    }

    public void test(){
        String num = getNumber();
        Solution solution = new Solution();
        int k = getRandomInt(maxLen);
        String correct = minInteger(num, k);
        String actual = solution.minInteger(num, k);

        if(!correct.equals(actual)){
            String msg = "Input : " + num + "\n";
            msg += "Expected : " + correct + "\n";
            msg += "Actual : " + actual;
            throw new RuntimeException(msg);
        }
    }

    public static void main(String[] args) {
        try {
            Main main = new Main();
            for (int i = 0; i < 20; i++) {
                main.test();
            }
        }catch (Exception ex){
            System.out.println(ex.getMessage());
            System.exit(-1);
        }
    }

    public String minInteger(String num, int k) {
        //recrod the index for 0 - 9
        LinkedList<Integer>[] list = new LinkedList[10];
        for (int i = 0; i < 10; i++) {
            list[i] = new LinkedList<Integer>();
        }
        int len = num.length();
        char[] arr = num.toCharArray();
        for (int i = 0; i < len; i++) {
            list[arr[i] - '0'].add(i);
        }

        //append the moved char
        StringBuilder res = new StringBuilder();
        //offset[i] is record the number had move befor i.
        int[] offset = new int[len];
        outer:
        // k > 0 mean we can move continue， res.length() < len  mean we have number not move.
        while (k > 0 && res.length() < len) {
            for (int i = 0; i < 10; i++) {
                if (list[i].isEmpty()){
                    continue;
                }
                //get the need move times
                int move = list[i].getFirst() - offset[list[i].getFirst()];
                if (move > k) {
                    //if move > k, we can not move it
                    continue ;
                }
                //update k
                k -= move;
                // remove the used index in list
                int index = list[i].removeFirst();
                //append the moved number
                res.append(arr[index]);
                //update arr[index] = 0,  record we had used it
                arr[index] = 0;
                //update offset
                for (int j = index + 1; j < len; j++) {
                    offset[j]++;
                }
                continue outer;
            }
        }
        //if we have not moved num, we append it one by one.
        for (int i = 0; i < len; i++) {
            if (arr[i] != 0) {
                res.append(arr[i]);
            }
        }
        return res.toString();
    }
}
