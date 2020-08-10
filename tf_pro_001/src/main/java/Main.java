import java.util.Random;

public class Main {
    public static void test(){
        int n = getRandomInt(15);
        int arr[] = new int[n];
        for(int i=0; i<n ; i++){
            arr[i] = getRandomInt(20);
        }

//        System.out.println(arrToString(arr));

        int target = getRandomInt(40);
        int[] expectedArr = twoSum(arr, target);


        Solution solution = new Solution();
        int[] ret = solution.twoSum(arr, target);

        if(ret == null){
            throw new RuntimeException("Returned value is wrong");
        }

        if(ret.length != 2){
            throw new RuntimeException("DReturned value is wrong");
        }

        if(ret[0] != expectedArr[0] || ret[1] != expectedArr[1]){
            String input = arrToString(arr);
            String expected = arrToString(expectedArr);
            String actual = ret[0] + "," + ret[1];
            String error = String.format("Input : %s\nTarget : %s\nExpected : %s\nActual : %s\n", input, target, expected, actual);
            throw new RuntimeException(error);
        }
    }

    private static String arrToString(int[] arr) {
        String ret = "[";
        for(int i:arr){
            ret = ret + i + ",";
        }
        ret = ret.substring(0, ret.length()-1);
        return ret + "]";
    }

    static Random rn = new Random(System.currentTimeMillis());
    public static int getRandomInt(int max){
        return Math.abs(rn.nextInt())%max+1;
    }

    public static int[] twoSum(int[] numbers, int target) {
        int ans[] = new int [2];
        int p1 = 0;
        int p2 = numbers.length-1;

        while(p1<p2){

            int sum = numbers[p1] + numbers[p2];

            if(sum == target){
                ans[0] = p1+1;
                ans[1]= p2+1;
                break;
            }
            else if (sum < target) p1++;
            else p2--;
        }
        return ans;
    }

    public static void main(String[] args) {
        try {
            for(int i=0; i<20; i++) {
                test();
            }
        }catch (Exception ex){
            System.out.println(ex.getMessage());
            System.exit(-1);
        }
    }
}
