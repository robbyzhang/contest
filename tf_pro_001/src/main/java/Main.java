import java.util.Arrays;
import java.util.Random;

public class Main {
    static Random rn = new Random(System.currentTimeMillis());
    public static int getRandomInt(int i){
        return Math.abs(rn.nextInt())%i + 1;
    }

    final int maxLen = 1000;

    public int[] getNumber(){
        int len = getRandomInt(maxLen) + 50;
        int[] ret = new int[len];
        for(int i=0; i<len; i++){
            ret[i] = getRandomInt(1000);
        }

        return ret;
    }

    public void test(){
        int[] num = getNumber();
        int[] num1 = new int[num.length];
        for(int i=0; i<num.length; i++){
            num1[i] = num[i];
        }

        Solution solution = new Solution();

        int correct = lengthOfLIS(num);
        int actual = solution.lengthOfLIS(num1);

//        System.out.println(num.length);
//        System.out.println(actual);

        if(correct != actual){
            String msg = "Test Failed\r\n";
            msg += "Input:" + arrayToString(num) + "\r\n";
            msg += "Expected:" + correct + "\r\n";
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


    public int lengthOfLIS(int[] nums) {
        if(nums==null || nums.length==0)
            return 0;
        int ans[] = new int[nums.length];
        Arrays.fill(ans,1);
        int max = 1;

        for(int i =nums.length-2;i>=0;i--){
            int prev = nums[i];
            int count = ans[i];
            for(int j = i+1;j<nums.length;j++){
                if(nums[j]>prev){
                    count=Math.max(count,ans[i]+ans[j]);
                }
            }
            ans[i]=count;
        }
        for(int i =0;i<nums.length;i++)
            max = Math.max(max,ans[i]);
        return max;
    }

}
