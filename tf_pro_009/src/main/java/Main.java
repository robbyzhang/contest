import java.util.Random;

public class Main {
    static Random rn = new Random(System.currentTimeMillis());
    public static int getRandomInt(int i){
        return Math.abs(rn.nextInt())%i + 1;
    }

    public void test(){
        int num = getRandomInt(3998);

        Solution solution = new Solution();

        String expected = intToRoman(num);
        String actual = solution.intToRoman(num);
        if(!expected.equals(actual)){
            throw new RuntimeException("Input: " + num + "\nExpected:" + expected + "\nActual:" + actual + "\n");
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


    public String intToRoman(int num) {
        StringBuilder result = new StringBuilder();
        while(num > 0) {
            if (num >= 1000) {
                int times = num / 1000;
                for (int i = 0; i < times; i++) {
                    result.append("M");
                }
                num -= times * 1000;
                continue;
            }
            if (num >= 900) {
                result.append("CM");
                num -= 900;
                continue;
            }
            if (num >= 500) {
                result.append("D");
                num -= 500;
                continue;
            }
            if (num >= 400) {
                result.append("CD");
                num -= 400;
                continue;
            }
            if (num >= 100) {
                int times = num / 100;
                for (int i = 0; i < times; i++) {
                    result.append("C");
                }
                num -= times * 100;
                continue;
            }
            if (num >= 90) {
                result.append("XC");
                num -= 90;
                continue;
            }
            if (num >= 50) {
                result.append("L");
                num -= 50;
                continue;
            }
            if (num >= 40) {
                result.append("XL");
                num -= 40;
                continue;
            }
            if (num >= 10) {
                int times = num / 10;
                for (int i = 0; i < times; i++) {
                    result.append("X");
                }
                num -= times * 10;
                continue;
            }
            if (num >= 9) {
                result.append("IX");
                num -= 9;
                continue;
            }
            if (num >= 5) {
                result.append("V");
                num -= 5;
                continue;
            }
            if (num >= 4) {
                result.append("IV");
                num -= 4;
                continue;
            }
            if (num >= 1) {
                int times = num / 1;
                for (int i = 0; i < times; i++) {
                    result.append("I");
                }
                num -= times * 1;
                continue;
            }
        }
        return result.toString();
    }
}
