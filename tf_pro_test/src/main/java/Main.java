import java.util.LinkedList;
import java.util.Random;

public class Main {
    static Random rn = new Random(System.currentTimeMillis());
    public static int getRandomInt(int i){
        return Math.abs(rn.nextInt())%i + 1;
    }

    final int maxLen = 10;

    public int[] getIntArray(){

        int len = getRandomInt(maxLen) + 10;
        int[] array = new int[len];
        for(int i=0; i<len; i++){
            array[i]= getRandomInt(100);
        }

        return array;
    }

    public int sum(int[] array) {
        int sum = 0;
        for(int a:array){
            sum += a;
        }
        return sum;
    }

    public void test(){
        int[] array = getIntArray();
        Solution solution = new Solution();
        int correct = sum(array);
        int actual = solution.sum(array);

        if(correct != actual){
            throw new RuntimeException("Test failed");
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
}
