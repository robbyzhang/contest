import java.util.Random;

public class Main {
    static Random rn = new Random(System.currentTimeMillis());
    public static int getRandomInt(int i){
        return Math.abs(rn.nextInt())%i + 1;
    }

    int[] genCards(){
        int len = getRandomInt(10000);
        int[] array = new int[len];
        for(int i=0; i<len; i++){
            array[i] = getRandomInt(10000);
        }

        return array;
    }

    public void test(){
        int cards[] = genCards();
        String input = arrayToString(cards);
        int k = getRandomInt(cards.length) - 1;

        Solution solution = new Solution();

        int expected = maxScore(cards, k);
        int actual = solution.maxScore(cards, k);
        if(expected != actual){
            String msg = "Test Failed\n";
            msg += "K=" + k;
            msg += "Input:" + input + "\n";
            msg += "Expected:" + expected + "\n";
            msg += "Actual:" + actual;
            throw new RuntimeException(msg);
        }
    }

    private String arrayToString(int[] num) {
        String ret = "[";
        for(int i=0; i<num.length; i++){
            if(i != num.length -1){
                ret += num[i] + ",";
            }else{
                ret += num[i];
            }
        }
        return ret + "]";
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
    public int maxScore(int[] cardPoints, int k) {
        int total_pts = 0;
        int sum = 0;
        int n = cardPoints.length;
        for (int i = 0; i < n; i++)
        {
            total_pts += cardPoints[i];
            if (i < n - k)
                sum += cardPoints[i];
        }

        int max = total_pts - sum;
        for (int i = 0; i < k; i++)
        {
            sum = sum - cardPoints[i];
            sum = sum + cardPoints[n-k+i];
            max = Math.max(max, total_pts - sum);
        }
        return max;
    }
}
