import java.util.Random;

public class Main {
    static Random rn = new Random(System.currentTimeMillis());
    public static int getRandomInt(int i){
        return Math.abs(rn.nextInt())%i + 1;
    }


    public void test(){
        int len = 20;
        int arr[] = new int[len];
        for(int i=0; i<len; i++){
            arr[i] = getRandomInt(20);
        }
        Solution solution = new Solution();

        int expected = sum(arr);
        int actual = solution.sum(arr);
        if(expected != actual){
            throw new RuntimeException("Test failed\n");
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

    public int sum(int[] intArray) {
        int ret = 0;
        for (int i=0; i<intArray.length; i++){
            ret += intArray[0];
        }

        return ret;
    }
}
